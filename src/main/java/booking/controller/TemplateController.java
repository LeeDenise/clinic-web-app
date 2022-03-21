package booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("")
public class TemplateController {

	@RequestMapping("")
	public String home() throws Exception {
		return "home";
	}

	@GetMapping("/login")
	public String login() throws Exception {
		return "user/login";
	}

	@GetMapping("/signup")
	public String singup() throws Exception {
		return "user/signup";
	}
	
	// USER DASHBOARD
	@RequestMapping("/booking/user")
	public String user() throws Exception {
		return "booking/user";
	}

	@GetMapping("/helloworld/long-process")
	@ResponseBody
	public String pause() throws InterruptedException {
		Thread.sleep(10000);
		return "Process finished";
	}

}
