package com.test.app.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;

public class BoardDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private final String BOARD_INSERT="insert into board values((select nvl(max(bid),0)+1 from board),?,?,?)";
	private final String BOARD_SELECTONE="select * from board where bid=?";
	private final String BOARD_SELECTALL_TITLE="select * from board where title like '%'||?||'%' order by bid desc";
	private final String BOARD_SELECTALL_WRITER="select * from board where writer like '%'||?||'%' order by bid desc";
	private final String BOARD_SELECTALL_CONTENT="select * from board where content like '%'||?||'%' order by bid desc";
	private final String BOARD_UPDATE="update board set title=?,content=? where bid=?";
	private final String BOARD_DELETE="delete board where bid=?";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard() 호출됨");
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard() 호출됨");
		BoardVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_SELECTONE);
			pstmt.setInt(1, vo.getBid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	// 검색을 위한 비즈니스 메서드를 따로 작성xxx
	// 인자변경 -> 불리점 => VO에 멤버변수로 추가!
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList() 호출됨");
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_SELECTALL_TITLE);
			pstmt.setString(1, vo.getSearchKeyword());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	public void updateBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public void deleteBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
}
