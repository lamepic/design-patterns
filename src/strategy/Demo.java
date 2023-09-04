package strategy;

import java.util.*;

public class Demo {
    private static final Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static final List<String> products = new ArrayList<>();
    private static final List<String> paymentMethods = new ArrayList<>();
    private static final Formatter formatter = new Formatter(System.out);
    private static final Scanner scanner = new Scanner(System.in);
    private static final Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1009);
        priceOnProducts.put(3, 3223);
        priceOnProducts.put(4, 1002);

        products.add("Mother Board");
        products.add("CPU");
        products.add("HDD");
        products.add("Memory");

        paymentMethods.add("PayPal");
        paymentMethods.add("Credit Card");
        paymentMethods.add("Bitcoin");

    }

    public static void main(String[] args) {
        while (!order.isClosed()){
            int cost;

            String continueChoice;
            do{
                System.out.println("Please select a product:");
                for(int i=1; i<=products.size(); i++){
                    formatter.format("%5d - %s \n", i, products.get(i-1));
                }

                int choice = scanner.nextInt();
                cost = priceOnProducts.get(choice);
                System.out.println("Count: ");
                int count = scanner.nextInt();
                order.setTotalCost(cost * count);
                System.out.println("Do you wish to continue selecting products? Y/N");
                continueChoice = scanner.next();
            }while (continueChoice.equalsIgnoreCase("Y"));

            if(strategy == null){
                System.out.println("Please select a payment method: ");
                for(int i=1; i<=paymentMethods.size(); i++){
                    formatter.format("%5d - %s \n", i, paymentMethods.get(i-1));
                }
                String paymentMethod = scanner.next();

                switch(paymentMethod){
                    case "1" -> {
                        strategy = new PayByPaypal();
                    }
                    case "2" -> {
                        strategy = new PayByCreditCard();
                    }
                    case "3" -> {
                        strategy = new PayByBitcoin();
                    }
                }
            }

            order.processOrder(strategy);

            System.out.println("Pay " + order.getTotalCost() + " units or continue shopping? P/C: ");
            String proceed = scanner.next();
            if(proceed.equalsIgnoreCase("P")){
                if(strategy.pay(order.getTotalCost())){
                    System.out.println("Payment has been made successfully!");
                }else{
                    System.out.println("Fail! Please check your data. ");
                }
                order.setClosed();
            }
        }
    }
}
