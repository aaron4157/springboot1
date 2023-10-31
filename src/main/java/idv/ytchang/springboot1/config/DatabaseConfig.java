package idv.ytchang.springboot1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

	@Autowired
	Environment env;
	
	public DatabaseConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean(name="dataSource")
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
          
        driverManagerDataSource.setUrl(env.getProperty("spring.datasource.url"));
        driverManagerDataSource.setUsername(env.getProperty("spring.datasource.username"));
        driverManagerDataSource.setPassword(env.getProperty("spring.datasource.password"));
        driverManagerDataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name", "org.postgresql.Driver"));      
          
        return driverManagerDataSource;
    }

}
