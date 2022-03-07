package booking.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String role;
}
