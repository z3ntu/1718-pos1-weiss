package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chat")
@NoArgsConstructor
@RequiredArgsConstructor
public class Chat extends BaseDomain<Chat, Long> {

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user1")
    private User user1;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user2")
    private User user2;

    @NonNull
    @Column(name = "datetime")
    private LocalDateTime createdAt;

    @Override
    public int compareTo(Chat chat) {
        return getId().compareTo(chat.getId());
    }
}
