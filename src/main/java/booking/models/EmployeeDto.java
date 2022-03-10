package booking.models;
import lombok.Data;

@Data
public class EmployeeDto {
	private Long empId;
	private String email;
	private String firstName;
	private String lastName;
}
