package booking.controller;

import booking.models.BookingDto;
import booking.models.BookingListDto;
import booking.models.EmployeeDto;
import booking.models.UserDto;
import booking.service.BookingService;
import booking.service.EmployeeService;
import booking.service.UserService;
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
    private final BookingService bookingService;
    @Autowired
    private final UserService userService;

    @RequestMapping
    public ModelAndView openAdminPage() throws Exception {
        ModelAndView mv = new ModelAndView("admin/admin");

        List<BookingListDto> allBookings = bookingService.selectAllBookings();
        mv.addObject("bookings", allBookings);

        List<UserDto> allUsers = userService.selectAllUsers();
        mv.addObject("users", allUsers);
        return mv;

    }
}
