package booking.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import booking.dto.ClientDto;
import booking.interceptor.LoginCheck;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheck extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		try {
			ClientDto clientId = (ClientDto)session.getAttribute("clientId");
			
			if (ObjectUtils.isEmpty(clientId)) {
				response.sendRedirect("/booking/home.do");
				return false;
			}
			else {
				session.setMaxInactiveInterval(3600);
				return true;
			}
		}
		catch (ClassCastException e) {
			return true;
		}
//		ClientDto clientId = (ClientDto)session.getAttribute("clientId");

		
	}
}
