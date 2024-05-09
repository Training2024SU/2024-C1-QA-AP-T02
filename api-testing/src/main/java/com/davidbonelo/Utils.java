package com.davidbonelo;

import java.util.List;

public class Utils {
    public static Object pickRandomItem(List<?> list) {
        int randomIdx = (int) Math.floor(Math.random() * list.size());
        return list.get(randomIdx);
    }
}
