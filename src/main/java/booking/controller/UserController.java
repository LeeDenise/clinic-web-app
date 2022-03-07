package booking.controller;

import java.util.List;

import booking.models.SecurityUser;
import booking.models.UserDto;
import booking.service.BookingService;

import booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BookingService bookingService;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() throws Exception {
		return "/user/login";
	}

	@RequestMapping("/list")
	public ModelAndView openUserList() throws Exception {
		ModelAndView mv = new ModelAndView("/user/userlist");
		List<UserDto> list = userService.selectAllUsers();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/insert")
	public String insertClient(UserDto userDto) throws Exception {
		userService.insertUser(userDto);
		return "redirect:/user/list";

	}
	
	@RequestMapping("/booking/updateClient")
	public String updateClient(SecurityUser client) throws Exception {
		bookingService.updateClient(client);
		return "redirect:/booking/openClientList";
	}
	
	@RequestMapping("/booking/clientDetail")
	public ModelAndView clientDetail(@RequestParam int clientNo) throws Exception {
		ModelAndView mv = new ModelAndView("/booking/clientdetail");
		SecurityUser client = bookingService.clientDetail(clientNo);
		mv.addObject("list", client);
		return mv;
	}
	
	@RequestMapping("/booking/deleteClient")
	public String deleteClient(@RequestParam int clientNo) throws Exception {
		bookingService.deleteClient(clientNo);
		return "redirect:/booking/openClientList";
	}
}
