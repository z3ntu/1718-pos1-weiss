package at.spengergasse.weiss;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.Message;
import at.spengergasse.weiss.domain.User;
import at.spengergasse.weiss.persistence.chat.ChatRepository;
import at.spengergasse.weiss.persistence.message.MessageRepository;
import at.spengergasse.weiss.persistence.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class MessageRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testGetMessagesBefore() {
        User user1 = new User("Xorok", "Adrian Tiefenbrunner");
        User user2 = new User("z3ntu", "Luca Weiss");
        userRepository.save(user1);
        userRepository.save(user2);

        Chat chat1 = new Chat(user1, user2, LocalDateTime.now());
        chatRepository.save(chat1);

        LocalDateTime time1 = LocalDateTime.parse("2017-10-26T12:47:06");
        LocalDateTime time2 = LocalDateTime.parse("2017-10-26T20:52:30");
        LocalDateTime time3 = LocalDateTime.parse("2017-10-26T20:57:35");

        Message msg1 = new Message(user1, chat1, time1);
        Message msg2 = new Message(user2, chat1, time2);
        Message msg3 = new Message(user1, chat1, time3);
        messageRepository.save(msg1);
        messageRepository.save(msg2);
        messageRepository.save(msg3);

        LocalDateTime time4 = LocalDateTime.parse("2017-10-26T20:53:28");

        assertThat(messageRepository.getMessagesBefore(time4)).containsExactly(msg1, msg2);
    }
}
