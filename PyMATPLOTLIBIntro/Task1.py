import pandas as pd
import matplotlib.pyplot as plt


dataset = pd.read_csv('/content/transaction_dataset.csv')
#dataset.info()
# Task 1: Create a bar chart that shows the count of customers for each unique value in the 'Gender' column (including NaN values). - easy
data5 = dataset['Gender'].value_counts(dropna=False).reset_index() # too see NAN values, reset index put data into table(pd dataframe)
data5.columns = ['Gender', 'Count']
print(data5)
colors = ['yellow', 'skyblue', 'pink']
# plt.bar(data5['Gender'].astype(str), data5['Count'].astype(str), color=colors) #color selection
# Reverse the DataFrame rows
data5_reversed = data5[::-1]
plt.bar(data5_reversed['Gender'].astype(str), data5_reversed['Count'].astype(str), color=colors)

plt.xlabel('Gender')
plt.ylabel('Count')
plt.title('Gender of customers')

plt.grid(True)
plt.show()
