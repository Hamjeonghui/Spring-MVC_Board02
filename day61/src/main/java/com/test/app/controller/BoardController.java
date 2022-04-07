package com.test.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;

@Controller // ★x100
// 1. <bean> -> @Controller
// 2. implements Controller 필요없음 -> 제거
// 3. 메서드 강제 사라짐!!!
// 4. 완전한 POJO가 되었다!!!!!
// 		-> req,res,...가 존재하지않음 => 경량의 객체
@SessionAttributes("data") // data라는 이름의 정보가 Model에 들어온다면, session에 기억해둬라! ☆
public class BoardController {
	// 1. Controller 교체
	// 2. 반환타입의 변경 -> ModelAndView(무엇을 보낼지_정보_datas,data,member,... + 어디로 가야하는지_경로)

	@ModelAttribute("conMap") // @RequestMapping이 설정된 메서드보다 먼저 수행됨
	public Map<String,String> searchConditionMap() {
		Map<String,String> conMap=new HashMap<String,String>();
		conMap.put("제목", "title");
		conMap.put("작성자", "writer");
		conMap.put("내용", "content");
		return conMap; // 반환값은 자동으로 Model에 저장
	}
	
	@RequestMapping(value="/main.do")
	public String getBoardList(BoardVO vo,BoardDAO boardDAO,Model model) {
		// 검색 로직 추가할 예정
		List<BoardVO> datas=boardDAO.getBoardList(vo);
		model.addAttribute("datas",datas); // Model을 이용하여 전달할 정보를 저장!
		return "main.jsp";
	}
	@RequestMapping(value="/board.do")
	public String getBoard(BoardVO vo,BoardDAO boardDAO,Model model) {
		vo=boardDAO.getBoard(vo);
		model.addAttribute("data", vo); // ☆
		return "board.jsp";
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "redirect:main.do";
	}
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo,BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "redirect:main.do";
	}
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo,BoardDAO boardDAO) {  // ☆
		System.out.println(" null 업데이트 이슈 확인: "+vo.getWriter()); // session에 저장해둔 정보가 먼저 setter
		System.out.println(" null 업데이트 이슈 확인: "+vo.getTitle()); // 이후에 파라미터로 들어온 정보가 나중에 setter
		System.out.println(" null 업데이트 이슈 확인: "+vo.getContent());
		boardDAO.updateBoard(vo);
		return "redirect:main.do";
	}
}
