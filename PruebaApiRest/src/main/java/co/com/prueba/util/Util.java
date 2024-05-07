package co.com.prueba.util;

import com.github.javafaker.Faker;
import io.cucumber.core.backend.TestCaseState;

import java.util.HashMap;
import java.util.Map;

import static co.com.prueba.util.ConstantesApi.*;
import static co.com.prueba.util.ConstantesApi.JOB;

public class Util {

    public static String trabajo(){
        Faker faker = new Faker();
        return faker.job().title();
    }
    public static String nombre(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

}

