package co.com.sofka.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostModel {
    private String id;
    private String title;
    private String body;
    private String userId;

    public PostModel() {
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
