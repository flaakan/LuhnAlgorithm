package se.experis.johnny;

public class LuhnAlgorithm {

    public void printProvided(int providedNumber){
        System.out.println("Provided number: " + providedNumber);
    }

    /**
     * Checks if the entered number is a credit card
     * @param length the length of the number
     * @return boolean true if credit card
     */
    public boolean checkIfCreditCard(int length) {
        if (length == 16) {
            System.out.println("It is a credit card");
            return true;
        } else {
            System.out.println("It is not a credit card");
            return false;
        }
    }

    public void printExpected(int expectedValue){
        System.out.println("Expected value: " + expectedValue);
    }

    public void printValid(boolean isValid){
        System.out.println(isValid ?  "This is valid": "This is not valid");
    }

    /**
     * Gets the expected value of the last number on the card
     * @param sum the sum of the card numbers except the last number after using luhns algorithm.
     * @return int the expected value of the last number to make this card valid
     */
    public int getExpectedValue(int sum){
        int expected =(10 - sum % 10);
        if(expected == 10){
            expected = 0;
        }
        return expected;
    }


    /**
     * Checks if the cardNumbers + lastCardNumber is valid according to Luhns algorithm.
     * @param cardNumbers all numbers on the card except the last number
     * @param lastCardNumber the last number on the card
     * @return boolean if this card is valid
     */
    public boolean checkLuhn(String cardNumbers,int lastCardNumber) {
        int length = cardNumbers.length();
        int sum = 0;
        boolean isSecond = true;
        for (int i = length - 1; i >= 0; i--){
            int d = cardNumbers.charAt(i) - '0';
            if (isSecond == true){
                d = d * 2;
            }
            sum += d / 10;
            sum += d % 10;
            isSecond = !isSecond;
            if(i == 0){
                int expected = getExpectedValue(sum);
                printExpected(expected);
                sum += lastCardNumber;
            }
        }
        return (sum % 10 == 0);
    }
}
