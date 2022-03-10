package booking.controller;

import java.util.List;

import booking.models.EmployeeDto;

import booking.service.BookingService;
import booking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService bookingService;
	
	
	@RequestMapping("/booking/openTherapistList.do")
	public ModelAndView openTherapistList() throws Exception {
		ModelAndView mv = new ModelAndView("booking/therapistlist");
		
		List<EmployeeDto> list = bookingService.openTherapistList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/booking/therapistSignUp.do")
	public String therapistSignUp() {
		return "/booking/therapistsignup";
	}
	
	@RequestMapping("/booking/insertTherapist.do")
	public String insertTherapist(EmployeeDto therapist) throws Exception {
		bookingService.insertTherapist(therapist);
		return "redirect:/booking/openTherapistList.do";
	}
	
	@RequestMapping("/booking/updateTherapist.do")
	public String updateTherapist(EmployeeDto therapist) throws Exception {
		bookingService.updateTherapist(therapist);
		return "redirect:/booking/openTherapistList.do";
	}
	
	@RequestMapping("/booking/therapistDetail.do")
	public ModelAndView therapistDetail(@RequestParam int empNo) throws Exception {
		ModelAndView mv = new ModelAndView("/booking/therapistdetail");
		EmployeeDto therapist = bookingService.therapistDetail(empNo);
		mv.addObject("list", therapist);
		return mv;
	}
	
	@RequestMapping("/booking/deleteTherapist.do")
	public String deleteTherapist(@RequestParam int empNo) throws Exception {
		bookingService.deleteTherapist(empNo);
		return "redirect:/booking/openTherapistList.do";
	}

}
