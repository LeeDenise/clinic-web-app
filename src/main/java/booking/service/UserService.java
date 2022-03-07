package booking.service;

import booking.models.SecurityUser;
import booking.mapper.UserMapper;
import booking.models.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> selectAllUsers() throws Exception {
        return userMapper.selectAllUsers();
    }

    public void insertUser(UserDto userDto){
        // TODO: add a logic to separate client and admin & change it to builder pattern.
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userMapper.insertClient(userDto);
    }

    public Optional<UserDto> selectUserByUserId(String email) {
        return userMapper.selectUserByUserId(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return selectUserByUserId(email)
                .map(
                        userDto -> {
                            SecurityUser securityUser = new SecurityUser();
                            securityUser.setClientId(userDto.getUserId());
                            securityUser.setEmail(userDto.getEmail());
                            securityUser.setFirstName(userDto.getFirstName());
                            securityUser.setLastName(userDto.getLastName());
                            securityUser.setPassword(userDto.getPassword());
                            securityUser.setPhone(userDto.getPhone());
                            securityUser.setAuthorities(userDto.getRole());
                            return securityUser;
                        }
                )
                .orElseThrow( () ->
                new UsernameNotFoundException(String.format("Username %s not found", email))
        );
    }

}
