package booking.mapper;

import booking.models.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDto> selectTherapistList() throws Exception;
}
