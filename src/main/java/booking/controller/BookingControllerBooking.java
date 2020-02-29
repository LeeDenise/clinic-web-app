package booking.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import booking.dto.BookingDto;
import booking.dto.BookingListDto;
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
public class BookingControllerBooking {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/booking/openUserBookingList.do")
	public ModelAndView openUserBookingList(HttpServletRequest request) throws Exception {
		
		log.debug("----openUserBookingList.do----");
//		BookingDto db = new BookingDto();
//		db.setClientId("asdasd");
		ModelAndView mv = new ModelAndView("booking/bookinglistuser");
		
		HttpSession session = request.getSession();
		
		List<BookingListDto> list = bookingService.openUserBookingList((String)session.getAttribute("clientId"));

		mv.addObject("list", list);
//		mv.addObject("th", th);
		
		return mv;
	}
	
//	@RequestMapping("/booking/openAdminBookingList.do")
//	public ModelAndView openAdminBookingList() throws Exception {
//		ModelAndView mv = new ModelAndView("booking/bookinglistadmin");
//		List<BookingDto> list = bookingService.openAdminBookingList();
//		mv.addObject("list", list);
//		
//		return mv;
//	}
	
	// AJAX 사용해보기
	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.GET)
	public ModelAndView openNewBooking(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("booking/bookingnew");
		log.debug("-------------------------------");
		List<TherapistDto> list = bookingService.selectTherapistList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.POST)
	public ModelAndView newBooking(@RequestParam String empNo) throws Exception {
		log.debug("--------newBooking----------");
//		log.debug("empNo: " + empNo);
		log.debug("empNo: " + empNo);
		
		ModelAndView mv = new ModelAndView("jsonView");
		// 사원번호로 스케줄 로드 (오늘 날짜부터 7일)
		List<BookingDto> list = bookingService.selectTherapist(Integer.parseInt(empNo));
//		BookingDto db = new BookingDto();
//		db.setClientId("asdasd");
//		db.setEmpNo(123);
//		db.setBookingNo(100);
//		
//		List<BookingDto> list = new ArrayList<BookingDto>();
//		list.add(db);
//		list.add(db);
//		list.add(db);
		
//		json 데이터 생성 시 object형의 키를 'data'로 설정 
		mv.addObject("data", list);
		
		return mv;
	}
	
	@RequestMapping(value="/booking/newBookingTime.do", method=RequestMethod.POST)
	public ModelAndView newBookingTime(@RequestParam String empNo, @RequestParam String selDate) throws Exception {
		log.debug("--------newBookingTime----------");
//		log.debug("empNo: " + empNo);
		log.debug("empNo: " + empNo);
		log.debug("selDate: " + selDate);
		
		ModelAndView mv = new ModelAndView("jsonView");
		// 사원번호로 스케줄 로드 (오늘 날짜부터 7일)
		
		log.debug("test");
		List<BookingDto> list = bookingService.selectBookingTime(Integer.parseInt(empNo), selDate + " 00:00:00", selDate + " 23:59:59");
		
		log.debug("--------newBookingTime123123123----------");
//		BookingDto db = new BookingDto();
//		db.setClientId("asdasd");
//		db.setEmpNo(Integer.parseInt(empNo));
//		db.setStartTime("09:00");
//		
//		List<BookingDto> list = new ArrayList<BookingDto>();
//		list.add(db);
//		list.add(db);
//		list.add(db);
//		
//		json 데이터 생성 시 object형의 키를 'data'로 설정 
		
		log.debug(list.toString());
		mv.addObject("data", list);
		
		return mv;
		
	}
	
	@RequestMapping("/booking/insertBooking.do")
	public String insertBooking(BookingDto booking) throws Exception {
		
		log.debug("----insertBooking----");
		log.debug("booking: " + booking.getStartTime());
		log.debug(booking.getEmpNo());
		
		// 현재 날짜 불러와서 문자열로 변경 시켜서 값 넣기
		Date dateNow = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String stringNow = transFormat.format(dateNow);
		booking.setBookingNo(stringNow);
		
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
		TherapistDto th = bookingService.bookingTherapist(list.getEmpNo());
		
		mv.addObject("list", list);
		mv.addObject("th", th);
		
		return mv;
	}
	
	// 전체불러오는 것 새로 만들기
	@RequestMapping(value="/booking/bookingDetail.do", method=RequestMethod.POST)
	public ModelAndView detailNewBooking(HttpServletRequest request) throws Exception {
		log.debug("-----therapist----");
		ModelAndView mv = new ModelAndView("jsonView");
		List<TherapistDto> list = bookingService.selectTherapistList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/booking/cancelBooking.do")
	public String cancelBooking(@RequestParam String bookingNo) throws Exception {
		bookingService.cancelBooking(bookingNo);
		return "redirect:/booking/openUserBookingList.do";
	}

}
