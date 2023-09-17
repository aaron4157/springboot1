package idv.ytchang.springboot1.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import idv.ytchang.psringboot1.entity.User;
import idv.ytchang.springboot1.repository.UserRepository;

@Service
public class SpringUserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	public SpringUserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails appUser = userRepository.getUserByUsername(username);
		
		if(appUser == null) throw new UsernameNotFoundException(String.format("Username invalid: %s", username));
		
		//System.out.println("login: "+appUser.getUsername());
		//System.out.println("roles:"+appUser.getAuthorities().stream().map(obj->obj.getAuthority()).collect(Collectors.toList()));
		
		return appUser;
	}

}
