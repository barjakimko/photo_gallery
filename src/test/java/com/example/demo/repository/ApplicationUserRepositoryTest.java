package com.example.demo.repository;

import com.example.demo.entity.ApplicationUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@Sql("db_data_for_test.sql")
@DataJpaTest
public class ApplicationUserRepositoryTest {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Test
    public void should_find_user_by_login() {
        // given
        String login = "bj";

        //when
        ApplicationUser applicationUser = applicationUserRepository.findByLogin(login);

        //then
        assertEquals(applicationUser.getId(), 1L);
    }

    @Test
    public void should_not_find_user_by_login() {
        // given
        String login = "jj";

        //when
        ApplicationUser applicationUser = applicationUserRepository.findByLogin(login);

        //then
        assertNull(applicationUser);
    }

}