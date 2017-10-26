package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.QChat;
import at.spengergasse.weiss.domain.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public List<Chat> getChatsByUser(User user) {
        QChat chat = QChat.chat;
        return from(chat).where(ChatPredicates.chatIsWithUser(user)).fetch();
    }
}
