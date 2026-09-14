
# Functions
# Function has a piece of code, which can be called wherever necessary and gets executed. They makes the code
# modular.

def introduce(name, age):
    print(f"{name} is {age} years old")

# introduce("Sivakrishna", 23)
# introduce(age=23, name="Sivakrishna")

def greet(name="user"):
    print(f"Hello {name}")

# greet()
# greet(name="Sivakrishna")

# *args - accepts any n.o of positional arguments as tuple
def add_numbers(*args):
    return sum(args)

# print(add_numbers(1, 2, 3))
# print(add_numbers(1, 2, 3, 4, 5))

# **kwargs - accepts any n.o of keyword arguments as dictionary
def fun(**kwargs):
    print(kwargs)

# fun(name="sivakrishna", age=23)

# Multiple return values
def calc(a, b):
    return a * b, a + b, a - b

# print(calc(5, 10))

# Scope
# 1. Global scope - global scope variables are accessible throught the entire file, in all functions defined.
# 2. Local scope - local scope variables can only be accessed within the function. They can be accessed in the
# nested functions using nonlocal keyword.

# Lambda expressions
# These are one line functions
add = lambda a, b: a + b
# print(add(10, 20))

is_even = lambda num: num % 2 == 0
# print(is_even(242))

# DocStrings
# These are comments that explain what a function does and return.
def addition(num1, num2):
    """ Adds the numbers """
    return num1 + num2

# Type annotations
# These help in defining the type of variables
def sub(num1: int, num2: int) -> int:
    return num1 - num2

# print(sub(5, 9))
# print(sub(5, ""))
