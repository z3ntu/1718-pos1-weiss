package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@Repository
public class ChatRepositoryImpl implements ChatRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void addChat(Chat chat) {
        final String sql =
                "INSERT INTO chat (user1, user2, createdAt) " +
                        "VALUES (:user1, :user2, :createdAt)";

        try (Connection con = sql2o.beginTransaction()) {
            Long id = con.createQuery(sql, true)
                    .addParameter("user1", chat.getUser1().getId())
                    .addParameter("user2", chat.getUser2().getId())
                    .addParameter("createdAt", chat.getCreatedAt())
                    .executeUpdate()
                    .getKey(Long.class);
            con.commit();
            chat.setId(id);
        }
    }

    @Override
    public List<Chat> getChatsByUser(User user) {
        final String sql =
                "SELECT chat.id, user1, user2, createdAt " +
                        "FROM chat " +
                        "WHERE user1=:user OR " +
                        "user2=:user";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("user", user.getId())
                    .executeAndFetch(Chat.class);
        }
    }

    @Override
    public Chat getChatById(Long id) {
        final String sql =
                "SELECT chat.id, user1, user2, createdAt " +
                        "FROM chat " +
                        "WHERE id=:id";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Chat.class);
        }
    }
}
