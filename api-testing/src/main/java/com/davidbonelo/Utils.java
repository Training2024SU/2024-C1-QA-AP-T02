package com.davidbonelo;

import java.util.List;

public class Utils {
    public static Object pickRandomItem(List<?> list) {
        int randomIdx = Math.toIntExact(Math.round(Math.random() * list.size() - 1));
        return list.get(randomIdx);
    }
}
