package com.spendit.user.api.service;

import com.spendit.user.api.model.User;
import com.spendit.user.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void shallGetUserByUsername() {

        String username = "zohaib";

        User user = new User();
        user.setId(1);
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(user);

        User retrievedUser = userService.getUserByUsername(username);
        verify(userRepository).findByUsername(username);

        assertThat(retrievedUser.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    public void shallGetUserByEmail() {

        String email = "abc@abc.com";

        User user = new User();
        user.setId(1);
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(user);

        User retrievedUser = userService.getUserByEmail(email);
        verify(userRepository).findByEmail(email);

        assertThat(retrievedUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void shallUpdateUser() {

        String username = "zohaib";
        String password = "oldpassword";
        String newPassword = "newpassword";
        String encodedPassword = "encodedpassword";

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        when(userRepository.findByUsername(username)).thenReturn(user);
        when(bCryptPasswordEncoder.encode(newPassword)).thenReturn(encodedPassword);

        userService.updateUserByPassword(username, newPassword);

        verify(userRepository).save(user);
        assertThat(user.getPassword()).isEqualTo(encodedPassword);
    }

    @Test
    public void shallSaveUser() {

        String username = "zohaib";
        String password = "password";
        String email = "abc@gmail.com";

        User user = new User();
        user.setId(1);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        userService.save(user);
        verify(userRepository).save(user);
    }
}
