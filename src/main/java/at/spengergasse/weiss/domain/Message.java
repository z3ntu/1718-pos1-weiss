package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "message")
@NoArgsConstructor
@RequiredArgsConstructor
public class Message extends BaseDomain<Message, Long> {

    @NonNull
    @Column(name = "msgid")
    private Long msgid;

    @NonNull
    @Column(name= "sender")
    private User sender;

    @NonNull
    @Column(name= "chat")
    private Chat chat;

    @Override
    public int compareTo(Message message) {
        return msgid.compareTo(message.getMsgid());
    }
}