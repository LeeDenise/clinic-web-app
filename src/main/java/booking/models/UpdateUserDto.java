package booking.models;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
