package booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booking.controller.BookingController;
import booking.dto.BookingDto;
import booking.dto.BookingListDto;
import booking.dto.ClientDto;
import booking.dto.TherapistDto;
import booking.mapper.BookingMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService {
	@Override
	public ClientDto selectUserInfoYN(String clientId, String clientPwd) throws Exception {
		return bookingMapper.selectUserInfoYN(clientId, clientPwd);
	}

	@Override
	public List<BookingDto> selectBookingTime(int empNo, String selStartTime, String selEndTime) throws Exception {
		log.debug("--------service selectBookingTime 111");
		return bookingMapper.selectBookingTime(empNo, selStartTime, selEndTime);
	}

	@Autowired
	private BookingMapper bookingMapper;
	
	@Override
	public ClientDto test() throws Exception {
		return bookingMapper.test();
	}
	
	// BOOKING
	@Override
	public List<BookingListDto> openUserBookingList(String clientId) throws Exception {
		return bookingMapper.openUserBookingList(clientId);
	}
	
	@Override
	public List<BookingDto> openAdminBookingList() throws Exception {
		return bookingMapper.openAdminBookingList();
	}
	
	@Override
	public void insertBooking(BookingDto booking) throws Exception {
		bookingMapper.insertBooking(booking);
	}
	
	@Override
	public void updateBooking(BookingDto booking) throws Exception {
		bookingMapper.updateBooking(booking);
	}
	
	@Override
	public BookingDto bookingDetail(String bookingNo) throws Exception {
		BookingDto booking = bookingMapper.bookingDetail(bookingNo);
		return booking;
	}
	

	@Override
	public TherapistDto bookingTherapist(String empNo) throws Exception {
		TherapistDto therapist = bookingMapper.bookingTherapist(empNo);
		return therapist;
	}

	@Override
	public List<BookingDto> selectTherapist(int empNo) throws Exception {
		return bookingMapper.selectTherapist(empNo);
	}

	@Override
	public List<TherapistDto> selectTherapistList() throws Exception {
		return bookingMapper.selectTherapistList();
	}

	@Override
	public void cancelBooking(String bookingNo) throws Exception {
		bookingMapper.cancelBooking(bookingNo);
	}
	
	// CLIENT
	@Override
	public List<ClientDto> selectClientList() throws Exception {
		return bookingMapper.selectClientList();
	}

	@Override
	public void insertClient(ClientDto client) throws Exception {
		bookingMapper.insertClient(client);
	}

	@Override
	public void updateClient(ClientDto client) throws Exception {
		bookingMapper.updateClient(client);
	}

	@Override
	public ClientDto clientDetail(int clientNo) throws Exception {
		log.debug("--------------service----------------");
		log.debug(Integer.toString(clientNo));
		ClientDto client = bookingMapper.clientDetail(clientNo);
		return  client;
	}

	@Override
	public void deleteClient(int clientNo) throws Exception {
		bookingMapper.deleteClient(clientNo);
		
	}

	// THERAPIST
	@Override
	public List<TherapistDto> openTherapistList() throws Exception {
		return bookingMapper.openTherapistList();
	}

	@Override
	public void insertTherapist(TherapistDto therapist) throws Exception {
		bookingMapper.insertTherapist(therapist);
		
	}

	@Override
	public void updateTherapist(TherapistDto therapist) throws Exception {
		bookingMapper.updateTherapist(therapist);
	}

	@Override
	public TherapistDto therapistDetail(int empNo) throws Exception {
		TherapistDto therapist = bookingMapper.therapistDetail(empNo);
		return therapist;
	}

	@Override
	public void deleteTherapist(int empNo) throws Exception {
		bookingMapper.deleteTherapist(empNo);
	}
	
}
