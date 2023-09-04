package strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayByPaypal implements PayStrategy {
    private static final Logger LOGGER = Logger.getLogger("PayByPaypal");
    private static final Map<String, String> DATABASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATABASE.put("john", "john@gmail.com");
        DATABASE.put("jane", "jane@gmail.com");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if(signedIn){
            System.out.println("Paying " + paymentAmount + " using Paypal.");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try{
            while(!signedIn){
                System.out.println("Enter user's email: ");
                this.email = READER.readLine();
                System.out.println("Enter the password");
                this.password = READER.readLine();
                if(verify()){
                    System.out.println("Data verification has been successful.");
                }else{
                    System.out.println("Wrong email or password");
                }
            }
        }catch(IOException e){
            LOGGER.log(Level.SEVERE, "i/o error");
        }
    }

    private boolean verify(){
        setSignedIn(this.email.equals(DATABASE.get(this.password)));
       return signedIn;
    }

    private void setSignedIn(boolean signedIn){
        this.signedIn = signedIn;
    }
}
