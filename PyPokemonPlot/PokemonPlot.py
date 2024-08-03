# How many Pokémons are with 'Type 1' == Water as a % of total?

water_pokemons = pokemon_df[pokemon_df['Type 1'] == 'Water'] 
total_pokemons = len(pokemon_df)
water_pokemons_percent = (len(water_pokemons) / total_pokemons) * 100
print(f"The percentage of water pokemons is: {water_pokemons_percent:.2f}%")
# water_pokemon_percentage = (pokemon_df['Type 1'] == 'Water').mean() * 100
# print(f"Percentage of Water-type Pokémon: {water_pokemon_percentage:.1f}%")

# What is the maximum 'Speed' value? 

max_speed = pokemon_df['Speed'].max()
print(f"The maximum speed is: {max_speed}")

# What is the minimum 'Speed' value? 

min_speed = pokemon_df['Speed'].min()
print(f"The minimum speed is: {min_speed}")

# What is the difference between max and min 'Speed'?

speed_difference = max_speed - min_speed
print(f"The difference between max and min speed is: {speed_difference}")

# Filter the DataFrame to include only the Pokémon with 'Speed' >= 80. How many Pokémon meet this criterion?

high_speed_pokemons = pokemon_df[pokemon_df['Speed'] >= 80]
print(f"The number of Pokémon with speed >= 80 is: {len(high_speed_pokemons)}")

# Visualize the filtered Pokémon with Speed >= 80, sorted by Type1

grouped_pokemons = high_speed_pokemons.groupby('Type 1').size() # Group the filtered DataFrame by 'Type 1' and count the number of Pokémon in each group
sorted_pokemons = grouped_pokemons.sort_values() # Sort the grouped DataFrame by 'Type 1'

colors = ['violet', 'lightskyblue', 'slategrey', 'sandybrown', 'mediumvioletred', 'turquoise', 'firebrick', 'peru', 'darkorchid', 'dimgrey', 'yellowgreen', 'seagreen', 'royalblue', 'darkorange', 'yellow', 'lightcoral', 'dodgerblue', 'silver']

# Bar plot for visualization
plt.figure(figsize=(10, 6))
bars = plt.bar(sorted_pokemons.index, sorted_pokemons.values, color=colors, edgecolor='black', alpha=0.5)
plt.title('Number of Pokémon with Speed >= 80, Sorted by Type 1')
plt.xlabel('Type 1')
plt.ylabel('Number of Pokémon')
plt.xticks(rotation=90)
plt.gca().set_facecolor('lightcyan') #background

# Add count to each bar
for bar in bars:
    count = bar.get_height()
    plt.text(bar.get_x() + bar.get_width()/2, count + 0.5, count, ha='center', va='bottom')

plt.show()


# Find Pokémon with the longest name (excluding spaces)? What is this pokemons name?

pokemon_df['Length of Names'] = pokemon_df['Name'].str.replace(" ", "").str.len() # new column = removes spaces+len
longest_name = pokemon_df['Name'].iloc[pokemon_df['Length of Names'].idxmax()] # idxmax() for max index in 'Length of Names' column, iloc[] to get the name of Pokemon from this index

print(f"The Pokémon with the longest name is {longest_name}, it has {pokemon_df['Length of Names'].max()} chars")
