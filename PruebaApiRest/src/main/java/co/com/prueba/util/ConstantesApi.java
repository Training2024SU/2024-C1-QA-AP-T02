package co.com.prueba.util;

import static co.com.prueba.util.Util.nombre;
import static co.com.prueba.util.Util.trabajo;

public class ConstantesApi {
    public  static final String EMAIL_ESPERADO ="janet.weaver@reqres.in";
    public static String REQRES_IN_SINGLE_USER = "https://reqres.in/api/users/2";
    public static String REQRES_CREATE_USER = "https://reqres.in/api/users";
    public static String USER_TYPE_CODE = "https://jsonplaceholder.typicode.com/posts";
    public static String ALBUM = "https://jsonplaceholder.typicode.com/albums";
    public static String NAME = nombre();
    public static String JOB = trabajo();
    public static String VALUE_NAME = "name";
    public static String VALUE_JOB = "job";
    public static int EXPECTED_1= 201;
    public static int EXPECTED_2= 200;

}
