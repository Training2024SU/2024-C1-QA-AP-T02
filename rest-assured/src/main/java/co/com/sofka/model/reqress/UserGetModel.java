package co.com.sofka.model.reqress;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserGetModel {
    private String id;
    private String email;
    private String firstName;
    private String lastName;

    public UserGetModel() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
