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
	
}
