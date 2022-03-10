package booking.service;

import java.util.List;

import booking.models.BookingListDto;
import booking.models.EmployeeDto;
import booking.mapper.UserMapper;
import booking.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booking.models.BookingDto;
import booking.mapper.BookingMapper;

@Service
@AllArgsConstructor
public class BookingService {
	@Autowired
	private final BookingMapper bookingMapper;

	public List<BookingListDto> selectUserBookingList(String currentPrincipalEmail) throws Exception {
		return bookingMapper.selectUserBookingList(currentPrincipalEmail);
	}


	public List<BookingDto> selectBookingTime(int empNo, String selStartTime, String selEndTime) throws Exception {
		return bookingMapper.selectBookingTime(empNo, selStartTime, selEndTime);
	}
	
	public List<BookingDto> openAdminBookingList() throws Exception {
		return bookingMapper.openAdminBookingList();
	}
	
	public void insertBooking(BookingDto booking) throws Exception {
		bookingMapper.insertBooking(booking);
	}
	
	public void updateBooking(BookingDto booking) throws Exception {
		bookingMapper.updateBooking(booking);
	}
	
	public BookingDto bookingDetail(String bookingNo) throws Exception {
		return bookingMapper.bookingDetail(bookingNo);
	}

	public EmployeeDto bookingTherapist(String empNo) throws Exception {
		return bookingMapper.bookingTherapist(empNo);
	}

	public List<BookingDto> selectTherapist(int empNo) throws Exception {
		return bookingMapper.selectTherapist(empNo);
	}

	public List<EmployeeDto> selectTherapistList() throws Exception {
		return bookingMapper.selectTherapistList();
	}

	public void cancelBooking(String bookingNo) throws Exception {
		bookingMapper.cancelBooking(bookingNo);
	}


}
