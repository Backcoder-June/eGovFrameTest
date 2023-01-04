package egovframework.example.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import egovframework.example.sample.service.entities.UserVO;
import egovframework.example.sample.service.impl.UserMapper;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("customuser exec");

		UserVO user = userMapper.getUserById(userName);
		

		if(user == null) {
			System.out.println("custom null");
			throw new UsernameNotFoundException(userName);
		}

		return user;
	}


}