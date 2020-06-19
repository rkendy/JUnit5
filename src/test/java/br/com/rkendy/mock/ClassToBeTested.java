package br.com.rkendy.mock;

public class ClassToBeTested {
    private ClassToBeMocked someField;

    public int multiplyByTwoAndAddTen(int x) {
        int y = someField.multiplyByTwo(x);
        return y + 10;
    }
}