package strategy;

public class CreditCard {
    private int amount;
    private String number;
    private String cvv;
    private String date;

    CreditCard(String number, String cvv, String date){
        this.amount = 100_000;
        this.number = number;
        this.cvv = cvv;
        this.date = date;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }
}
