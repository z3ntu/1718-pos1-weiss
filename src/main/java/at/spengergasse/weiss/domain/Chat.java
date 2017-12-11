package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Chat {

    private Long id;

    @NonNull
    private User user1;

    @NonNull
    private User user2;

    @NonNull
    private DateTime createdAt;
}
