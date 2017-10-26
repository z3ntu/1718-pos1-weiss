package at.spengergasse.weiss.persistence.chat;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.User;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface ChatRepositoryCustom {
    public List<Chat> getChatsByUser(User user);
}
