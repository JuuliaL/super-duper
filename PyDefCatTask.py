
class Cat:
    def __init__(self, name, age, eat):
        self.name = name
        self.age = age
        self.sound = 'Meow'  # assign a sound 
        self.eat = eat

    def voice(self):
        print(f'{self.sound}!')

    def eat(self, food):
        print(f'{self.name} is eating {self.food}')


# Create instances of Cat
cat1 = Cat('Coder', 2, 'Chicken')
cat2 = Cat('Minka', 4, 'Beef')
cat3 = Cat('Miisu', 5, 'Tuna')


# Overwrite the default sound of a cat
cat2.sound = 'Le Miaou'

# Create a list to hold all cat instances
cats = [cat1, cat2, cat3]

# Print cat names using a loop
for cat in cats:
    print(f'Name: {cat.name}. Age: {cat.age}. Sound: {cat.sound}. Fav food: {cat.eat}.')
