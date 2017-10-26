package at.spengergasse.weiss.persistence.message;

import at.spengergasse.weiss.domain.QMessage;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.time.LocalDateTime;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class MessagePredicates {
    public static BooleanExpression messageWasSentBefore(LocalDateTime dateTime) {
        return QMessage.message.sentAt.before(dateTime);
    }
}
