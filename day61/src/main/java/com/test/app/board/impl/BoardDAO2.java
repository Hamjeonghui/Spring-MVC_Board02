package com.test.app.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO2 {
	// Spring에서 제공하는 JDBC.JDBCTemplate
	// 1) JDBCTemplate의 모습을 정해놓은 클래스가 존재 -> 상속받아서 만드는 방법
	// 2) JDBCTemplate을 <bean>으로 생성해서 DI ★
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT="insert into board values((select nvl(max(bid),0)+1 from board),?,?,?)";
	private final String BOARD_SELECTONE="select * from board where bid=?";
	private final String BOARD_SELECTALL="select * from board order by bid desc";
	private final String BOARD_SELECTALL_TITLE="select * from board where title like '%'||?||'%' order by bid desc";
	private final String BOARD_SELECTALL_WRITER="select * from board where writer like '%'||?||'%' order by bid desc";
	private final String BOARD_SELECTALL_CONTENT="select * from board where content like '%'||?||'%' order by bid desc";
	private final String BOARD_UPDATE="update board set title=?,content=? where bid=?";
	private final String BOARD_DELETE="delete board where bid=?";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard() 호출됨");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard() 호출됨");
		Object[] args= {vo.getBid()};
		return jdbcTemplate.queryForObject(BOARD_SELECTONE, args, new BoardRowMapper());
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList() 호출됨");
		return jdbcTemplate.query(BOARD_SELECTALL, new BoardRowMapper());
	}
	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(),vo.getContent(),vo.getBid());
	}
	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_DELETE, vo.getBid());
	}

}
class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setBid(rs.getInt("bid"));
		data.setContent(rs.getString("content"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		return data;
	}
	
}
