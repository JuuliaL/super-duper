import pandas as pd
import matplotlib.pyplot as plt

dataset = pd.read_csv('/content/transaction_dataset.csv')
#dataset.info()
'''
Task 2: Create a horizontal bar chart that shows the top 5 most frequent names in the DataFrame, based on the 'name' column. 
(First, create a grouped DataFrame (name_df), then filter it using iloc, and finally create the visualization.) -medium
 '''
data6 = dataset['Name'].value_counts(dropna=False).reset_index() # too see NAN values, reset index put data into table(pd dataframe)
data6.columns = ['Name', 'Count']
data6_top5 = data6.iloc[:5]
print(data6_top5)
plt.barh(data6_top5['Name'], data6_top5['Count'], color='cyan', edgecolor='navy')
plt.xlabel('Count')
plt.ylabel('Name')
plt.title('Top 5 most frequent names')
plt.gca().set_facecolor('beige') # Background color
plt.gca().invert_yaxis() # Invert y-axis to have the highest count at the top

plt.grid(True)
plt.show()
