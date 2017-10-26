package at.spengergasse.weiss.persistence.user;

import at.spengergasse.weiss.domain.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
public class UserPredicates {
    public static BooleanExpression usernameStartsWith(String startsWith) {
        return QUser.user.username.startsWith(startsWith);
    }
}
