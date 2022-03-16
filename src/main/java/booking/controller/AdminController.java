package booking.controller;

import booking.models.EmployeeDto;
import booking.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private final EmployeeService employeeService;

    @RequestMapping
    public String openAdminPage() {
        return "admin/admin";
    }

    @RequestMapping(value = "/therapist", method = RequestMethod.GET)
    public ModelAndView openEmployeeList() throws Exception {
        ModelAndView mv = new ModelAndView("admin/therapistlist");
        List<EmployeeDto> therapistList = employeeService.selectTherapistList();
        mv.addObject("list", therapistList);
        return mv;
    }

    @RequestMapping(value = "/thrapistdetail")
    public ModelAndView openEmployeeDetail(@RequestParam String empId) throws Exception {
        ModelAndView mv = new ModelAndView("admin/therapistdetail");
        EmployeeDto therapist = employeeService.selectTherapist(Long.parseLong(empId));
        mv.addObject("list", therapist);
        return mv;
    }
}
