package at.spengergasse.weiss;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.Message;
import at.spengergasse.weiss.domain.User;
import at.spengergasse.weiss.persistence.ChatRepository;
import at.spengergasse.weiss.persistence.MessageRepository;
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
public class MessageRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() {
        User user1 = new User("Xorok", "Adrian Tiefenbrunner");
        User user2 = new User("z3ntu", "Luca Weiss");
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        Chat chat1 = new Chat(user1, user2, DateTime.now());
        chatRepository.addChat(chat1);

        Message msg1 = new Message(user1, chat1, "Hello Luca", DateTime.now());
        messageRepository.addMessage(msg1);

        assertThat(msg1.getId()).isNotNull();
        assertThat(messageRepository.getMessageById(msg1.getId())).isEqualTo(msg1);
    }

    @Test
    public void testGetMessagesInChat() {
        User user1 = new User("Xorok", "Adrian Tiefenbrunner");
        User user2 = new User("z3ntu", "Luca Weiss");
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        Chat chat1 = new Chat(user1, user2, DateTime.now());
        chatRepository.addChat(chat1);

        Message msg1 = new Message(user1, chat1, "Hello Luca", DateTime.now());
        messageRepository.addMessage(msg1);

        Message msg2 = new Message(user2, chat1, "Hello Adrian", DateTime.now());
        messageRepository.addMessage(msg2);

        assertThat(messageRepository.getMessagesInChat(chat1)).containsOnly(msg1, msg2);
    }
}
