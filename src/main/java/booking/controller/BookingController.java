package booking.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import booking.dto.BookingDto;
import booking.dto.ClientDto;
import booking.dto.TherapistDto;
import booking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	// TEST
	@RequestMapping("/booking/test.do")
	public ModelAndView openTest() throws Exception {
		ModelAndView mv = new ModelAndView("test");
		ClientDto client = bookingService.test();
		mv.addObject("list", client);
		
		return mv;
	}
	
	// HOME
	@RequestMapping("/booking/home.do")
	public String home() throws Exception {
		return "/booking/home";
	}
	
	// USER DASHBOARD
	@RequestMapping("/booking/user.do")
	public String user() throws Exception {
		return "/booking/user";
	}
}
