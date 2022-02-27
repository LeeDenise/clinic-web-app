package booking.mapper;

import booking.dto.ClientDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {
    List<ClientDto> getAllClients() throws Exception;
    void insertClient(ClientDto client) throws Exception;
    void updateClient(ClientDto client) throws Exception;
    ClientDto clientDetail(int clientNo) throws Exception;
    void deleteClient(int clientNo) throws Exception;
}
