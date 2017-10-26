package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "message")
@NoArgsConstructor
@RequiredArgsConstructor
public class Message extends BaseDomain<Message, Long> {

    @NonNull
    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "chat")
    private Chat chat;

    @NonNull
    @Column(name = "sentAt")
    private LocalDateTime sentAt;

    @Override
    public int compareTo(Message message) {
        return getId().compareTo(message.getId());
    }
}