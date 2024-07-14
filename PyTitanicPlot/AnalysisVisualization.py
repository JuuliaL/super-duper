'''
Exploratory Data Analysis (EDA):

1. Load the Titanic dataset into a Pandas DataFrame.
2. Use Pandas methods to explore and understand the dataset:
  2.1 Display the first few rows to get an overview of the data structure.
  2.2 Check the dimensions of the dataset (number of rows and columns).
  2.3 Identify missing values and decide on strategies for handling them.
  2.4 Compute basic statistics (e.g., mean, median, min, max) for numerical columns.
  2.5 Analyze categorical variables (e.g., value counts).
'''
import pandas as pd
from matplotlib import pyplot as plt
import numpy as np


df = pd.read_csv('/content/train.csv')
df.head() # 2.1
df.info() # 2.2 alternative df.shape

df.isna()        # 2.3 checking for missing values
df.isna().sum()  # 2.3 sums up empty values
df.notna().sum() # 2.3 sums up non-empty values
df.notna().all() # 2.3 checks if all values are non-empty (True/False)

df.describe()   # 2.4
df.describe().T # 2.4 transpose - flip for better readability

df['Age'].value_counts(dropna=False).reset_index()      # 2.4
df['Embarked'].value_counts(dropna=False).reset_index() # 2.4
df['Sex'].value_counts().reset_index()                  # 2.4
df['Pclass'].value_counts().reset_index()               # 2.4
df['Survived'].value_counts().reset_index()             # 2.4

'''
Data Visualization:

Choose one column of the dataset that interests you
Use Matplotlib pyplot to create a meaningful visualization:
Select an appropriate plot type (e.g., bar chart, histogram, pie chart).
Label axes, add a title.
Ensure the visualization is clear, informative, and visually appealing.
'''
# Fill NaN values with a placeholder -10, as all ages are positive
df['AgeFilled'] = df['Age'].fillna(-10)

# Define bins
bins = [-10, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90]

# Separate the dataset by gender
male_ages = df[df['Sex'] == 'male']['AgeFilled']
female_ages = df[df['Sex'] == 'female']['AgeFilled']

# Calculate the counts for each gender in each bin
male_counts, _ = np.histogram(male_ages, bins=bins)
female_counts, _ = np.histogram(female_ages, bins=bins)

# Calculate bin centers for accurate positioning
bin_centers = np.diff(bins) / 2 + bins[:-1] 

# Plot male counts
plt.bar(bin_centers, male_counts, width=10, color='skyblue', label='Male', edgecolor='blue')

# Plot female counts, using the male counts as the bottom starting point
plt.bar(bin_centers, female_counts, width=10, bottom=male_counts, color='pink', label='Female', edgecolor='purple')

plt.title('Count of passengers by age (including NaN as < 0)')
plt.xlabel('Age group')
plt.ylabel('Count')
plt.gca().set_facecolor('beige')
plt.xticks(bins)

# Add male count inside each bin
for i, rect in enumerate(bars_male):
    height = rect.get_height()
    plt.text(rect.get_x() + rect.get_width() / 2.0, height / 2, str(male_counts[i]), ha='center', va='bottom', color='blue')

# Add female count inside each bin on top of the male counts
for i, rect in enumerate(bars_female):
    height = rect.get_height() + bars_male[i].get_height()  # Total height of male+female bars
    if female_counts[i] > 0:  # Only display if count is non-zero
        plt.text(rect.get_x() + rect.get_width() / 2.0, height - (height - bars_male[i].get_height()) / 2, str(female_counts[i]), ha='center', va='bottom', color='purple')

# Legend and text to explain the <0 bin represents NaN values
plt.text(-5, 5, 'NaN', ha='center', va='bottom')
plt.legend()

plt.show()
