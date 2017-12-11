package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.Message;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface MessageRepository {
    void addMessage(Message message);

    Message getMessageById(Long id);

    List<Message> getMessagesInChat(Chat chat);
}
