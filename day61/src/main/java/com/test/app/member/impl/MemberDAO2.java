package com.test.app.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.member.MemberVO;

@Repository
public class MemberDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String MEMBER_SELECTONE="select * from member where id=? and password=?";
	private final String MEMBER_INSERT="insert into member values(?,?,?,?)";
	private final String MEMBER_UPDATE="update member set password=? where id=?";
	private final String MEMBER_DELETE="delete member where id=?";
	public MemberVO getMember(MemberVO vo) {
		System.out.println("Advice 동작시점: getMember() 수행됨");
		Object[] args= {vo.getId(),vo.getPassword()};
		MemberVO data=null;
		try {
			data=jdbcTemplate.queryForObject(MEMBER_SELECTONE, args, new MemberRowMapper());
		}catch(Exception e) {
			System.out.println("     MemberDAO2   28번 라인");
		}
		return data;
	}
	public void insertMember(MemberVO vo) {
		jdbcTemplate.update(MEMBER_INSERT,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
	public void updateMember(MemberVO vo) {
		jdbcTemplate.update(MEMBER_UPDATE,vo.getPassword(),vo.getId());
	}
	public void deleteMember(MemberVO vo) {
		jdbcTemplate.update(MEMBER_DELETE,vo.getId());
	}
}
class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}