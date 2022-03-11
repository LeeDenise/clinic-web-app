package booking.service;

import booking.mapper.EmployeeMapper;
import booking.models.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> selectTherapistList() throws Exception {
        return employeeMapper.selectTherapistList();
    }
}
