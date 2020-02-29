package booking.dto;

import lombok.Data;

@Data
public class ClientDto {
	private int clientNo;
	private String clientId;
	private String firstName;
	private String lastName;
	private String email;
	private String clientPwd;
	private String phone;
	private String regDate;
	private String editDate;
}
