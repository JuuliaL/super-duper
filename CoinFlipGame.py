import random

correct_guesses = []
total_guesses = []

while True:
    random_number = random.randint(0, 1)
    user_guess = input('Guess the outcome of the coin toss. Enter "heads" or "tails", or to end the game, write "quit": ')
    print(random_number)
  
    if user_guess in ('quit', 'tails', 'heads'):
        if user_guess == 'quit':
            print(f'Game over. Total guesses: {len(total_guesses)}. Correct guesses: {len(correct_guesses)}.')
            break

        if random_number == 0:
            print('Coin result: Heads')
            if user_guess == 'heads':
                print("Correct!")
                correct_guesses.append(user_guess)
                total_guesses.append(user_guess)
            else:
                print('Incorrect. Try again.')
                total_guesses.append(user_guess)
        elif random_number == 1:
            print('Coin result: Tails')
            if user_guess == 'tails':
                print('Correct!')
                correct_guesses.append(user_guess)
                total_guesses.append(user_guess)
            else:
                print('Incorrect. Try again.')
                total_guesses.append(user_guess)
    else:
        print('Invalid input. Please enter "heads", "tails", or "quit".')
