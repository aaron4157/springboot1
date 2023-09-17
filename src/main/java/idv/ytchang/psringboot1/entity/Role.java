package idv.ytchang.psringboot1.entity;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	
	private Integer id;
	private String role_name;

	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role_name;
	}
	
	public void setAuthority(String roleName) {
		this.role_name = roleName;
	}

}
