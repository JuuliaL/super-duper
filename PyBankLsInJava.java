PY CODE:

```
import datetime; # for automatic timestamp

class Client:
  number_of_clients = 0
  pass

  def __init__(self, id, name): # constructor runs every time,  must be provided (values)
    self.id = id
    self.name = name
    self.accounts = []    # add empty account list
    Client.number_of_clients += 1

  def add_account(self, account):  # custom method dont run automatically
    self.accounts.append(account)  # add account to the empty accounts list


# defining a class Account, which will store all data and methods of any account

class Account:                       # if value not provided will put 0.0 
  def __init__(self, number, currency, balance = 0.0): #create here and store in Client class
    self.number = number
    self.currency = currency
    self.balance = balance
    self.transactions = []  # empty list for an account transactions


  def make_deposit(self, amount, note):  # belong to every account
    self.transactions.append(Transaction(self.currency, amount, note)) # self means Account self
    self.balance += amount

  def make_withdrawal(self, amount, note):
    self.transactions.append(Transaction(self.currency, -amount, note))
    self.balance -= amount
    

class Transaction:
  def __init__(self, currency, amount, note):  
    self.currency = currency
    self.amount = amount
    self.note = note
    self.time_stamp = datetime.datetime.now() # automatic datetime



clients = []
clients.append(Client('232332', 'Anna'))
clients.append(Client('3432435', 'Oskar'))
clients.append(Client('3434343', 'Jennifer'))


clients[0].add_account(Account('EE3433242222','EUR', 1000.00)) 
clients[0].add_account(Account('EE4343435555','JPY', 25000)) 
clients[0].add_account(Account('EE4343477775','USD')) 
clients[1].add_account(Account('PL3400000002','PLN', 47800))
clients[2].add_account(Account('SE3411111111','SEK', 200.23))


# make transactions

clients[0].accounts[0].make_deposit(1200, 'Salary')
clients[0].accounts[0].make_withdrawal(50, 'Grocery')
clients[0].accounts[0].make_withdrawal(140, 'Clothes')
clients[0].accounts[0].make_withdrawal(20, 'Dinner')

print(clients[1].id) # id of Oskar
#print(clients[0].name)
#print(clients[1].name)
#print(clients[2].name)

for client in clients:   # all elements together accesible w loops
  print(client.name)
print(" ")


print(f'We have {Client.number_of_clients} clients in our bank: ')

for client in clients:
    print(f'\n{client.name} (id: {client.id}) has the following accounts:')
    for account in client.accounts:
        print(f'  Account number: {account.number}, Currency: {account.currency}, Account balance: {account.balance}')
        for transaction in account.transactions:
          print(f'      {transaction.time_stamp}   {transaction.currency} {transaction.amount} ')
```


SAME CODE IN JAVA

```
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("232332", "Anna"));
        clients.add(new Client("3432435", "Oskar"));
        clients.add(new Client("3434343", "Jennifer"));

        clients.get(0).addAccount(new Account("EE3433242222","EUR", 1000.00));
        clients.get(0).addAccount(new Account("EE4343435555","JPY", 25000));
        clients.get(0).addAccount(new Account("EE4343477775","USD", 0.0));
        clients.get(1).addAccount(new Account("PL3400000002","PLN", 47800));
        clients.get(2).addAccount(new Account("SE3411111111","SEK", 200.23));

        clients.get(0).getAccounts().get(0).makeDeposit(1200, "Salary");
        clients.get(0).getAccounts().get(0).makeWithdrawal(50, "Grocery");
        clients.get(0).getAccounts().get(0).makeWithdrawal(140, "Clothes");
        clients.get(0).getAccounts().get(0).makeWithdrawal(20, "Dinner");



        System.out.println("We have " + Client.getNumberOfClients() + " clients in our bank.");

        for (Client client : clients) {
            System.out.println("\n" + client.getName() + " (id: " + client.getId() + ") has the following accounts:");
            for (Account account : client.getAccounts()) {
                System.out.println("  Account number: " + account.getNumber() + ", Currency: " + account.getCurrency() + ", Account balance: " + account.getBalance());
                for (Transaction transaction : account.getTransactions()) {
                    System.out.println("      " + transaction.getTimeStamp() + "   " + transaction.getCurrency() + " " + transaction.getAmount());
                }
            }
        }
    }
}
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int numberOfClients = 0;
    private String id;
    private String name;
    private List<Account> accounts;

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
        numberOfClients++;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public static int getNumberOfClients() {
        return numberOfClients;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String number;
    private String currency;
    private double balance;
    private List<Transaction> transactions;

    public Account(String number, String currency, double balance) {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void makeDeposit(double amount, String note) {
        this.transactions.add(new Transaction(this.currency, amount, note));
        this.balance += amount;
    }

    public void makeWithdrawal(double amount, String note) {
        this.transactions.add(new Transaction(this.currency, -amount, note));
        this.balance -= amount;
    }

    public String getNumber() {
        return number;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
import java.time.LocalDateTime;

public class Transaction {
    private String currency;
    private double amount;
    private String note;
    private LocalDateTime timeStamp;

    public Transaction(String currency, double amount, String note) {
        this.currency = currency;
        this.amount = amount;
        this.note = note;
        this.timeStamp = LocalDateTime.now();
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}



