package booking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import booking.dto.ClientDto;
import booking.service.BookingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookingControllerLogin {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/booking/login.do")
	public String login() {
		return "/booking/home";
	}
	
	@RequestMapping("/booking/loginCheck.do")
	public String loginCheck(@RequestParam String clientId, @RequestParam String clientPwd, HttpServletRequest request) throws Exception {
		
//		service를 통하여 mapper와 연결 : 동일하게 있는지 없는지 확인
//		int count = bookingService.selectUserInfoYN(clientId, clientPwd);
		ClientDto client = bookingService.selectUserInfoYN(clientId, clientPwd);
		
//		userId와 userPwd가 잘 들어 왔는지 확
		log.debug("----login controller----");
		log.debug("clientId : " + clientId);
		log.debug("clientPWD : " + clientPwd);

	
		if (client.getClientId() != null || !client.getClientId().equals("")) {
			
//			현재 서버에 접속한 클라이언트의 세션 정보를 불러옴 
			HttpSession session = request.getSession();
			
//			해당 세션에 userId라는 키를 생성하고 그 키에 대응하는 값을 설정함
			session.setAttribute("clientId", client.getClientId());
			session.setAttribute("firstName", client.getFirstName());
			session.setAttribute("lastName", client.getLastName());
			session.setAttribute("phone", client.getPhone());
			session.setAttribute("email", client.getEmail());
			
//			해당 세션이 살아있을 수 있는 시간 설정 
			session.setMaxInactiveInterval(3600);
			
			return "redirect:/booking/home.do";
		}
		else {
			return "redirect:/booking/loginFail.do";
		}

//		db의 결과값을 기준으로 세션 생성 혹은 로그인 오류 페이지로 리다이렉트 
//		return "/board2/login.do";
	}
	
//	@RequestMapping("/board2/loginOk.do")
//	public ModelAndView loginOk(HttpServletRequest request) throws Exception {
//		
//		log.debug("loginOk");
//		HttpSession session = request.getSession();
//		
//		ClientDto user = new ClientDto();
//		user.setClientId((String) session.getAttribute("clientId"));
//		
//		ModelAndView mv = new ModelAndView("/booking/home.do?clientId=");
//		mv.addObject("user", user);
//		
//		return mv;
//	}
	
	@RequestMapping("/booking/loginFail.do")
	public String loginFail() throws Exception {
		return "/booking/loginFail";
	}
	
	@RequestMapping("/booking/logout.do")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// 사용자가 입력한 세션 속성을 삭제
		session.removeAttribute("clientId");
		
		// 현재 모든 세션 정보를 삭제
		session.invalidate();
		
		return "redirect:/booking/home.do";
	}
}
