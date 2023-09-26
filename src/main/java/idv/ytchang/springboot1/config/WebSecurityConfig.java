package idv.ytchang.springboot1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import idv.ytchang.springboot1.service.SpringUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	SpringUserService springUserService;
	
	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {		
		
		http
		.authorizeRequests() // 定義須被保護URL		
		.antMatchers("/").permitAll() // 入口 URL'/' 不須驗證		
		.antMatchers("/admin").hasRole("ADMIN") // ROLE_ADMIN角色可訪問 /admin 底下資源
		.antMatchers("/user").hasRole("USER") // ROLE_USER角色可訪問 /user 底下資源
		.anyRequest().authenticated() // 其他尚未匹配的URL不限角色，仍要驗證再使用		
		.and()
		.formLogin() // 預設登入頁面
		.and()
		.httpBasic(); // 基本HTTP驗證
		
		return http.build();
	}
	
	
	/**
	 * 執行這一段，打印加密通行碼
	 * @param args
	 */
	public static void main(String... args) {
		// 指定加密機制. 並加密通行碼
		PasswordEncoder bCryptPasswordEncoder = passwordEncoder();
		String adminPassword = bCryptPasswordEncoder.encode("abc123"); // password for admin
		String user1Password = bCryptPasswordEncoder.encode("2234"); // password for user1
		
		System.out.println(adminPassword);
		System.out.println(user1Password);
				
	}
	

}
