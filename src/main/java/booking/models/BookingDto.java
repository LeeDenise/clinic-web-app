package booking.models;

import lombok.Data;

@Data
public class BookingDto {
	private Long bookingId;
	private String sessionStart;
	private String sessionEnd;
	private String status;
	private String empId;
	private String clientId;
}
