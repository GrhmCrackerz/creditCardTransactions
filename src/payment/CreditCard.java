package payment;

import client.Person;
import goods.Item;
import java.util.ArrayList;
import java.util.Date;

public class CreditCard {

    private Person cardHolder;
    private String type;
    private String cardNumber;
    private double creditLimit;
    private double currentBalance;
    private double nextPaymentAmount;

    private ArrayList<Item> transactions;
    private ArrayList<Date> transactionsTimeStamps;

    //Constructor

    public CreditCard(Person cardHolder, String type, double creditLimit){
        this.cardHolder = cardHolder;
        this.type = type;
        this.creditLimit = creditLimit;

        transactions = new ArrayList<Item>();
        transactionsTimeStamps = new ArrayList<Date>();

    }//end step 9

    public Person getCardHolder() {
        return cardHolder;
    }

    public String getType() {
        return type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getNextPaymentAmount() {
        return nextPaymentAmount;
    }

    public void makeCharge(Item item){

        if(item.getPrice() < creditLimit - getCurrentBalance()){

            transactions.add(item);
            Date date = new Date();
            transactionsTimeStamps.add(date);
            currentBalance += item.getPrice();

            System.out.println("");
            System.out.println("Charging: " + item.getName());
            System.out.println("Transaction completed successfully");
            System.out.println("Please remove your " + type);
            System.out.println("");
        }else{
            System.out.println("");
            System.out.println("Charging: " + item.getName());
            System.out.println("Transaction was not successful");
            System.out.println("Credit Limit Issue");
            System.out.println("Please remove your " + type);
            System.out.println("");
        }
    }//end makeCharge

    public void transactionsReport(){

        System.out.println("");
        System.out.println("============================================================================");
        System.out.println(type + " Transaction Report" );
        System.out.println("============================================================================");
        System.out.printf("%-20s $%-10.2f\n", "Credit Limit:",creditLimit);

// you need print out the Available Credit
        System.out.printf("Available Credit: \t $%-10.2f\n", creditLimit - currentBalance); //STEP 10 PART 2

        System.out.printf("%-20s $%-10.2f\n", "Current Balance:", currentBalance);
        System.out.println("------------------------------------------------------------------------");

        double totalCharges = 0.0;

        for(int i=0; i<transactions.size();i++){
            Item item = transactions.get(i);
            Date date = transactionsTimeStamps.get(i);
            System.out.printf("%-20s %-10s $%-10.2f %-10s\n",item.getName(),
                    item.getCategory(),
                    item.getPrice(),
                    date.toString() );
            totalCharges += item.getPrice();
        }//end for
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-15s Total Charges: $%-10.2f\n","", totalCharges);
    }//end transactionsReport


}
