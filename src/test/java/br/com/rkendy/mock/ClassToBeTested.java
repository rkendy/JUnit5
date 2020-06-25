package br.com.rkendy.mock;

import java.util.ArrayList;
import java.util.List;

public class ClassToBeTested {

    private static final int STATIC_VALUE;
    private static final List<String> STATIC_CLASS;

    static {
        STATIC_VALUE = 10;
        STATIC_CLASS = new ArrayList<>();
    }
    private ClassToBeMocked externalService;

    public int multiplyByFourOrFive(int x) {
        if (x <= 10) {
            return x * 4;
        }
        return x * 5;
    }

    public int multiplyByTwoAndAddTen(int x) {
        if (x == 0)
            throw new IllegalArgumentException("Cannot be zero");

        int y = externalService.multiplyByTwo(x);
        return y + 10;
    }

    public int methodUsingStaticValues() {
        int toAdd = 5;
        if (STATIC_CLASS.add(Integer.toString(STATIC_VALUE))) {
            toAdd = 10;
        }
        return STATIC_VALUE + toAdd + STATIC_CLASS.size();
    }
}