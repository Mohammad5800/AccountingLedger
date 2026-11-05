package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FinancialTracker {

    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.csv";
    public static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("ss:mm:HH");

    public static void main(String[] args) {

        loadTransactions(FILE_NAME);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\nWelcome to TransactionApp");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {

                case "D":
                    addDeposit(scanner);
                    break;

                case "P":
                    addPayment(scanner);
                    break;

                case "L":
                    ledgerMenu(scanner);
                    break;

                case "X":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void loadTransactions(String fileName) {

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 5) {

                    Transaction transaction =
                            new Transaction(
                                    LocalDate.parse(parts[0]),
                                    LocalTime.parse(parts[1]),
                                    parts[2],
                                    parts[3],
                                    Double.parseDouble(parts[4]));

                    transactions.add(transaction);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading transactions.");
        }
    }

    private static void addDeposit(Scanner scanner) {

        System.out.print("Date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate userDate = LocalDate.parse(date, format);

        System.out.print("Time (HH:mm:ss): ");
        String time = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime usertime = LocalTime.parse(time, fmt);

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        double amount =
                Double.parseDouble(scanner.nextLine());

        Transaction transaction =
                new Transaction(userDate, usertime,
                        description, vendor, amount);

        transactions.add(transaction);

        saveTransaction(transaction);

        System.out.println("Deposit Added!");
    }

    private static void addPayment(Scanner scanner) {

        System.out.print("Date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate userDate = LocalDate.parse(date, format);

        System.out.print("Time (HH:mm:ss): ");
        String time = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime usertime = LocalTime.parse(time, fmt);

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        double amount =
                Double.parseDouble(scanner.nextLine());

        amount = -Math.abs(amount);

        Transaction transaction =
                new Transaction(userDate, usertime,
                        description, vendor, amount);

        transactions.add(transaction);

        saveTransaction(transaction);

        System.out.println("Payment Added!");
    }

    private static void saveTransaction(Transaction transaction) {

        try {

            FileWriter writer =
                    new FileWriter(FILE_NAME, true);

            writer.write(transaction.toString());
            writer.write("\n");

            writer.close();

        } catch (Exception e) {

            System.out.println("Error saving transaction.");
        }
    }

    private static void ledgerMenu(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\nLedger");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("H) Home");

            String choice =
                    scanner.nextLine().toUpperCase();

            switch (choice) {

                case "A":
                    displayLedger();
                    break;

                case "D":
                    displayDeposits();
                    break;

                case "P":
                    displayPayments();
                    break;

                case "R":
                    reportsMenu(scanner);
                    break;

                case "H":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void displayLedger() {

        for (int i = transactions.size() - 1; i >= 0; i--) {

            System.out.println(transactions.get(i));
        }
    }

    private static void displayDeposits() {

        for (int i = transactions.size() - 1; i >= 0; i--) {

            Transaction t = transactions.get(i);

            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    private static void displayPayments() {

        for (int i = transactions.size() - 1; i >= 0; i--) {

            Transaction t = transactions.get(i);

            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    public static void reportsMenu(Scanner scanner){
        boolean running = true;
        while (running){
            System.out.println("REPORTS");
            System.out.println("Search by by vendor? ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")){
                System.out.println();//Ask who then check to see if the person they said match whats stored in the transcation class

            }
            else {
                System.out.println("ok");
                return;
            }
        }
    }
}