package booking.mapper;

import java.util.List;

import booking.models.BookingListDto;
import booking.models.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import booking.models.BookingDto;

@Mapper
public interface BookingMapper {
	BookingDto selectABooking(Long bookingId);
	List<BookingListDto> selectAllBookings();
	List<BookingListDto> selectUserBookingList(String userEmail) throws Exception;
	List<String> selectBookingTime(@Param("empId") int empId, @Param("selDate") String selDate) throws Exception;
	void insertBooking(BookingDto booking) throws Exception;
	void updateBooking(BookingDto booking) throws Exception;
	void cancelBooking(@Param("bookingId") Long bookingId) throws Exception;
}
