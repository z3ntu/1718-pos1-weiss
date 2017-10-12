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
@Table(name = "chat")
@NoArgsConstructor
@RequiredArgsConstructor
public class Chat extends BaseDomain<Chat, Long> {

    @NonNull
    @Column(name= "chatId")
    private Integer chatId;

    @NonNull
    @Column(name = "user1")
    private User user1;

    @NonNull
    @Column(name = "user2")
    private User user2;

    @Override
    public int compareTo(Chat chat) {
        return chatId.compareTo(chat.getChatId());
    }
}
