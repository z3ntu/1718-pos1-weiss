package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Chat {

    @NonNull
    private Integer chatId;

    @NonNull
    private User user1;

    @NonNull
    private User user2;
}
