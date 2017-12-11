package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.User;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface UserRepository {
    void addUser(User user);

    User getUserById(Long id);

    User getUserByUsername(String username);
}
