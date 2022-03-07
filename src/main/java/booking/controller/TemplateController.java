package booking.controller;

import booking.models.SecurityUser;
import booking.models.UserDto;
import booking.service.BookingService;

import booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("")
public class TemplateController {

	@RequestMapping("")
	public String home() throws Exception {
		return "/home";
	}
	
	// USER DASHBOARD
	@RequestMapping("/booking/user")
	public String user() throws Exception {
		return "/booking/user";
	}
}
