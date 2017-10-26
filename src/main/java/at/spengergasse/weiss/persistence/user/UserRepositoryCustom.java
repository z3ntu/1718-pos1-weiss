package at.spengergasse.weiss.persistence.user;

import at.spengergasse.weiss.domain.User;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface UserRepositoryCustom {
    public List<User> getUsersWhoseUsernamesStartWith(String startsWith);
}
