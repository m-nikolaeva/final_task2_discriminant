package ru.gb;

public class Main {
    public static void main(String[] args) throws NotFoundAnswerException {
        MathService mathService = new MathService();

        System.out.println(mathService.getAnswer(2, -7, 5).toString());
        System.out.println(mathService.getD(2, -7, 5));
    }
}