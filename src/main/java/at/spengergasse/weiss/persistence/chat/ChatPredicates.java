package at.spengergasse.weiss.persistence.chat;

import at.spengergasse.weiss.domain.QChat;
import at.spengergasse.weiss.domain.User;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class ChatPredicates {

    public static BooleanExpression chatIsWithUser(User user) {
        return QChat.chat.user1.eq(user).or(QChat.chat.user2.eq(user));
    }

}
