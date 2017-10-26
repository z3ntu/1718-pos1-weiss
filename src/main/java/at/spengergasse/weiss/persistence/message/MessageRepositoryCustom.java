package at.spengergasse.weiss.persistence.message;

import at.spengergasse.weiss.domain.Message;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface MessageRepositoryCustom {
    public List<Message> getMessagesBefore(LocalDateTime dateTime);
}
