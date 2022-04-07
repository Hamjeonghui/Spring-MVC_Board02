package com.test.app.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;

@Service("boardService")
// Shape: Circle,Rect,Tri,...
// @Component: @Service,@Repository,@Controller,...
public class BoardServiceImpl implements BoardService {

	@Autowired // DI
	private BoardDAO2 boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		
		/// if(vo.getBid()==0) { throw new IllegalArgumentException("내가만든예외!"); }
		
		boardDAO.insertBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

}
