# class - class is a blue print which has the properties and behaviour
# object - object is the instance of the class which has the data and behaviour defined in class

# __init__ - this method in python is similar to java 'constructor' to initialize an object
# self - this property is similar to java 'this' keyword to reference current object

# Encapsulation - Encapsulation is grouping related data and methods together
class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def print(self):
        print(self.name, self.age)

student1 = Student('Gedela Sivakrishna', 23)
# student1.print()

# Abstraction - Abstraction means hiding the implementation details and showing only functionality.

from abc import ABC, abstractmethod

class Payment(ABC):

    @abstractmethod
    def pay(self):
        pass

class UPIPayment(Payment):

    def pay(self, amount):
        print(f"Paid {amount} using UPI")

payment = UPIPayment()
# payment.pay(1000)

# Inheritance - Inheritance allows one class to extend and reuse the properties and methods of another class

class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

    def display(self):
        print(self.name, self.salary)
    
class Developer(Employee):
    def work(self):
        print("Writes code")

developer = Developer('Gedela Sivakrishna', 30000)
# developer.display()

# Polymorphism - Polymorphism means the same function can have different behaviour depending on the object.

class Cat:
    def speak(self):
        print("Meow")

class Duck:
    def speak(self):
        print("Quack")

def make_sound(animal):
    animal.speak()

cat = Cat()
duck = Duck()

# make_sound(cat)
# make_sound(duck)