package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {

    @NonNull
    private Long msgid;

    @NonNull
    private User sender;

    @NonNull
    private Chat chat;
}