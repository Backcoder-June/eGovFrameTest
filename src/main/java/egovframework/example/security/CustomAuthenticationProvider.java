package egovframework.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import egovframework.example.sample.service.entities.UserVO;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

		System.out.println("authentication : " + authentication);

		String loginUserName = String.valueOf(authentication.getPrincipal());
		String loginPassword = String.valueOf(authentication.getCredentials());
		System.out.println("loginUserName : " + loginUserName);
		System.out.println("loginPassword : " + loginPassword);

		UserVO user = (UserVO) userDetailsService.loadUserByUsername(loginUserName);

		if(!matchPassword(loginPassword, user.getPassword())) {

			System.out.println();

			throw new BadCredentialsException(loginUserName);
		}

		if(!user.isEnabled()) {
			throw new BadCredentialsException(loginUserName);
		}


		return new UsernamePasswordAuthenticationToken(loginUserName, loginPassword, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean matchPassword(String loginPassword, String password) {

		return loginPassword.equals(password);

	}


}