'''Bank Deposit Challenge!
**Description:**
Create a program where the user can input deposits into a bank account. The program should use `if-else` statements, `input()`, `int()` and while True loop to keep track of deposits.
**Instructions:**
1. Welcome the user to the bank
2. Initiate balance = 0
3. Ask the user to input the amount of money they want to deposit.
4. Add the deposit amount to the total balance
5. Ask the user if they want to make another deposit or exit the bank. 
6. If they choose to make another deposit, repeat the process (while True).
7. If not, print the total amount deposited and exit the bank.
### Medium Level
**Instructions:**
1. Use `try` and `except` to handle non-integer inputs for deposits.
### Hard Level
**Instructions:**
1. Add bank withdrawal (if user wants to withdraw money the balance decreases)
2. If the balance becomes negative, withdrawal is not possible.
3. Add check balance optionality
Example for hard level:
   print("\nWhat would you like to do?")
   print("1. Deposit money")
   print("2. Withdraw money")
   print("3. Check balance")
   print("4. Exit")'''

# E.1. Welcome the user to the bank
print("\nWelcome to the bank!")
# E.2. Initiate balance = 0
balance = 0

def bank_prompt():
    print("\nWhat would you like to do?")
    print("\n1. Deposit money")
    print("2. Withdraw money")
    print("3. Check balance")
    print("4. Exit")


def bank_actions():
    global balance 
    bank_prompt()

    choice = input("Enter your choice: ")
    if choice == '1':
        # E.3. Ask the user to input the amount of money they want to deposit.
        deposit = input("Enter the amount you want to deposit: ")
        try: # M.1. Use `try` and `except` to handle non-integer inputs for deposits.
            deposit = int(deposit)
        except:
            print("Please enter a valid number")
            return # E.5. Ask the user if they want to make another deposit or exit the bank.
        # E.4. Add the deposit amount to the total balance
        balance += deposit
        # E.7.1 If not, print the total amount deposited...
        print(f"Your total balance is {balance}")
    elif choice == '2':
        # H.1. Add bank withdrawal (if user wants to withdraw money the balance decreases)
        withdraw = input("Enter the amount you want to withdraw: ")
        try:
            withdraw = int(withdraw)
        except:
            print("Please enter a valid number")
            return
        # H.2. If the balance becomes negative, withdrawal is not possible.
        if balance - withdraw < 0:
            print("Not enough balance")
            return
        balance -= withdraw
        # H.3. Add check balance optionality
        print(f"Your total balance is {balance}")
    elif choice == '3':
        print(f"Your total balance is {balance}")
    elif choice == '4':
        print(f"Your total balance is {balance}")
        print("Thank you for banking with us!")
        # E.7.2 ...exit the bank.
        return 'exit'
    else:
        print("Invalid choice")


while True:
    result = bank_actions() # E.6. If they choose to make another deposit, repeat the process (while True).
    if result == 'exit':
        break
