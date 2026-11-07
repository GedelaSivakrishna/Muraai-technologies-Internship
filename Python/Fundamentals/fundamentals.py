# Printing to console
# print("Learning python fundamentals")
# For Multi line comments, there is no /* ... */ like in java, we need to put # in front of each line

# Variables in python
name = "Gedela Sivakrishna"
roll = 242
age = 23
gender = "Male"
isWorking = True
# print(name, roll, age, gender, isWorking)

# Printing variable types
# print(name, type(name))
# print(age, type(age))
# print(isWorking, type(isWorking))

# Constants - there is no keyword to define constants, they can be changed.
# General convention to use uppercase to define a constant.
PI = 3.14

# Datatypes
# 1. int
salary = 30000

# 2. float
cgpa = 8.7

# 3. str
college = "Centurion university of technology and management"

# 4. bool
isAdult = True
isMarried = False

# 5. None - represents this variable doesn't hold any value
someVariable = None

# 6. list
skills = ["Java", "JavaScript", "HTML", "CSS", "React", "Spring"]
# add another skill
skills.append("Angular")
# print(skills)

# 7. tuple (immutable)
marks = (81, 95, 93)
# print(marks)

# 8. set
vals = {1, 2, 3, 4, 3}
# print(vals)

# 9. range(start, stop, step)
# start - inclusive, stop - exclusive
# Default start = 0, step = increment by 1
nums = range(10)
# for i in nums:
#     print(i)

# for i in range(5, 10):
#     print(i)

# for i in range(1, 10, 2): # start at 1 and increment by 2
#     print(i)

# for i in range(10, 0, -2): # backward loop
#     print(i)

# 10. dict
student = {
    name : "Gedela Sivakrishna",
    roll : 242,
    age : 23,
    "phone" : 9692849788
}
studentCopy = dict(name="Gedela")
# print(student)
# print(studentCopy)
# print(studentCopy["name"])

# Conditional statements
age = 23
# if age >= 18:
#     print("You are adult")
# elif age >= 15:
#     print("you are teenager")
# else:
#     print("you are kid")

# ternary operator
isAdult = True if age >= 18 else False
# print(isAdult)

# nested if
num = 24
# if num % 2 == 0:
#     if num % 3 == 0:
#         print(num, "is divisible by 6")

# match case
day = 27
# match day:
#     case 1:
#         print("Monday")
#     case 2:
#         print("Tuesday")
#     case 3:
#         print("Wednesday")
#     case 4:
#         print("Thursday")
#     case 5:
#         print("Friday")
#     case 6:
#         print("Saturday")
#     case 7:
#         print("Sunday")
#     case _:
#         print("Invalid value")

# Loops
# for, while
# Note - python do not have do while loop
# for i in range(10):
#     print(i)

val = 1
# while val <= 10:
#     print(val)
#     val += 1

# Functions
def greet():
    print("Hello")

# greet()

def add(num1, num2):
    return num1 + num2

# print(add(242, 242))

