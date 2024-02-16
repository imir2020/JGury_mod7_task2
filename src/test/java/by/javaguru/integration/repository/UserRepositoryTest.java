package by.javaguru.integration.repository;

import by.javagury.spring.database.entity.Role;
import by.javagury.spring.database.repository.UserRepository;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {
    private static final Long USER_ID = 2L;
    private final UserRepository userRepository;

    @Test
    public void findById() {
        var user = userRepository.findById(USER_ID);
        assertNotNull(user);
    }

    @Test
    void findAllAdmin() {
        System.out.println(LocalDate.parse("1980-01-01"));
        var usersList = userRepository.findAllByRoleAndBirthDateBetween( Role.ADMIN,LocalDate.parse("1980-01-01"),
                LocalDate.parse("1990-01-01"));
        assertTrue(usersList.size() > 0);
        assertThat(usersList).hasSize(1);
        System.out.println(usersList);


    }
}