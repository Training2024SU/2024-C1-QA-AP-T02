package com.davidbonelo.models;

import java.util.Objects;

public class Album {
    private User user;
    private Integer id;
    private String title;

    public Album() {
    }

    public Album(User user, Integer id, String title) {
        this.user = user;
        this.id = id;
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) && Objects.equals(title, album.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Album{" + "user=" + user.getFullName() + ", id=" + id + ", title='" + title + '\'' + '}';
    }
}
