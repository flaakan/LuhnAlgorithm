package se.experis.johnny;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static public void main(String[] args) {

        System.out.println("Please enter a card number:");
        String input = scanner.nextLine();
        input = input.replaceAll("\\s","");

        String cardNumbers = input.substring(0,input.length()-1);
        int lastCardNumber = Integer.parseInt(input.substring(input.length()-1));

        LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm();
        luhnAlgorithm.checkIfCreditCard(input.length());
        luhnAlgorithm.printProvided(lastCardNumber);

        boolean isValid = luhnAlgorithm.checkLuhn(cardNumbers,lastCardNumber);

        luhnAlgorithm.printValid(isValid);
    }

}