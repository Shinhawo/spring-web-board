package kr.co.jhta.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.service.BoardService;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.User;
import kr.co.jhta.web.form.AddBoardForm;
import kr.co.jhta.web.model.BoardList;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	// 새 게시글 등록화면 요청과 매핑되는 요청핸들러 메서드
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public String form() {
		
		return "board/form";
	}
	
	// 새 게시글 등록 요청과 매핑되는 요청핸들러 메서드
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String createBoard(@AuthenticationPrincipal User user, AddBoardForm form) {
		form.setUser(user);
		boardService.createBoard(form);
		return "redirect:list";
	}
	
	// 최신 게시글 목록(가장 최근에 등록된 게시글 10개)요청과 매핑되는 요청핸들러 메서드
	@GetMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "1") int page, 
					   @RequestParam(name = "rows", required = false, defaultValue = "10") int rows,
					   Model model) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page", page);
		param.put("rows", rows);
		
	    BoardList result = boardService.getBoards(param);
	    model.addAttribute("result", result);
		
		
		return "board/list";
	}
	
	// 게시글 상세정보 화면 요청과 매핑되는 요청핸들러 메서드
	@GetMapping("/detail")
	public Board detail(@RequestParam("no") int boardNo,
						@AuthenticationPrincipal User user, Model model) {
		Board board = boardService.getBoardByNo(boardNo);

		board.setReadCount(board.getReadCount() + 1);
		
		boardService.updateBoard(board);
		
		model.addAttribute("user", user);
		
		return board;
	}
	
	// 게시글 삭제 요청과 매피되는 요청 핸들러 메서드
	
	// 게시글 수정화면 요청과 매핑되는 요청핸들러 메서드
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify")
	public String updateForm(@RequestParam("no") int boardNo, Model model) {
		Board board = boardService.getBoardByNo(boardNo);
		model.addAttribute("board", board);
		
		return "board/modifyform";
	}
	
	// 게시글 수정요청과 매핑되는 요청핸들러 메서드
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify")
	public String update(@RequestParam("no") int boardNo,
						 @RequestParam("title") String title,
						 @RequestParam("content") String content) {
		
		Board board = boardService.getBoardByNo(boardNo);
		
		board.setTitle(title);
		board.setContent(content);
		
		boardService.updateBoard(board);
		
		return "redirect:detail?no="+boardNo;
	}
}
