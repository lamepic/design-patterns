package strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayByBitcoin implements PayStrategy{
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> DATABASE = new HashMap<>();
    private String bitcoinAddress;
    private String email;
    private boolean verified;

    static {
        DATABASE.put("lamepic@gmail.com", "lamepicxyz");
    }
    @Override
    public boolean pay(int paymentAmount) {
        if(verified){
            System.out.println("Paying " + paymentAmount + " using Bitcoin.");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Enter your email address: ");
        this.email = scanner.nextLine();
        System.out.println("Enter your Bitcoin address: ");
        this.bitcoinAddress = scanner.nextLine();

        if(verify()){
            System.out.println("Address verified successfully!");
        }else{
            System.out.println("Invalid address");
        }
    }

    private boolean verify(){
        this.setVerified(this.bitcoinAddress.equals(DATABASE.get(this.email)));
        return this.verified;
    }

    private void setVerified(boolean verified){
        this.verified = verified;
    }
}
