package booking.dto;
import lombok.Data;

@Data
public class EmployeeDto {
	private Long empId;
	private String email;
	private String pwd;
	private String firstName;
	private String lastName;
}
