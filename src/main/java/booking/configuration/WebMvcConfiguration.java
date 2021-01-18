package booking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import booking.interceptor.LoginCheck;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Bean
    MappingJackson2JsonView jsonView(){
        return new MappingJackson2JsonView();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheck())
		.addPathPatterns("/booking/*")
		.excludePathPatterns("/booking/home.do")
		.excludePathPatterns("/booking/loginCheck.do");
	}
}
