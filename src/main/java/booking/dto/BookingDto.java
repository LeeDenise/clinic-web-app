package booking.dto;

import lombok.Data;

@Data
public class BookingDto {
	private String bookingNo;
	private String startTime;
	private String endTime;
	private String regTime;
	private String editTime;
	private String status;
	private String empNo;
	private String clientId;
}
