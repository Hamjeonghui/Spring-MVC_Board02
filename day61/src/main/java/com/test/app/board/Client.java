package com.test.app.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client { // 클라이언트,사용자,브라우저
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		BoardVO boardVO=new BoardVO();
		boardVO.setTitle("어노테이션 실습");
		boardVO.setContent("진짜되나??");
		boardVO.setWriter("작은 티모");
		bs.insertBoard(boardVO);
		
		List<BoardVO> datas=bs.getBoardList(boardVO);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		
		factory.close();
		
	}
}
