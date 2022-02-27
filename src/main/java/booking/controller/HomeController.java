package booking.controller;

import booking.dto.ClientDto;
import booking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private BookingService bookingService;

	@RequestMapping("/login")
	public String login() throws Exception {
		return "/booking/login";
	}

	@RequestMapping("/booking/test")
	public ModelAndView openTest() throws Exception {
		ModelAndView mv = new ModelAndView("/booking/test");
		List<ClientDto> clients = bookingService.getAllClients();
		mv.addObject("lists", clients);
		return mv;
	}
	
	// HOME
	@RequestMapping("/booking/home")
	public String home() throws Exception {
		return "/booking/home";
	}
	
	// USER DASHBOARD
	@RequestMapping("/booking/user")
	public String user() throws Exception {
		return "/booking/user";
	}
}
