package booking.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import booking.models.BookingDto;
import booking.models.BookingListDto;
import booking.models.EmployeeDto;
import booking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/booking/openUserBookingList.do")
	public ModelAndView openUserBookingList(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("booking/bookinglistuser");
		HttpSession session = request.getSession();
		List<BookingListDto> list = bookingService.openUserBookingList((String)session.getAttribute("clientId"));
		mv.addObject("list", list);
		
		return mv;
	}
	
	// AJAX 
	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.GET)
	public ModelAndView openNewBooking(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("booking/bookingnew");
		log.debug("-------------------------------");
		List<EmployeeDto> list = bookingService.selectTherapistList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.POST)
	public ModelAndView newBooking(@RequestParam String empNo) throws Exception {
		log.debug("--------newBooking----------");
		log.debug("empNo: " + empNo);
		
		ModelAndView mv = new ModelAndView("jsonView");
		List<BookingDto> list = bookingService.selectTherapist(Integer.parseInt(empNo)); //load the employee id

		mv.addObject("data", list);
		
		return mv;
	}
	
	@RequestMapping(value="/booking/newBookingTime.do", method=RequestMethod.POST)
	public ModelAndView newBookingTime(@RequestParam String empNo, @RequestParam String selDate) throws Exception {
		log.debug("--------newBookingTime----------");
		log.debug("empNo: " + empNo);
		log.debug("selDate: " + selDate);
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		log.debug("test");
		List<BookingDto> list = bookingService.selectBookingTime(Integer.parseInt(empNo), selDate + " 00:00:00", selDate + " 23:59:59");
		
		log.debug("--------newBookingTime123123123----------");
		log.debug(list.toString());
		mv.addObject("data", list);
		
		return mv;
		
	}
	
	@RequestMapping("/booking/insertBooking.do")
	public String insertBooking(BookingDto booking) throws Exception {
		
		log.debug("----insertBooking----");
		log.debug(booking.getEmpId());
		
		Date dateNow = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String stringNow = transFormat.format(dateNow);
		booking.setBookingId(123L);

		bookingService.insertBooking(booking);
		return "redirect:/booking/openUserBookingList.do";
	}
	
	@RequestMapping("/booking/updateBooking.do")
	public String updateBooking(BookingDto booking) throws Exception {
		bookingService.updateBooking(booking);
		return "redirect:/booking/openUserBookingList.do";
	}
	
	@RequestMapping(value="/booking/bookingDetail.do", method=RequestMethod.GET)  
	public ModelAndView bookingDetail(@RequestParam String bookingNo) throws Exception {
		ModelAndView mv = new ModelAndView("booking/bookingdetail");
		
		BookingDto list = bookingService.bookingDetail(bookingNo);
		EmployeeDto th = bookingService.bookingTherapist(list.getEmpId());
		
		mv.addObject("list", list);
		mv.addObject("th", th);
		
		return mv;
	}
	
	@RequestMapping(value="/booking/bookingDetail.do", method=RequestMethod.POST)
	public ModelAndView detailNewBooking(HttpServletRequest request) throws Exception {
		log.debug("-----therapist----");
		ModelAndView mv = new ModelAndView("jsonView");
		List<EmployeeDto> list = bookingService.selectTherapistList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/booking/cancelBooking.do")
	public String cancelBooking(@RequestParam String bookingNo) throws Exception {
		bookingService.cancelBooking(bookingNo);
		return "redirect:/booking/openUserBookingList.do";
	}

}
