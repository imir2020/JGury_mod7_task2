package by.javagury.spring.database.repository;


import by.javagury.spring.database.entity.Role;
import by.javagury.spring.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    User save(User user);



//    @Query("""
//            select u from User u
//            where (u.birthDate between :after and :before)
//            and u.role =:role
//
//            """)
    List<User> findAllByRoleAndBirthDateBetween(Role role,LocalDate after, LocalDate before);



}
