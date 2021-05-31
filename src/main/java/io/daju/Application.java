package io.daju;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String PROMPT = "Type a symbol to predict its next day close price. Q to quit.";
        PredictMachine predictMachine = new PredictMachine();
        System.out.println("Application starting ....");
        Scanner input = new Scanner(System.in);

        System.out.println(PROMPT);
        String symbol = input.next();

        while (!"Q".equalsIgnoreCase(symbol)) {
            try {
                predictMachine.predict(symbol);
            } catch (KNNException e) {
                e.printStackTrace();
            }
            System.out.println(PROMPT);
            symbol = input.next();
        }
    }
}
