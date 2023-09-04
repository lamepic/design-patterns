package strategy;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayByCreditCard implements PayStrategy{
//    private static final Logger LOGGER = Logger.getLogger("PayByCreditCard");
    private static final Scanner READER = new Scanner(System.in);
    private CreditCard creditCard;


    @Override
    public boolean pay(int paymentAmount) {
        if(cardIsPresent()){
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            this.creditCard.setAmount(this.creditCard.getAmount() - paymentAmount);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Enter card number");
        String number = READER.nextLine();
        System.out.println("Enter the card expiration date 'mm/yy': ");
        String date = READER.nextLine();
        System.out.println("Enter the CVV code: ");
        String cvv = READER.nextLine();
        this.creditCard = new CreditCard(number, cvv, date);
//        try{
//            System.out.println("Enter card number");
//            String number = READER.nextLine();
//        }catch(IOException e){
//            LOGGER.log(Level.SEVERE, "i/o error");
//        }
    }

    private boolean cardIsPresent(){
        return this.creditCard != null;
    }
}
