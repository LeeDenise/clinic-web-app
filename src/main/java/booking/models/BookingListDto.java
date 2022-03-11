package booking.models;

import lombok.Data;

@Data
public class BookingListDto {
    private Long bookingId;
    private String sessionStart;
    private String status;
    private String empId;
    private String userEmail;
    private String firstName;
    private String lastName;
}
