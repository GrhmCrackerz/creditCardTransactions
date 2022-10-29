package app;

import client.Person;
import goods.Item;
import payment.CreditCard;

import java.util.Random;

public class Controller {

    public static void main(String[] args) throws InterruptedException{

        yourInfoHeader();

        Person john = new Person("John", "Doe", "1100 Brickell Ave", "Apt 102",
                "Miami", "Florida"); //end of step 8


        //-------Start step 11
        CreditCard masterCard = new CreditCard(john, "MasterCard" , 2500.00);
        CreditCard ax = new CreditCard(john,"American Express", 5000.00);

        john.getCreditCards().add(masterCard);
        john.getCreditCards().add(ax);

        Item cafeMocha = new Item("Food", "Cafe Mocha", 4.77);
        Item gucciSlipper = new Item("Clothing" , "Gucci Princetown", 2650.00);
        Item coke = new Item("Food", "Coke", 1.99);
        Item airlinesTicket = new Item("Travel", "MIA-SFO", 823.26);
        //---------end step 11

        //---------start step 12
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);   //get(0) index 0 is assigned to the mastercard
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);

        ((CreditCard)john.getCreditCards().get(1)).makeCharge(gucciSlipper);//use americanexpress card to pay for slippers

        ((CreditCard)john.getCreditCards().get(0)).transactionsReport(); //run transaction report on mastercard

        ((CreditCard)john.getCreditCards().get(1)).transactionsReport(); // get(1) index 1 pulls americanexpress card
        //----------end step 12

        Random generator = new Random();

        //----------start step 13
        for(int i = 1; i<=7; i++){
            Thread.sleep(generator.nextInt(1001));

            if(i%3 == 0){
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
            }else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(cafeMocha);
            }
        }//end for loop cafeMocha purchase

        for(int i = 1; i <= 5; i++){
            Thread.sleep(generator.nextInt(1001));
            if(i%2 == 0){
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(airlinesTicket); //buy ticket if i is even with mastercard
            }else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(airlinesTicket); //else buy ticket with americanexpress
            }
        }



        for(int i = 1; i<=10; i++){
            Thread.sleep(generator.nextInt(1001));

            int randomSelectedCard = generator.nextInt(2);
            if( randomSelectedCard == 0){
                System.out.println("Random Selected Card Mastercard");
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(coke);

            }else if(randomSelectedCard == 1){
                System.out.println("Random Selected Card American Express");
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(coke);

            }
        }//end for loop 10 cokes with different cards
        //----------end step 13

        ((CreditCard)john.getCreditCards().get(0)).transactionsReport(); //run transaction report on mastercard

        ((CreditCard)john.getCreditCards().get(1)).transactionsReport(); //run transaction report on americanexpress card

        john.displayInfo();


    }//end of main

    public static void yourInfoHeader(){
        System.out.println("=====================================================");
        System.out.println("PROGRAMMER:\t\t\t Rodney Graham");
        System.out.println("PANTHER ID:\t\t\t 6196375");
        System.out.println();
        System.out.println("CLASS:\t\t\t\t COP2210");
        System.out.println("SECTION:\t\t\t U01");
        System.out.println("SEMESTER:\t\t\t SPRING 2022");
        System.out.println("CLASSTIME:\t\t\t T/TH 6:15-9:05PM");
        System.out.println();
        System.out.println("PROJECT:\t\t\t Project 2");
        System.out.println("DUE:\t\t\t\t 04/17/2022");
        System.out.println();
        System.out.println("I understand FIU's academic policies, and I certify that");
        System.out.println("this work is my own and that none of it is the work of");
        System.out.println("any other person.");

        System.out.println("=====================================================");
    }

}
