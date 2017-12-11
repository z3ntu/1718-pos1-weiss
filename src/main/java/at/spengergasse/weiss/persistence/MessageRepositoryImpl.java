package at.spengergasse.weiss.persistence;

import at.spengergasse.weiss.domain.Chat;
import at.spengergasse.weiss.domain.Message;
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
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void addMessage(Message message) {
        final String sql =
                "INSERT INTO message (sender, chat, content, sentAt) " +
                        "VALUES (:sender, :chat, :content, :sentAt)";

        try (Connection con = sql2o.beginTransaction()) {
            Long id = con.createQuery(sql, true)
                    .addParameter("sender", message.getSender())
                    .addParameter("chat", message.getChat())
                    .addParameter("content", message.getContent())
                    .addParameter("sentAt", message.getSentAt())
                    .executeUpdate()
                    .getKey(Long.class);
            con.commit();
            message.setId(id);
        }
    }

    @Override
    public Message getMessageById(Long id) {
        String sql =
                "SELECT id, sender, chat, content, sentAt " +
                        "FROM message " +
                        "WHERE id=:id";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Message.class);
        }
    }

    @Override
    public List<Message> getMessagesInChat(Chat chat) {
        String sql =
                "SELECT id, sender, chat, content, sentAt " +
                        "FROM message " +
                        "WHERE chat=:chat";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("chat", chat)
                    .executeAndFetch(Message.class);
        }
    }
}
