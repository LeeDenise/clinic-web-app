package booking.mapper;

import booking.models.*;
import booking.models.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<UserDto> selectAllUsers() throws Exception;
    Optional<UserDto> selectUserByUserEmail(String email);
    void insertUser(UserDto userDto);
    void updateUser(UpdateUserDto updateUserDto) throws Exception;
    void disableUser(String userEmail);
}
