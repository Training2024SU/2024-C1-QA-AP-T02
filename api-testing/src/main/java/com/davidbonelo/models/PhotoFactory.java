package com.davidbonelo.models;

import net.datafaker.Faker;

import java.util.Locale;

public class PhotoFactory {
    public static Photo createFakePhoto() {
        Faker faker = new Faker(new Locale("es"));
        Photo photo = new Photo();
        photo.setTitle(faker.funnyName().name());
        photo.setUrl(faker.internet().url(false, false, true, true, false, true));
        photo.setThumbnailUrl(faker.internet().url(false, false, true, true, false, true));
        return photo;
    }
}
