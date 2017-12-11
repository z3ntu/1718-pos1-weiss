package at.spengergasse.weiss;

import at.spengergasse.weiss.domain.User;
import at.spengergasse.weiss.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        User user1 = new User("z3ntu", "Luca Weiss");
        userRepository.addUser(user1);
        assertThat(user1.getId()).isNotNull();

        User user2 = userRepository.getUserByUsername("z3ntu");
        assertThat(user2.getUsername()).isEqualTo(user1.getUsername());
        assertThat(user2.getRealname()).isEqualTo(user1.getRealname());
    }

}
