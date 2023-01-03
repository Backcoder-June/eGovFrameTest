package egovframework.example.sample.service.impl;

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

		UserVO user = userMapper.getUserById(userName);

		if(user == null) {
			throw new UsernameNotFoundException(userName);
		}

		return user;
	}


}