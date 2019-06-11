package models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{name.not.empty}")
    @Size(min = 2, max = 20, message = "{name.size}")
    @NotBlank(message = "{name.space}")
    private String name;
    @NotEmpty(message = "{password.not.empty}")
    @NotBlank(message = "{password.space}")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
