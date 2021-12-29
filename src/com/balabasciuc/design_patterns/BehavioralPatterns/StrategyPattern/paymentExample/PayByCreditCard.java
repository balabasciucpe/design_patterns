package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.paymentExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    //value Obj Class
    private CreditCard creditCard;


    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try
        {
            System.out.println("Enter your Card Details...");
            System.out.println("Enter the card number");
            String cardNumber = READER.readLine();
            System.out.println("Enter your card expiration date: ");
            String date = READER.readLine();
            System.out.println("Enter the CVV code: ");
            String cvv = READER.readLine();
          //  creditCard = new CreditCard(cardNumber, date, cvv);
            //validate infos
        }
        catch (IOException e) { e.printStackTrace(); }
    }


}
