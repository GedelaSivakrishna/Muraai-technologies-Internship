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
unsortedArray = np.array([5, 9, 1, -2, 4, 10])
# 1. sorts the array
sortedArray = np.sort(unsortedArray)
# print(sortedArray)

# 2. concatenates the array
arr1 = np.array([20, 10])
arr2 = np.array([30, 50])
mergedArray = np.concatenate((arr1, arr2))
# print(mergedArray)

# Reshape an array
reshapedArray = a.reshape(5, 1)
# print(a)
# print(reshapedArray)

# convert 1D array to 2D array
# array.shape property returns the size in each dimension
# print(a.shape) # (6, ) 
a2 = a[np.newaxis, :] # adds one dimension at first and makes the array -> row vector
a3 = a[:, np.newaxis] # adds one dimension at second position and makes the array -> column vector
# print(a2)
# print(a3)
# print(a2.shape)

# 1. Vector - a list of values
# 2. Row vector - array in the shape (1 * n) is said to be row vector. The array should
#    have only 1 row to qualify as row vector.
# 3. Column vector - array in the shape (n * 1) is said to be column vector. The array should
#    have only 1 column to qualify as column vector.

# np.expand_dims: Expand the dimension of the array
b1 = np.expand_dims(a, axis=0)
# print(b1)
b2 = np.expand_dims(a, axis=1)
# print(b2)
# b3 = np.expand_dims(a, axis=2)
# print(a.ndim)

# Indexing and Slicing
# print(a)
# print(a[2])
# print(a[2:])
# print(a[-3:]) # negative indexes start from end of array -1, -2, -3, ...

# conditionally retreving the array values
# print(a[a % 2 == 0]) # values divisible by 2
# print(a[a < 3])
# print(a[(a >= 2) & (a <= 4)])
# print(a[(a % 2 == 0) | (a % 3 == 0)])
# print(a % 2 == 0) # returns boolean array, True & False values based on condition
# print(np.nonzero(a % 2 == 0)) # returns the indices of the elements that satisfy the condition
c = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
greaterThan5 = np.nonzero(c > 5)
# print(greaterThan5)
list_of_coordinates = list(zip(greaterThan5[0], greaterThan5[1])) # joins the pair elements
# for coordinate in list_of_coordinates:
#     print(coordinate)
# print(c[greaterThan5]) # prints the elements present at indexes stored in greaterThan5
not_there = np.nonzero(c == 242) # returns arrays with empty row & col indexes
# print(not_there)

# Creating an array from existing data
arr = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
slicedArray = arr[1:5] # creates an array from original with slice
slicedArray[0] = 200 #  changes are reflected in original array
# print(arr)
# print(slicedArray) 
# vstack - vertically stacks the arrays
a1 = np.array([[1,1],
               [2,2]])
a2 = np.array([[3,3],
               [4,4]])
verticallyStackedArray = np.vstack((a1, a2))
# print(verticallyStackedArray)
# hstack - horizantally stacks the arrays
horizantallyStackedArray = np.hstack((a1, a2))
# print(horizantallyStackedArray)
# hsplit - splits the array horizantally
x = np.arange(1, 25).reshape(2, 12)
# print(x)
# print(np.hsplit(x, 3))
# print(np.hsplit(x, (3, 4, 6)))

# Views & Copy
# Views - shallow copies of original arrays, numpy returns views on many operations like slice
#         but any changes made in view will reflect in original
# Copy - deep copy of original array
c = a[1:]
c[0] = 200
# print(a)
d = a.copy()
d[0] = 500
# print(a)

# Basic array operations
# addition, substraction, multiplication, division
a1 = np.arange(1, 5)
a2 = np.ones(4, dtype=int)
# print(a1)
# print(a2)
# print(a1 + a2)
# print(a1 - a2)
# print(a1 * a2)
# print(a1 / a2)
# print(a1.sum())
# We can perform these basic operations on 2D, 3D, ... as well
b = np.array([[1, 1], [2, 2]])
# print(b.sum(axis=0)) # [3, 3]
# print(b.sum(axis=1)) # [2, 4]

# scalar - has 0 dimensions - it's a single value
# vector - it's a list of values
# Broadcasting - performing operations on arrays of different shapes
# Rules : 
    # 1. both arrays have same shape (dimensions are checked from right side)
    # 2. one value is scalar
# print(a + 10)

# More useful array operations
# min, max, sum, prod, mean, std
# print(a.min())
# print(a.max())
# print(a.sum())
# print(a.mean())

b = np.array([[0.45053314, 0.17296777, 0.34376245, 0.5510652],
              [0.54627315, 0.05093587, 0.40067661, 0.55645993],
              [0.12697628, 0.82485143, 0.26590556, 0.56917101]])
# print(b.sum()) # by default operates on all axis
# print(b.sum(axis=0)) # we can specify along which axis we want the operation to be performed

