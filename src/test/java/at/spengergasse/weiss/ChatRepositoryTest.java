package at.spengergasse.weiss;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.User;
import at.spengergasse.weiss.persistence.ChatRepository;
import at.spengergasse.weiss.persistence.UserRepository;
import org.joda.time.DateTime;
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
public class ChatRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Test
    public void testAddChat() {
        //TODO
    }

    @Test
    public void testGetChatsByUser() {
        User user1 = new User("Xorok", "Adrian Tiefenbrunner");
        User user2 = new User("z3ntu", "Luca Weiss");
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        Chat chat1 = new Chat(user1, user2, DateTime.now());
        chatRepository.addChat(chat1);

        assertThat(chatRepository.getChatsByUser(user1)).containsExactly(chat1);
    }
}
