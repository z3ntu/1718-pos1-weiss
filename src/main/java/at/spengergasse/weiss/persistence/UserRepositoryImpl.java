package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void addUser(User user) {
        final String insertQuery =
                "INSERT INTO user (username, realname) " +
                        "VALUES (:username, :realname)";

        try (Connection con = sql2o.beginTransaction()) {
            Long id = con.createQuery(insertQuery, true)
                    .addParameter("username", user.getUsername())
                    .addParameter("realname", user.getRealname())
                    .executeUpdate()
                    .getKey(Long.class);
            con.commit();
            user.setId(id);
        }
    }

    @Override
    public User getUserById(Long id) {
        String sql =
                "SELECT id, username, realname " +
                        "FROM user " +
                        "WHERE id=:id";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String sql =
                "SELECT id, username, realname " +
                        "FROM user " +
                        "WHERE username=:username";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("username", username)
                    .executeAndFetchFirst(User.class);
        }
    }
}
