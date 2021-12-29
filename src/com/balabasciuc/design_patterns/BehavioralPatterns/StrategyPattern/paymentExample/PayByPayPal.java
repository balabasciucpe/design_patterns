package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.paymentExample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean isSigned;

    static {
        DATA_BASE.put("user1", "emailuser1@test.com");
        DATA_BASE.put("user2", "emailuser2@test.com");
    }


    @Override
    public void collectPaymentDetails() {
        try {
            while (!isSigned) {
                System.out.println("Please enter your email: ");
                email = bufferedReader.readLine();
                System.out.println("Please enter your password: ");
                password = bufferedReader.readLine();
                if (verify()) {
                    System.out.println("Logging in...");
                } else {
                    System.out.println("Wrong information");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

        private boolean verify()
        {
            setSigned(email.equals(DATA_BASE.get(password)));
            return isSigned;
        }

        private void setSigned ( boolean signed){
            isSigned = signed;
        }

    @Override
    public boolean pay(int paymentAmount) {

        if(isSigned)
        {   //guards
            System.out.println("Paying " + paymentAmount + "using PayPal");
            return true;
        }
        else
        {
            System.out.println("Cant pay...");
            return false;
        }

    }

}