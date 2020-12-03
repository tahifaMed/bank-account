
# Specifications
## Bank account kata
Think of your personal bank account experience When in doubt, go for the simplest solution

## Requirements
- Deposit and Withdrawal
- Account statement (date, amount, balance)
- Statement printing
 
## User Stories

##### US 1
In order to save money  
As a bank client  
I want to make a deposit in my account  
 
##### US 2 
In order to retrieve some or all of my savings  
As a bank client  
I want to make a withdrawal from my account  
 
##### US 3 
In order to check my operations  
As a bank client  
I want to see the history (operation, date, amount, balance)  of my operations  

# Choice of implementation

to store all transactions made to an account, I create an immutable list of BankAccountEvent, the immutability is for the integrity of the data. the different type of 
events are hierarchical to verify open closed principles and keep it open for extension.

to run the solution, you need to run mvn clean install and mvn test