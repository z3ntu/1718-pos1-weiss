package at.spengergasse.weiss.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String realname;
}