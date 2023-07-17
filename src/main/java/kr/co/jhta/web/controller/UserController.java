package kr.co.jhta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.UserService;
import kr.co.jhta.vo.User;
import kr.co.jhta.web.form.AddUserForm;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	// 사용자 등록화면 요청과 매핑되는 요청핸들러 메서드
	@GetMapping("/register")
	public String form(Model model) {
		
		return "user/registerform";
	}
	
	// 사용자 등록 요청과 매핑되는 요청핸들러 메서드
	@PostMapping("/register")
	public String createUser(AddUserForm form) {
		
		userService.createUser(form);
		return "redirect:/";
	}
	
	// 로그인 화면 요청과 매핑되는 요청핸들러 메서드
	@GetMapping("/login")
	public String login() {
		
		return "user/loginform";
	}
	
	// 내정보보기 화면 요청과 매핑되는 요청핸들러 메서드
	
	// 내정보수정화면 요청과 매핑되는 요청핸들러 메서드
	
	// 내정보 수정 요청과 매핑되는 요청핸들러 메서드
	
	
}
