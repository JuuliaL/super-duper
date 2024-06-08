'''
Import data to a dictionary
Calculate, looping through every student data:
a) Average Age of all students
b) average Grade of all students
c) (optional) calculate average Grade by Major
'''
import json

with open("students.json") as json_file:
  data = json.load(json_file)

'''
# IMPORT FROM PY TO JSON
# Define student_details dictionary
student_details ={ 
    "name" : "sathiyajith", 
    "rollno" : 56, 
    "cgpa" : 8.6, 
    "phonenumber" : "9976770500"
} 
   
# Convert and write JSON object to file
with open("sample.json", "w") as outfile: 
    json.dump(student_details, outfile)
'''

age = 0
grade = 0
counter = 0

for student in data["Students"]:
  age += int(student["Age"])
  grade += int(student["Grade"])
  counter += 1 

average_age = age / counter
print(f"Average age of all students {average_age}")

average_grade = grade / counter
print(f"Average grade of all students {round(average_grade, 2)}")

grade_by_major = {} #dictionary to get grades and majors
average_grades_by_major = 0
counter2 = 0

for student in data ["Students"]:
  major = student["Major"]
  grade = int(student["Grade"])
  
   #checking if major is in grade_by_major
  if major not in grade_by_major: 
    grade_by_major[major] = {'total_grade': 0, 'count': 0} 

   #upgrading the dictionary
  grade_by_major[major]['total_grade'] += grade
  grade_by_major[major]['count'] += 1

for major, values in grade_by_major.items():
  average_grades_by_major = round(values['total_grade']/values['count'], 2)
  print(f'The average grade for {major} is {average_grades_by_major}.')
