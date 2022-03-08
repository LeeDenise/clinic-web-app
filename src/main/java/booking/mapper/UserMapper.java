package booking.mapper;

import booking.models.*;
import booking.models.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<UserDto> selectAllUsers() throws Exception;
    Optional<UserDto> selectUserByUserId(String email);
    void insertUser(UserDto userDto);
    void updateUser(UpdateUserDto updateUserDto) throws Exception;
    SecurityUser clientDetail(int clientNo) throws Exception;
    void deleteClient(int clientNo) throws Exception;
}
