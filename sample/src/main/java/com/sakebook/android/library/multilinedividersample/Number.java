package com.sakebook.android.library.multilinedividersample;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sakemotoshinya on 2017/04/26.
 */

public enum Number {
    EVEN(1),
    ODD(10),
    PRIME(3),
    ;

    private static List<Integer> primeNumbers = Arrays.asList(2, 3, 5, 7, 11,
            13, 17, 19, 23, 29,
            31, 37, 41, 43, 47,
            53, 59, 61, 67, 71,
            73, 79, 83, 89, 97);

    private int id;
    Number(int i) {
        this.id = i;
    }

    public static Number id(int i) {
        if (primeNumbers.contains(i)) {
            return PRIME;
        } else if (i % 2 == 0) {
            return EVEN;
        } else {
            return ODD;
        }
    }

    public int type() {
        return this.id;
    }
}
