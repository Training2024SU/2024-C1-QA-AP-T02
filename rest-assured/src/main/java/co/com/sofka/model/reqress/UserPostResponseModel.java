package co.com.sofka.model.reqress;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostResponseModel {
    private int id;
    private String name;
    private String job;

    public UserPostResponseModel() {
    }

    @Override
    public String toString() {
        return "UserPostResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
