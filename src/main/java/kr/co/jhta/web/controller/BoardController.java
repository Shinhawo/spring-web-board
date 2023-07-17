package kr.co.jhta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	// 새 게시글 등록화면 요청과 매핑되는 요청핸들러 메서드
	
	// 새 게시글 등록 요청과 매핑되는 요청핸들러 메서드
	
	// 최신 게시글 목록(가장 최근에 등록된 게시글 10개)요청과 매핑되는 요청핸들러 메서드
	
	// 게시글 상세정보 화면 요청과 매핑되는 요청핸들러 메서드
	
	// 게시글 삭제 요청과 매피되는 요청 핸들러 메서드
	
	// 게시글 수정화면 요청과 매핑되는 요청핸들러 메서드
	
	// 게시글 수정요청과 매핑되는 요청핸들러 메서드
}
