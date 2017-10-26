package at.spengergasse.weiss;

import at.spengergasse.weiss.domain.User;
import at.spengergasse.weiss.persistence.chat.ChatRepository;
import at.spengergasse.weiss.persistence.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUsersWhoseUsernamesStartWith() {
        User user1 = new User("abcdef", "Test");
        User user2 = new User("abghij", "Test2");
        User user3 = new User("aklmno", "Test3");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        assertThat(userRepository.getUsersWhoseUsernamesStartWith("ab")).containsExactly(user1, user2);
    }
}
