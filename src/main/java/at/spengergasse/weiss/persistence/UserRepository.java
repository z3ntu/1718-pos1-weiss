package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.User;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public interface UserRepository {
    public void addUser(User user);

    public User getUserById(Long id);

    public User getUserByUsername(String username);
}
