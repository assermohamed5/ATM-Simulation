package learning.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int correctPin=1234;
        double balance=2500.75;
        double depositedAmount;
        double withdrawalAmount;
        int depositsMade =0;
        int withdrawalsMade =0;
        System.out.println("Please enter your 4-digit PIN");
        int pin=scanner.nextInt();
        int trial =1;
        while(pin!=correctPin && trial <3) {


            System.out.println("Please enter your 4-digit PIN");
            pin=scanner.nextInt();
            trial++;
        }
        if(trial ==3 && pin!=correctPin){
            System.out.println("Your account has been locked ");
        }else {
            if (pin == correctPin) {
                System.out.println("Login Successful");

            }
            int choice;

            do {
                System.out.println("========= ATM =========");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Account Status");
                System.out.println("5. Exit");
                System.out.println("=======================");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(balance);
                        break;
                    case 2:
                        System.out.println("Enter the amount u want to Deposit ");
                        depositedAmount = scanner.nextDouble();
                        if (depositedAmount <= 0) {
                            System.out.println("invalid amount");
                        } else {
                            balance += depositedAmount;
                            depositsMade++;

                            System.out.println("Your current balance is : " + balance);
                        }
                        break;
                    case 3:
                        System.out.println("Enter the amount u want to Withdraw ");
                        withdrawalAmount = scanner.nextDouble();
                        if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                            balance -= withdrawalAmount;
                            withdrawalsMade++;
                            if (balance==0) {
                                System.out.println("Warning: Your account is empty.");}
                            System.out.println("Your current balance is : " + balance);

                        } else if (withdrawalAmount == 0) {
                            System.out.println("Transaction cancelled");
                        } else {
                            System.out.println("You don't have this amount to withdraw");
                        }


                        break;
                    case 4:
                        if (balance < 1000) {
                            System.out.println("You are low balance account");
                        } else if (balance >= 1000 && balance <= 4999.99) {
                            System.out.println("You are Regular customer ");
                        } else {
                            System.out.println("You are VIP customer ");
                        }
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM");
                        System.out.println("Your total amount of Deposites are : " + depositsMade + " Your total amount of Withdraws are : " + withdrawalsMade + ".");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                // for the requirement but it doesn't really affect the code
                // if(choice==5){
                //    break;}

            } while (choice != 5);

        }
        scanner.close();
    }


}