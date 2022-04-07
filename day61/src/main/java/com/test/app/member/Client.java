package com.test.app.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");
		MemberVO vo=new MemberVO();
		vo.setId("test");
		vo.setPassword("12345");
		vo=ms.getMember(vo);
		if(vo==null) {
			System.out.println("로그인 실패!");
		}
		else {
			System.out.println(vo.getName()+"님, 로그인 성공!");
		}
		
		factory.close();
	}
}
