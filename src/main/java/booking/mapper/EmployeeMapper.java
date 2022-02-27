package booking.mapper;

import booking.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDto> openTherapistList() throws Exception;
    void insertTherapist(EmployeeDto therapist) throws Exception;
    void updateTherapist(EmployeeDto therapist) throws Exception;
    EmployeeDto therapistDetail(int empNo) throws Exception;
    void deleteTherapist(int empNo) throws Exception;
}
