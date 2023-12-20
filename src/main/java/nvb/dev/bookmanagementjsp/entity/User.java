package nvb.dev.bookmanagementjsp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    @JsonIgnore
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String password;

    public User(String username, String firstName, String lastName, int age, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }
}
