import pandas as pd
import matplotlib.pyplot as plt

dataset = pd.read_csv('/content/transaction_dataset.csv')
#dataset.info()
'''
Task 3: Create a filtered DataFrame that includes Category == 'Clothing' and Gender == 'M'.
How many rows are there in this filtered DataFrame?
Format the result as follows: The filtered DataFrame has XXXX rows. - hard
'''
data7 = dataset[(dataset['Category'] == 'Clothing') & (dataset['Gender'] == 'M')]
print(f'The filtered DataFrame has {len(data7)} rows.')
