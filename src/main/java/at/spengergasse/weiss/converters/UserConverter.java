package at.spengergasse.weiss.converters;

import at.spengergasse.weiss.domain.User;
import at.spengergasse.weiss.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.converters.Converter;
import org.sql2o.converters.ConverterException;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@Component
public class UserConverter implements Converter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(Object val) throws ConverterException {
        if (val instanceof Number) {
            Long userId = ((Number) val).longValue();
            return userRepository.getUserById(userId);
        } else {
            return null;
        }
    }

    @Override
    public Object toDatabaseParam(User val) {
        if (val == null) {
            return null;
        } else {
            return val.getId();
        }
    }
}
