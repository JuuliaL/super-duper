'''Develop a simple prototype for an online shop
1. Define classes Client, Items, Transaction
2. Write the logic so that each client can purchase one of several items in a single transaction
3. Make a printout of data with nested loops
4. The program should print out:
- all clients
- all transactions of a client
- all items purchased in each transaction of the client'''


import datetime;

class Item:
    def __init__(self, item_id, name, price):
        self.item_id = item_id
        self.name = name
        self.price = price

class Transaction:
    def __init__(self, transaction_id, client, items):
        self.transaction_id = transaction_id
        self.client = client
        self.items = items
        self.time_stamp = datetime.datetime.now()

class Client:
    def __init__(self, client_id, name):
        self.client_id = client_id
        self.name = name
        self.transactions = []

    def add_transaction(self, transaction):
        self.transactions.append(transaction)




items = []
items.append(Item(1, "Unlimited Amount of Happiness", 20.0))
items.append(Item(2, "Bright Future", 40.0))
items.append(Item(3, "Only Right Life Decisions", 30.0))
items.append(Item(4, "Peace of Mind", 25.0))
items.append(Item(5, "Joyful Memories", 15.0))


clients = []
clients.append(Client(101, "Alice"))
clients.append(Client(102, "Bill"))


# Associate transactions with clients
clients[0].add_transaction(Transaction(1001, clients[0], [items[1]]))
clients[1].add_transaction(Transaction(1002, clients[1], [items[3]]))
clients[1].add_transaction(Transaction(1003, clients[1], [items[4]]))
clients[0].add_transaction(Transaction(1004, clients[0], [items[2]]))


print("All clients:")
for client in clients:
    print(f"Client ID: {client.client_id}, Name: {client.name}")


print("\nAll transactions of a client:")
for client in clients:
    print(f"\nClient: {client.name}")
    for transaction in client.transactions:
        print(f"  \nTransaction ID: {transaction.transaction_id}")

        
        print("  Items purchased:")
        for item in transaction.items:
            print(f"    {transaction.time_stamp}\n    Item ID: {item.item_id}, Name: {item.name}, Price: €{item.price:.2f}")
