package idv.ytchang.springboot1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//super.configure(http);
		
		http
		.authorizeRequests() // 定義須被保護URL		
		.antMatchers("/").permitAll() // 入口 URL'/' 不須驗證
		.antMatchers("/admin").hasRole("ADMIN") // ADMIN角色可訪問 /admin 底下資源
		.antMatchers("/user").hasRole("USER") // USER角色可訪問 /user 底下資源
		.anyRequest().authenticated() // 其他尚未匹配的URL不限角色，仍要驗證再使用		
		.and()
		.formLogin() // 預設登入頁面
		.and()
		.httpBasic(); // 基本HTTP驗證
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//super.configure(auth);
		
		// 指定加密機制. 並加密通行碼
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String adminPassword = bCryptPasswordEncoder.encode("abc123");
		String user1Password = bCryptPasswordEncoder.encode("2234");
		
		// 定義驗證帳號 放在記憶體中
		auth.inMemoryAuthentication()
		.passwordEncoder(bCryptPasswordEncoder) // spring security 5.7+ 要求使用加密機制，否則報錯 IllegalArgumentException
		.withUser("admin").password(adminPassword).roles("ADMIN","USER")
		.and()
		.withUser("user1").password(user1Password).roles("USER");
		
	}
	
	

}
