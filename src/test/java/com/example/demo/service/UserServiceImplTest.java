package com.example.demo.service;

import com.example.demo.entity.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    ApplicationUserRepository applicationUserRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void should_match_valid_user() {
        // given:
        ApplicationUser user = new ApplicationUser("bj", "123");
        when(userService.getAllUsers()).thenReturn(createUsersSamples());

        // when:
        ApplicationUser userAfterValidation = userService.login(user).orElse(null);

        // then:
        assertNotNull(userAfterValidation);
    }

    @Test
    public void should_not_match_invalid_user_wrong_password() {
        // given:
        ApplicationUser user = new ApplicationUser("bj", "000");
        when(userService.getAllUsers()).thenReturn(createUsersSamples());

        // when:
        ApplicationUser userAfterValidation = userService.login(user).orElse(null);

        // then:
        assertNull(userAfterValidation);
    }

    @Test
    public void should_not_match_invalid_user_wrong_login() {
        // given:
        ApplicationUser user = new ApplicationUser("jj", "000");
        when(userService.getAllUsers()).thenReturn(createUsersSamples());

        // when:
        ApplicationUser userAfterValidation = userService.login(user).orElse(null);

        // then:
        assertNull(userAfterValidation);
    }


    private List<ApplicationUser> createUsersSamples() {
        return Arrays.asList(
                new ApplicationUser("bj", "123"),
                new ApplicationUser("kcr", "234")
        );
    }
}