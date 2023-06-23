package rs.ac.bg.fon.pracenjepolaganja.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Represent users of our application.
 * Contains username, password and set of authorities(roles) that user have.
 *
 * @author Vuk Manojlovic
 */
@Entity
@Table(name="member")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member implements Serializable {

    /**
     * Primary key of member entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * Username of user.
     * Username is mandatory.
     * Username of every user is unique.
     * Username is email of user.
     */
    @Column(name="username")
    private String username;

    /**
     * Password of user.
     * Password is mandatory.
     */
    @Column(name="password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Set of authorities for user.
     * User can have roles as Admin or User.
     * Admin can make changes of elements in database where
     * User can only see elements of database.
     */
    @OneToMany(mappedBy="member",fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(getId(), member.getId()) && Objects.equals(getUsername(), member.getUsername()) && Objects.equals(getPassword(), member.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
