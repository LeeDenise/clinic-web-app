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
		
		ClientDto client = bookingService.selectUserInfoYN(clientId, clientPwd); // connects the mapper with service
		
		log.debug("----login controller----");
		log.debug("clientId : " + clientId);
		log.debug("clientPWD : " + clientPwd);
	
		if (client.getClientId() != null || !client.getClientId().equals("")) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("clientId", client.getClientId());
			session.setAttribute("firstName", client.getFirstName());
			session.setAttribute("lastName", client.getLastName());
			session.setAttribute("phone", client.getPhone());
			session.setAttribute("email", client.getEmail());
			
			session.setMaxInactiveInterval(3600);
			
			return "redirect:/booking/home.do";
		}
		else {
			return "redirect:/booking/loginFail.do";
		}
	}
	
	@RequestMapping("/booking/loginFail.do")
	public String loginFail() throws Exception {
		return "/booking/loginFail";
	}
	
	@RequestMapping("/booking/logout.do")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("clientId"); 
		session.invalidate();
		
		return "redirect:/booking/home.do";
	}
}
