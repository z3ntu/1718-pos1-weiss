package at.spengergasse.weiss.persistence.message;

import at.spengergasse.weiss.domain.Message;
import at.spengergasse.weiss.domain.QMessage;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class MessageRepositoryImpl extends QueryDslRepositorySupport implements MessageRepositoryCustom {

    public MessageRepositoryImpl() {
        super(Message.class);
    }

    @Override
    public List<Message> getMessagesBefore(LocalDateTime dateTime) {
        QMessage message = QMessage.message;
        return from(message).where(MessagePredicates.messageWasSentBefore(dateTime)).fetch();
    }
}
