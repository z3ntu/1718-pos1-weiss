package at.spengergasse.weiss.converters;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.persistence.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.sql2o.converters.Converter;
import org.sql2o.converters.ConverterException;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@Component
public class ChatConverter implements Converter<Chat> {

    @Autowired
    @Lazy
    private ChatRepository chatRepository;

    @Override
    public Chat convert(Object val) throws ConverterException {
        if (val instanceof Number) {
            Long chatId = ((Number) val).longValue();
            return chatRepository.getChatById(chatId);
        } else {
            return null;
        }
    }

    @Override
    public Object toDatabaseParam(Chat val) {
        if (val == null) {
            return null;
        } else {
            return val.getId();
        }
    }
}
