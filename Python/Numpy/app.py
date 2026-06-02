import numpy as np
import math

a = np.array([1, 2, 3, 4, 5])
# print(a)

# Accessing elements of array
# print(a[0])

# Mutating the array
# a[0] = 242
# print(a)

# Slicing operation
# print(a[1:])
# print(a[:3])
marks = [81, 93, 95, 99]
slicedAray = a[1:] # Slicing an array returns a view, changes in sliced array reflects in original array
slicedList = marks[1:] # slicing a list returns a new copied values, changes doesn't reflect in original list
# slicedAray[0] = 10
slicedList[0] = 10
# print(a) # 1 10 2 3 4 5
# print(marks) # 81 93 95 99

# Creating an array with lists
list1 = [[1, 2, 3]]
list2 = [[4, 5, 6]]
arrayFromList = np.array([list1, list2])
# print(arrayFromList)

# accessing elements in multidimenstional array
# print(arrayFromList[1, 2]) # 1st row, 2nd element = 6

# Array attributes
# 1. ndim - this property returns whether the array is 1D, 2D, 3D .... ND
# print(a)
# print(a.ndim)
# print(arrayFromList.ndim)

# 2. shape - represents how many elements in each layer
# [
#     [
#         [1, 2, 3]
#     ],
#     [
#         [4, 5, 6]
#     ]
# ]
# the shape of above example = 2 * 1 * 3
# In first layer - 2 elements, in inner element of 1st layer - 1 element, inner layer of 2nd layer - 3 elements
# print(arrayFromList)
# print(arrayFromList.shape) # 2 * 1 * 3
# print(len(arrayFromList.shape)) # 3 - this returns what dimension this array is 1D, 2D, ....
# print(a.shape) # 1 * 5

# 3. size - returns the count of total elements in the array
# print(a.size) # 5
# print(arrayFromList.size) # 6
# print(math.prod(a.shape)) # 1 * 5 = 5
# print(math.prod(arrayFromList.shape)) # 2 * 1 * 3 = 6

# 4. dtype - returns the datatype of array
# print(a.dtype) # int
# print(arrayFromList.dtype) # int

# Creating Basic Array
# 1. Creates array filled with zeros
zerosArray = np.zeros(10)
# print(zerosArray)

# 2. Creates array filled with ones
onesArray = np.ones(10)
# print(onesArray)

# 3. Creates empty array with random values - this operation is faster than zeros
emptyArray = np.empty(10)
# print(emptyArray)

# 4. Creates array within a range of values
rangeArray = np.arange(10)
# print(rangeArray)
rangeArrayWithStepSize = np.arange(1, 10, 2)
# print(rangeArrayWithStepSize)

# 5. Creates an array with specified values with equal gap b/w the start & stop
equalSpacedArray = np.linspace(1, 10, 5)
# print(equalSpacedArray)

# 6. Creates array with specific datatype
# Note- float is the default datatype
intEmptyArray = np.empty(10, dtype = np.int64) # fills random values
# print(intEmptyArray)

# Adding, removing and sorting elements
# ... continue