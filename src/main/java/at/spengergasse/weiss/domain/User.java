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
@Table(name = "user")
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends BaseDomain<User, Long> {

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "realname")
    private String realname;

    @Override
    public int compareTo(User user) {
        return username.compareTo(user.getUsername());
    }
}