package booking.mapper;

import java.util.List;

import booking.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import booking.dto.BookingDto;
import booking.dto.BookingListDto;
import booking.dto.ClientDto;

@Mapper
public interface BookingMapper {
	List<ClientDto> test() throws Exception;
	
	// CLIENT
//	List<ClientDto> getAllClients() throws Exception;
	void insertClient(ClientDto client) throws Exception;
	void updateClient(ClientDto client) throws Exception;
	ClientDto clientDetail(int clientNo) throws Exception;
	void deleteClient(int clientNo) throws Exception;
	
	// THERAPIST
	List<EmployeeDto> openTherapistList() throws Exception;
	void insertTherapist(EmployeeDto therapist) throws Exception;
	void updateTherapist(EmployeeDto therapist) throws Exception;
	EmployeeDto therapistDetail(int empNo) throws Exception;
	void deleteTherapist(int empNo) throws Exception;
	
	// BOOKING
	List<BookingListDto> openUserBookingList(@Param("clientId") String clientId) throws Exception;
	List<BookingDto> openAdminBookingList() throws Exception;
	void insertBooking(BookingDto booking) throws Exception;
	void updateBooking(BookingDto booking) throws Exception;
	BookingDto bookingDetail(@Param("bookingNo")String bookingNo) throws Exception;
	EmployeeDto bookingTherapist(@Param("empNo")String empNo) throws Exception;
	void cancelBooking(@Param("bookingNo") String bookingNo) throws Exception;
	List<BookingDto> selectTherapist(int empNo) throws Exception;
	List<EmployeeDto> selectTherapistList() throws Exception;
	List<BookingDto> selectBookingTime(@Param("empNo") int empNo, @Param("selStartTime") String selStartTime, @Param("selEndTime") String selEndTime) throws Exception;
	
	// LOGIN
	ClientDto selectUserInfoYN(@Param("clientId") String clientId, @Param("clientPwd") String clientPwd) throws Exception;
}
