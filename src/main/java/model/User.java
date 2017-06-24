package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Administrator on 24/06/2017.
 */
@Entity
@Table(name = "login")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        @NamedQuery(name = "User.isValid",query = "from User user where user.userName = :userName AND user.password = :password")
)
public class User {
    public static final String CHECK_USER = "User.isValid";
    @Id
    @Column(name = "tai_khoan")
    private String userName;
    @Column(name = "mat_khau")
    private String password;
    @Column(name = "dang_nhap_la")
    @Enumerated(EnumType.STRING)
    private Role role;
}
