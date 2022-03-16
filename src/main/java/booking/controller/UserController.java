package booking.controller;

import java.util.List;

import booking.models.*;

import booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

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
		return "redirect:/";

	}

	@RequestMapping("/profile")
	public ModelAndView openMyProfile() throws Exception {
		ModelAndView mv = new ModelAndView("/user/profile");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalEmail = authentication.getName();

		UserDto loggedInUser = userService.selectUserByUserEmail(currentPrincipalEmail).orElseThrow(Exception::new);
		mv.addObject("userInfo", loggedInUser);

		return mv;
	}
	
	@RequestMapping("/update")
	public String updateMyProfile(UpdateUserDto updateUserDto) throws Exception {
		userService.updateUser(updateUserDto);
		return "redirect:/user/profile";
	}

	@RequestMapping("/delete")
	public String deleteMyProfile(String userEmail) throws Exception {
		userService.deleteUser(userEmail);
		return "redirect:/logout";
	}
	
//	@RequestMapping("/booking/deleteClient")
//	public String deleteClient(@RequestParam int clientNo) throws Exception {
//		bookingService.deleteClient(clientNo);
//		return "redirect:/booking/openClientList";
//	}
}
