package booking.controller;

import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import booking.models.BookingDto;
import booking.models.BookingListDto;
import booking.models.EmployeeDto;

import booking.service.BookingService;
import booking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/openUserBookingList")
	public ModelAndView openUserBookingList(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("booking/myappointments");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalEmail = authentication.getName();

		List<BookingListDto> bookingList = bookingService.selectUserBookingList(currentPrincipalEmail);
		mv.addObject("list", bookingList);
		
		return mv;
	}
	
	@RequestMapping(value="/newBooking", method=RequestMethod.GET)
	public ModelAndView openNewBooking(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("booking/newbooking");

		List<EmployeeDto> list = employeeService.selectTherapistList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/getAvailableTimes", method=RequestMethod.POST)
	public ModelAndView newBookingTime(@RequestParam String empId, @RequestParam String selDate) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<String> list = bookingService.selectBookingTime(Integer.parseInt(empId), selDate);
		mv.addObject("bookingList", list);
		
		return mv;
	}
	
	@RequestMapping("/insertBooking")
	public String insertBooking(BookingDto booking) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalEmail = authentication.getName();
		booking.setUserEmail(currentPrincipalEmail);

		booking.setSessionStart(booking.getSessionStart());

		if (booking.getBookingId() == null) {
			// TODO: what will be the logic of booking status?
			booking.setStatus("scheduled");
			bookingService.insertBooking(booking);
		} else {
			booking.setStatus("updated");
			bookingService.updateBooking(booking);
		}

		return "redirect:/booking/openUserBookingList";
	}
	
	@RequestMapping(value="/bookingDetail")
	public ModelAndView bookingDetail(@RequestParam String bookingId) throws Exception {
		ModelAndView mv = new ModelAndView("booking/newbooking");

		List<EmployeeDto> list = employeeService.selectTherapistList();
		mv.addObject("list", list);

		BookingDto existingBooking = bookingService.selectBooking(Long.parseLong(bookingId));
		mv.addObject("booking", existingBooking);

		return mv;
	}

	@RequestMapping("/cancelBooking")
	public String cancelBooking(String bookingId) throws Exception {
		bookingService.cancelBooking(Long.parseLong(bookingId));
		return "redirect:/booking/openUserBookingList";
	}
}
