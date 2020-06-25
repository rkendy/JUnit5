package br.com.rkendy.mock;

public class ClassToBeMocked {

    public int multiplyByTwo(int x) {
        if (x < 0) {
            throw new NumberFormatException("Cannot accept negative number");
        }
        return x * 2;
    }

}