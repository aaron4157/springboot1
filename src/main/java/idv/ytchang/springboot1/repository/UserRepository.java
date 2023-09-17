package idv.ytchang.springboot1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import idv.ytchang.psringboot1.entity.Role;
import idv.ytchang.psringboot1.entity.User;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDetails getUserByUsername(String username) {
		User user;
		List<Role> roles;
		String sql = "select * from public.user where username = ? and is_account_non_expired = true";
		String subSql = "select id, role_name authority from public.user_role a join public.role b on a.role_id = b.id where a.user_id = ?";
		
		user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
		roles = jdbcTemplate.query(subSql, new BeanPropertyRowMapper<>(Role.class), user.getId());
		
		user.setAuthorities(roles);
		
		return user;
	}
	
	

}
