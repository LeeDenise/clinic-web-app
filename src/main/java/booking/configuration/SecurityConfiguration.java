package booking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/booking/home.do").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                    .defaultSuccessUrl("/booking/home.do");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails basicUser = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(
                basicUser
        );

    }
}
