# Errors
# Error is a mistake in the code that stops the execution of the program.

# Syntax Errors
# These errors occur when we do not follow python's syntax correctly. These errors are caught when the 
# application is started. 

# Logical Errors
# These errors occur when we do not handle all cases correctly. These are also known as exceptions.
# These occur during the application is running, if they are not handled properly, they will stop the execution
# of the program.
# Exp - Trying to transfer amount greater than balance amount in account. This might stop the program
# execution or behave unexpectedly, if not handled.

# Common Exceptions
# 1. ZeroDivisionError - occurs when trying to divide a number with 0.
# 2. ValueError        - occurs when we pass incorrect type value to a function.
# 3. NameError         - occurs when we try to access a identifier which is not defined.
# 4. IndexError        - occurs when try to access an index which doesn't exist.
# 5. KeyError          - occurs when trying to access a key not present in a dictionary.
# 6. TypeError         - occurs when trying to apply an operation on an invalid datatype.

# Traceback
# Traceback shows us where the error occured exactly. All the function calls involved and we should always
# have to read it from the bottom line. The bottom line shows the exact name of the error occured.

# Exp - 
# try:
#     num = int(input("Enter a number: "))
#     result = 10 / num
# except ZeroDivisionError:
#     print("Number cannot be divided by zero")
# except ValueError:
#     print("Invalid integer value entered")
# except Exception:
#     print("Error is caught in this block, if none of above exceptions are matched.")
# else:
#     print("Operation executed successfully")
# finally:
#     print("This statement prints whether exception occurs or not")

# Raising an exception
# We can raise an exceptions when handling certain cases, which can be caught and handle accordingly. The code 
# below raise inside a function will not be executed, if exception is raised.
# Exp- raise ValueError("Insufficient amount")

# Custom Exceptions
# We can name exceptions according to the application and use wherever required. Clear naming makes it
# easy to understand
# Exp- Creating a custom exception
# class AuthenticationError(Exception):
#    pass
#
# Raising a custom exception
# raise AuthenticationError("Invalid password")

# Exception chaining
# An exception occurs because of another exception.

# def convert_to_int(value):
#     try:
#         return int(value)
#     except Exception as e:
#         raise ValueError("Invalid value") from e
    
# convert_to_int("abc")


