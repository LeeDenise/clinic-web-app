package booking.models;

import lombok.Data;

@Data
public class BookingDto {
	private Long bookingId;
	private String sessionStart;
	private String status;
	private String empId;
	private String userEmail;
}
