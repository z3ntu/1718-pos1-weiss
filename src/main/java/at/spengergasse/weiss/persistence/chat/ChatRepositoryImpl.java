package at.spengergasse.weiss.persistence.chat;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.QChat;
import at.spengergasse.weiss.domain.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class ChatRepositoryImpl extends QueryDslRepositorySupport implements ChatRepositoryCustom {

    public ChatRepositoryImpl() {
        super(Chat.class);
    }

    @Override
    public List<Chat> getChatsByUser(User user) {
        QChat chat = QChat.chat;
        return from(chat).where(ChatPredicates.chatIsWithUser(user)).fetch();
    }
}
