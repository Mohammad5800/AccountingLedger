# financial Tracker

A Java console application that helps users track deposits and payments and view financial reports.

## Description of the Project

The Financial Tracker application allows users to record deposits and payment in a CSV file. Users can view all transaction, view only deposits, view only payment, and generate reports. The program stors ttransaction data permenently so it can be accessed later. This helps users keep track of their financial activity.

## Features

- Add deposits
- Make payment
- view all transactions
- view deposits only
- view payments only
- Generate reports

## User Stories

 - As a user, I want to record deposits so that I can track money coming into my account.
 - As a user, I want to record payment so that I can track money going out of my account.
 - As a user, I want to view my transactions so that I can see my financial history.
 - As a user, I want to run reports so that I can find transactions by date.

## Setup

### Prerequisites

 - java 17 - Intellij IDEA Community Edition

### Running the application

 1. Download or clone the repository.
 2. Open the project in Intellij IDEA.
 3 Open FinancialTracker.java.
 4. Run FinancialTracker.main().

### Date and Configuration

  - transactions.csv stores all transaction data.
  - The file is located in the project folder. ### Technologies Used
  - java 17 - Intellij IDEA - CSV Files

## Demo

![Main Meni] (images/menu.png)

## A place of code I am proud of

' ' ' java
If (choice.equalsIgnoreCase("D")) {
    addDeposit();
}
else if ( choice.equalsIgnoreCase("P)) {
    makePayment();
}
else if ( choice.equalsIgnoreCase("L")) {
    displayLedger();
}
' ' '
This code directs the user to the correct feature selected from the application menu.

## Future work

- Add categories for transactions
- Add editing and deleting transactions

## Resources
- https : //github.com/Mohammad5800/AccountingLedger

## Author
- Mohammad Tayeb
- GitHub: https : // github.com/Mohammad500/AccountingLedger

## Thanks

- Thank you to my instructors and classmates for their support.
