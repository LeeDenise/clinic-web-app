package booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import booking.dto.BookingDto;
import booking.dto.BookingListDto;
import booking.dto.ClientDto;
import booking.dto.TherapistDto;

@Mapper
public interface BookingMapper {
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
	List<BookingListDto> openUserBookingList(@Param("clientId") String clientId) throws Exception;
	List<BookingDto> openAdminBookingList() throws Exception;
	void insertBooking(BookingDto booking) throws Exception;
	void updateBooking(BookingDto booking) throws Exception;
	BookingDto bookingDetail(@Param("bookingNo")String bookingNo) throws Exception;
	TherapistDto bookingTherapist(@Param("empNo")String empNo) throws Exception;
	void cancelBooking(@Param("bookingNo") String bookingNo) throws Exception;
	List<BookingDto> selectTherapist(int empNo) throws Exception;
	List<TherapistDto> selectTherapistList() throws Exception;
	List<BookingDto> selectBookingTime(@Param("empNo") int empNo, @Param("selStartTime") String selStartTime, @Param("selEndTime") String selEndTime) throws Exception;
	
	// LOGIN
	ClientDto selectUserInfoYN(@Param("clientId") String clientId, @Param("clientPwd") String clientPwd) throws Exception;
}
