package com.test.app.member;

// 메서드 시그니처 강제
public interface MemberService {
	public MemberVO getMember(MemberVO vo);
	public void insertMember(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
}
