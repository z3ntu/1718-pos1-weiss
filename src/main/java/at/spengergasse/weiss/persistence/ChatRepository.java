package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.User;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface ChatRepository {
    void addChat(Chat chat);

    List<Chat> getChatsByUser(User user);
    Chat getChatById(Long id);
}
