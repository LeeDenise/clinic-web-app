package booking.dto;
import lombok.Data;

@Data
public class TherapistDto {
	private int empNo;
	private String empPwd;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String birthday;
	private String toDate;
	private String fromDate;
	private String employedYN;
}
