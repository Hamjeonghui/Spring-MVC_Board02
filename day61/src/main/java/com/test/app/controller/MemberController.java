package com.test.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.app.member.MemberVO;
import com.test.app.member.impl.MemberDAO;

@Controller
public class MemberController {
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(@ModelAttribute("user")MemberVO vo) {
		System.out.println(" GET로 login.do요청");
		vo.setId("test");
		vo.setPassword("1234");
		return "login.jsp";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(MemberVO vo,MemberDAO memberDAO,HttpSession session) {
		System.out.println(" POST로 login.do요청");
		vo=memberDAO.getMember(vo);
		if(vo==null){
			return "redirect:login.jsp";
		}
		session.setAttribute("member", vo);
		return "redirect:main.do";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.jsp";
	}
	@RequestMapping("/insertMember.do")
	public String insertMember(MemberVO vo,MemberDAO memberDAO,ModelAndView mav) {
		memberDAO.insertMember(vo);
		return "redirect:login.jsp";
	}
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo,MemberDAO memberDAO,ModelAndView mav) {
		memberDAO.deleteMember(vo);
		return "redirect:login.jsp";
	}
	@RequestMapping("/updateMember.do")
	public String updateMember(MemberVO vo,MemberDAO memberDAO,ModelAndView mav) {
		memberDAO.updateMember(vo);
		return "redirect:main.do";
	}
}
