package booking.mapper;

import booking.models.SecurityUser;
import booking.models.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<SecurityUser> getAllClients() throws Exception;

    Optional<UserDto> selectUserByUserId(String email);
    void insertClient(UserDto client);
    void updateClient(SecurityUser client) throws Exception;
    SecurityUser clientDetail(int clientNo) throws Exception;
    void deleteClient(int clientNo) throws Exception;
}
