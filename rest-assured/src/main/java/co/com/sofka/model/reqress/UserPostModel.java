package co.com.sofka.model.reqress;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPostModel {
    private String name;
    private String job;

    public UserPostModel() {
    }

    @Override
    public String toString() {
        return "UserPostModel{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
