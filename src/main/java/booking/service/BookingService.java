package booking.service;

import java.util.List;

import booking.models.BookingListDto;
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

	public List<BookingListDto> selectAllBookings() {
		return bookingMapper.selectAllBookings();
	}

	public BookingDto selectBooking(Long bookingId) {
		return bookingMapper.selectABooking(bookingId);
	}

	public List<BookingListDto> selectUserBookingList(String currentPrincipalEmail) throws Exception {
		return bookingMapper.selectUserBookingList(currentPrincipalEmail);
	}

	public List<String> selectBookingTime(int empId, String selDate) throws Exception {
		return bookingMapper.selectBookingTime(empId, selDate);
	}
	
	public void insertBooking(BookingDto booking) throws Exception {
		bookingMapper.insertBooking(booking);
	}

	public void updateBooking(BookingDto booking) throws Exception {
		bookingMapper.updateBooking(booking);
	}

	public void cancelBooking(Long bookingId) throws Exception {
		bookingMapper.cancelBooking(bookingId);
	}


}
