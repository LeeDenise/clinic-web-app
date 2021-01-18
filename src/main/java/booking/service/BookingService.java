package booking.service;

import java.util.List;

import booking.dto.BookingDto;
import booking.dto.BookingListDto;
import booking.dto.ClientDto;
import booking.dto.TherapistDto;

public interface BookingService {
	ClientDto test() throws Exception;
	
	// CLIENT
	List<ClientDto> selectClientList() throws Exception;
	void insertClient(ClientDto client) throws Exception;
	void updateClient(ClientDto client) throws Exception;
	ClientDto clientDetail(int clientNo) throws Exception;
	void deleteClient(int clientNo) throws Exception;
	
	// THERAPIST
	List<TherapistDto> openTherapistList() throws Exception;
	void insertTherapist(TherapistDto therapist) throws Exception;
	void updateTherapist(TherapistDto therapist) throws Exception;
	TherapistDto therapistDetail(int empNo) throws Exception;
	void deleteTherapist(int empNo) throws Exception;
	
	// BOOKING
	List<BookingListDto> openUserBookingList(String clientId) throws Exception;
	List<BookingDto> openAdminBookingList() throws Exception;
	void insertBooking(BookingDto booking) throws Exception;
	void updateBooking(BookingDto booking) throws Exception;
	BookingDto bookingDetail(String bookingNo) throws Exception;
	TherapistDto bookingTherapist(String empNo) throws Exception;
	void cancelBooking(String bookingNo) throws Exception;
	List<BookingDto> selectTherapist(int empNo) throws Exception;
	List<TherapistDto> selectTherapistList() throws Exception;
	List<BookingDto> selectBookingTime(int empNo, String selStartTime, String selEndTime) throws Exception;
	
	// LOGIN
	ClientDto selectUserInfoYN(String clientId, String clientPwd) throws Exception;
}
