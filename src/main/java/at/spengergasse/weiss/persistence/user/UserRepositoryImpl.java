package at.spengergasse.weiss.persistence.user;

import at.spengergasse.weiss.domain.QUser;
import at.spengergasse.weiss.domain.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public List<User> getUsersWhoseUsernamesStartWith(String startsWith) {
        QUser user = QUser.user;
        return from(user).where(UserPredicates.usernameStartsWith(startsWith)).fetch();
    }
}
