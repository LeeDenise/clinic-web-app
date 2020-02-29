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
	
//	// BOOKING
//	@RequestMapping("/booking/openUserBookingList.do")
//	public ModelAndView openUserBookingList() throws Exception {
//		ModelAndView mv = new ModelAndView("booking/bookinglistuser");
//		List<BookingDto> list = bookingService.openUserBookingList();
//		mv.addObject("list", list);
//		
//		return mv;
//	}
//	
//	@RequestMapping("/booking/openAdminBookingList.do")
//	public ModelAndView openAdminBookingList() throws Exception {
//		ModelAndView mv = new ModelAndView("booking/bookinglistadmin");
//		List<BookingDto> list = bookingService.openAdminBookingList();
//		mv.addObject("list", list);
//		
//		return mv;
//	}
//	
//	// AJAX 사용해보기
//	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.GET)
//	public ModelAndView openNewBooking() throws Exception {
//		ModelAndView mv = new ModelAndView("booking/bookingnew");
//		
//		List<TherapistDto> list = bookingService.selectTherapistList();
//		mv.addObject("list", list);
//		
//		log.debug("-------------------------------");
//		
//		return mv;
//	}
//	
//	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.POST)
//	public ModelAndView newBooking(@RequestParam String empNo) throws Exception {
//		log.debug("--------newBooking ㅔㅐㄴ----------");
////		log.debug("empNo: " + empNo);
//		log.debug("empNo: " + empNo);
//		
//		ModelAndView mv = new ModelAndView("jsonView");
//		// 사원번호로 스케줄 로드 (오늘 날짜부터 7일)
//		List<BookingDto> list = bookingService.selectTherapist(Integer.parseInt(empNo));
////		BookingDto db = new BookingDto();
////		db.setClientId("asdasd");
////		db.setEmpNo(123);
////		db.setBookingNo(100);
////		
////		List<BookingDto> list = new ArrayList<BookingDto>();
////		list.add(db);
////		list.add(db);
////		list.add(db);
//		
////		json 데이터 생성 시 object형의 키를 'data'로 설정 
//		mv.addObject("data", list);
//		
//		return mv;
//	}
//	
//	@RequestMapping(value="/booking/newBookingTime.do", method=RequestMethod.POST)
//	public ModelAndView newBookingTime(@RequestParam String empNo, @RequestParam String selDate) throws Exception {
//		log.debug("--------newBookingTime----------");
////		log.debug("empNo: " + empNo);
//		log.debug("empNo: " + empNo);
//		log.debug("selDate: " + selDate);
//		
//		ModelAndView mv = new ModelAndView("jsonView");
//		// 사원번호로 스케줄 로드 (오늘 날짜부터 7일)
//		
//		log.debug("test");
//		List<BookingDto> list = bookingService.selectBookingTime(Integer.parseInt(empNo), selDate + " 00:00:00", selDate + " 23:59:59");
//		
//		log.debug("--------newBookingTime123123123----------");
////		BookingDto db = new BookingDto();
////		db.setClientId("asdasd");
////		db.setEmpNo(Integer.parseInt(empNo));
////		db.setStartTime("09:00");
////		
////		List<BookingDto> list = new ArrayList<BookingDto>();
////		list.add(db);
////		list.add(db);
////		list.add(db);
////		
////		json 데이터 생성 시 object형의 키를 'data'로 설정 
//		
//		log.debug(list.toString());
//		mv.addObject("data", list);
//		
//		return mv;
//		
//	}
//	
//	
////	@RequestMapping(value="/booking/newBooking.do", method=RequestMethod.GET)
////	public @ResponseBody String thyschedule() throws Exception {
////		return "/booking/bookingnew";
////	}
//	
//	@RequestMapping("/booking/insertBooking.do")
//	public String insertBooking(BookingDto booking) throws Exception {
//		
//		log.debug("----insertBooking----");
//		log.debug("booking: " + booking.getStartTime());
//		log.debug(Integer.toString(booking.getEmpNo()));
//		
//		// 현재 날짜 불러와서 문자열로 변경 시켜서 값 넣기
//		Date dateNow = new Date();
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
//		String stringNow = transFormat.format(dateNow);
//		booking.setBookingNo(stringNow);
//		
//		bookingService.insertBooking(booking);
//		return "redirect:/booking/openUserBookingList.do";
//	}
//	
//	@RequestMapping("/booking/updateBooking.do")
//	public String updateBooking(BookingDto booking) throws Exception {
//		bookingService.updateBooking(booking);
//		return "redirect:/booking/openUserBookingList.do";
//	}
//	
//	@RequestMapping("/booking/bookingDetail.do")
//	public ModelAndView bookingDetail(@RequestParam int bookingNo) throws Exception {
//		ModelAndView mv = new ModelAndView("booking/bookingdetail");
//		BookingDto list = bookingService.bookingDetail(bookingNo);
//		mv.addObject("list", list);
//		
//		return mv;
//	}
//	
//	@RequestMapping("/booking/cancelBooking.do")
//	public String cancelBooking(@RequestParam int bookingNo) throws Exception {
//		bookingService.cancelBooking(bookingNo);
//		return "redirect:/booking/openUserBookingList.do";
//	}
//	
//	// ADMIN DASHBOARD
//	@RequestMapping("/booking/admin.do")
//	public String admin() throws Exception {
//		return "/booking/admin";
//	}
//	
//	// CLIENT
//	@RequestMapping("/booking/openClientList.do")
//	public ModelAndView openClientList() throws Exception {
//		ModelAndView mv = new ModelAndView("booking/clientlist");
//		
//		log.debug("------1111-------");
//		List<ClientDto> list = bookingService.selectClientList();
//		log.debug("------2222-------");
//		mv.addObject("list", list);
//		
//		return mv;
//	}
//	
//	@RequestMapping("/booking/clientSignUp.do")
//	public String signUp() throws Exception {
//		return "/booking/clientsignup";
//	}
//	
//	@RequestMapping("/booking/insertClient.do")
//	public String insertClient(ClientDto client) throws Exception {
//		
//		//log.debug("-------openInsert.do----");
//		//log.debug(Integer.toString(board2.getNum()));
//		//log.debug("-------openInsert.do----");
//
//		bookingService.insertClient(client);
//		return "redirect:/booking/home.do";
//	}
//	
//	@RequestMapping("/booking/updateClient.do")
//	public String updateClient(ClientDto client) throws Exception {
//		bookingService.updateClient(client);
//		return "redirect:/booking/openClientList.do";
//	}
//	
//	@RequestMapping("/booking/clientDetail.do")
//	public ModelAndView clientDetail(@RequestParam int clientNo) throws Exception {
//		ModelAndView mv = new ModelAndView("/booking/clientdetail");
//		ClientDto client = bookingService.clientDetail(clientNo);
//		mv.addObject("list", client);
//		return mv;
//	}
//	
//	@RequestMapping("/booking/deleteClient.do")
//	public String deleteClient(@RequestParam int clientNo) throws Exception {
//		bookingService.deleteClient(clientNo);
//		return "redirect:/booking/openClientList.do";
//	}
//	
//	// THERAPIST
//	@RequestMapping("/booking/openTherapistList.do")
//	public ModelAndView openTherapistList() throws Exception {
//		ModelAndView mv = new ModelAndView("booking/therapistlist");
//		
//		List<TherapistDto> list = bookingService.openTherapistList();
//		mv.addObject("list", list);
//		
//		return mv;
//	}
//	
//	@RequestMapping("/booking/therapistSignUp.do")
//	public String therapistSignUp() throws Exception {
//		return "/booking/therapistsignup";
//	}
//	
//	@RequestMapping("/booking/insertTherapist.do")
//	public String insertTherapist(TherapistDto therapist) throws Exception {
//		bookingService.insertTherapist(therapist);
//		return "redirect:/booking/openTherapistList.do";
//	}
//	
//	@RequestMapping("/booking/updateTherapist.do")
//	public String updateTherapist(TherapistDto therapist) throws Exception {
//		bookingService.updateTherapist(therapist);
//		return "redirect:/booking/openTherapistList.do";
//	}
//	
//	@RequestMapping("/booking/therapistDetail.do")
//	public ModelAndView therapistDetail(@RequestParam int empNo) throws Exception {
//		ModelAndView mv = new ModelAndView("/booking/therapistdetail");
//		TherapistDto therapist = bookingService.therapistDetail(empNo);
//		mv.addObject("list", therapist);
//		return mv;
//	}
//	
//	@RequestMapping("/booking/deleteTherapist.do")
//	public String deleteTherapist(@RequestParam int empNo) throws Exception {
//		bookingService.deleteTherapist(empNo);
//		return "redirect:/booking/openTherapistList.do";
//	}
//	
//	
//	@RequestMapping("/booking/therapistlist")
//	public String therapistlist() throws Exception {
//		log.debug("000000000000000");
//		return "/booking/therapistlist";
//	}

}
