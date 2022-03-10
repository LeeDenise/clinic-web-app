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

    // THERAPIST
    public List<EmployeeDto> openTherapistList() throws Exception {
        return employeeMapper.openTherapistList();
    }

    public void insertTherapist(EmployeeDto therapist) throws Exception {
        employeeMapper.insertTherapist(therapist);

    }

    public void updateTherapist(EmployeeDto therapist) throws Exception {
        employeeMapper.updateTherapist(therapist);
    }

    public EmployeeDto therapistDetail(int empNo) throws Exception {
        return employeeMapper.therapistDetail(empNo);
    }

    public void deleteTherapist(int empNo) throws Exception {
        employeeMapper.deleteTherapist(empNo);
    }
}
