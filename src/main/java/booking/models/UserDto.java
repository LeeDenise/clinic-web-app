package booking.models;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String role;
    private boolean disabled;
}
