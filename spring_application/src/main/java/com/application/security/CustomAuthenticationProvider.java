package com.application.security;

import java.sql.SQLException;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.application.dto.MemberVO;
import com.application.service.MemberService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private MemberService memberService;
	public CustomAuthenticationProvider(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login_id = (String) auth.getPrincipal(); // 로그인 시도한 ID를 가져온다
		String login_pwd = (String) auth.getCredentials(); // 로그인 시도한 Password 를 가져온다.
		
		try {
			MemberVO member = memberService.getMember(login_id);
			
			if(member==null) throw new UsernameNotFoundException("존재하지 않는 아이디입니다.");
			if(!member.getPwd().equals(login_pwd)) 
							throw new BadCredentialsException("패스워드가 일치하지 않습니다.");
			
			UserDetails authUser = new User(member);
			
			boolean invalidCheck = authUser.isAccountNonExpired() 
					&& authUser.isAccountNonLocked()
					&& authUser.isCredentialsNonExpired() 
					&& authUser.isEnabled();
			
			if (!invalidCheck) 
					throw new InsufficientAuthenticationException("유효하지 않는 계정입니다."); 
			
			//로그인 성공
			// 스프링 시큐리티 내부 클래스로 인증 토큰 생성한다.
			UsernamePasswordAuthenticationToken result  
								= new UsernamePasswordAuthenticationToken(
								  authUser.getUsername(), authUser.getPassword(), 
								  authUser.getAuthorities());
			// 전달할 내용을 설정한 후
			result.setDetails(authUser);
			// 리턴한다. successHandler로 전송된다.
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuthenticationServiceException("서버 장애로 서비스가 불가합니다.");
	
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

