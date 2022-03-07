package booking.controller;

import java.util.List;

import booking.models.SecurityUser;
import booking.models.UserDto;
import booking.service.BookingService;

import booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private BookingService bookingService;

	@Autowired
	private UserService userService;

	@RequestMapping("/booking/openClientList")
	public ModelAndView openClientList() throws Exception {
		ModelAndView mv = new ModelAndView("admin/clientlist");
		List<SecurityUser> list = bookingService.getAllClients();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/booking/insertUser")
	public String insertClient(UserDto userDto) throws Exception {
		userService.insertUser(userDto);
		return "success!";
//		return "redirect:/booking/openClientList";
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
