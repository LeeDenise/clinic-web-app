package booking.service;

import java.util.List;

import booking.models.EmployeeDto;
import booking.mapper.UserMapper;
import booking.mapper.EmployeeMapper;
import booking.models.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booking.models.BookingDto;
import booking.models.BookingListDto;
import booking.mapper.BookingMapper;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
	@Autowired
	private final BookingMapper bookingMapper;

	@Autowired
	private final UserMapper clientMapper;

	@Autowired
	private final EmployeeMapper employeeMapper;

	@Override
	public List<BookingDto> selectBookingTime(int empNo, String selStartTime, String selEndTime) throws Exception {
		return bookingMapper.selectBookingTime(empNo, selStartTime, selEndTime);
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
		return bookingMapper.bookingDetail(bookingNo);
	}
	

	@Override
	public EmployeeDto bookingTherapist(String empNo) throws Exception {
		return bookingMapper.bookingTherapist(empNo);
	}

	@Override
	public List<BookingDto> selectTherapist(int empNo) throws Exception {
		return bookingMapper.selectTherapist(empNo);
	}

	@Override
	public List<EmployeeDto> selectTherapistList() throws Exception {
		return bookingMapper.selectTherapistList();
	}

	@Override
	public void cancelBooking(String bookingNo) throws Exception {
		bookingMapper.cancelBooking(bookingNo);
	}
	
	// CLIENT
	@Override
	public List<SecurityUser> getAllClients() throws Exception {
		return clientMapper.getAllClients();
	}

	@Override
	public void updateClient(SecurityUser client) throws Exception {
		clientMapper.updateClient(client);
	}

	@Override
	public SecurityUser clientDetail(int clientNo) throws Exception {
		return clientMapper.clientDetail(clientNo);
	}

	@Override
	public void deleteClient(int clientNo) throws Exception {
		clientMapper.deleteClient(clientNo);
		
	}

	// THERAPIST
	@Override
	public List<EmployeeDto> openTherapistList() throws Exception {
		return employeeMapper.openTherapistList();
	}

	@Override
	public void insertTherapist(EmployeeDto therapist) throws Exception {
		employeeMapper.insertTherapist(therapist);
		
	}

	@Override
	public void updateTherapist(EmployeeDto therapist) throws Exception {
		employeeMapper.updateTherapist(therapist);
	}

	@Override
	public EmployeeDto therapistDetail(int empNo) throws Exception {
		return employeeMapper.therapistDetail(empNo);
	}

	@Override
	public void deleteTherapist(int empNo) throws Exception {
		employeeMapper.deleteTherapist(empNo);
	}
	
}
