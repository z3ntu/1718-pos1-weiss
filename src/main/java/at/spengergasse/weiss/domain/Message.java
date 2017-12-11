package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {

    private Long id;

    @NonNull
    private User sender;

    @NonNull
    private Chat chat;

    @NonNull
    private String content;

    @NonNull
    private DateTime sentAt;
}