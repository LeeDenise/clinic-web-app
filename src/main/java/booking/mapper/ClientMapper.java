package booking.mapper;

import booking.dto.ClientDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {
    List<ClientDto> getAllClients() throws Exception;
}
