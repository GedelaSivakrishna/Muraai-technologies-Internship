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
# 1. data.ndim - this property returns whether the array is 1D, 2D, 3D .... ND
# print(a)
# print(a.ndim)
# print(arrayFromList.ndim)

# 2. data.shape - represents how many elements in each layer
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

# 3. data.size - returns the count of total elements in the array
# print(a.size) # 5
# print(arrayFromList.size) # 6
# print(math.prod(a.shape)) # 1 * 5 = 5
# print(math.prod(arrayFromList.shape)) # 2 * 1 * 3 = 6

# 4. data.dtype - returns the datatype of array
# print(a.dtype) # int
# print(arrayFromList.dtype) # int

# Creating Basic Array
# 1. np.zeros() - Creates array filled with zeros
zerosArray = np.zeros(10)
# print(zerosArray)

# 2. np.ones() - Creates array filled with ones
onesArray = np.ones(10)
# print(onesArray)

# 3. np.empty() - Creates empty array with random values - this operation is faster than zeros
emptyArray = np.empty(10)
# print(emptyArray)

# 4. np.arange() - Creates array within a range of values
rangeArray = np.arange(10)
# print(rangeArray)
rangeArrayWithStepSize = np.arange(1, 10, 2)
# print(rangeArrayWithStepSize)

# 5. np.linspace() - Creates an array with specified values with equal gap b/w the start & stop
equalSpacedArray = np.linspace(1, 10, 5)
# print(equalSpacedArray)

# 6. Creates array with specific datatype
# Note- float is the default datatype
intEmptyArray = np.empty(10, dtype = np.int64) # fills random values
# print(intEmptyArray)

# Adding, removing and sorting elements
unsortedArray = np.array([5, 9, 1, -2, 4, 10])
# 1. np.sort() - sorts the array
sortedArray = np.sort(unsortedArray)
# print(sortedArray)

# 2. np.concatenate() - concatenates the array
arr1 = np.array([20, 10])
arr2 = np.array([30, 50])
mergedArray = np.concatenate((arr1, arr2))
# print(mergedArray)

# data.reshape() - Reshapes an array
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

# np.expand_dims() - Expand the dimension of the array
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
# np.vstack() - vertically stacks the arrays
a1 = np.array([[1,1],
               [2,2]])
a2 = np.array([[3,3],
               [4,4]])
verticallyStackedArray = np.vstack((a1, a2))
# print(verticallyStackedArray)
# np.hstack() - horizantally stacks the arrays
horizantallyStackedArray = np.hstack((a1, a2))
# print(horizantallyStackedArray)
# np.hsplit() - splits the array horizantally
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

# Creating Matrices
matrix = np.array([[11, 2],
                   [13, 4],
                   [1, 16]])
# print(matrix)
# accessing matrix elements
# print(matrix[0, 0])
# slicing matrix
# print(matrix[1:])
# print(matrix[0:2, 0])
# By default, aggregate functions operate in all axis and dimensions
# print(matrix.min())
# print(matrix.max())
# print(matrix.sum())
# We can specify the range in which we want the aggregate functions to be applied
# print(matrix.max(axis=0))
# print(matrix.max(axis=1))
# Mathmatical operations on matrix
onesArray = np.ones(dtype=int, shape=(3, 2))
# print(onesArray)
# print(matrix + onesArray)
# print(matrix - onesArray)
# print(matrix * onesArray)
# print(matrix / onesArray)
# print(np.ones(shape=(4, 5, 2), dtype=int))
# print(np.random.random((3, 3)))

# Generating Random Numbers
# print(np.random.randint(1, 100, 5)) # Generate random numbers b/w low(inclusive) & high(exclusive)
# # third parameter is the size
# print(np.random.randint(1, 10, size=(3, 3))) # Generate multidimensional random array

# Get unique items and count
duplicateValuesArray = np.array([1, 1, 2, 3, 2, 5, 4, -1, 3, 5, -2])
# print(np.unique(duplicateValuesArray))
# return the index of unique elements in the array
# print(np.unique(duplicateValuesArray, return_index=True))
# return_counts - returns the occurance of elements in the array 
unique_values, occurance_counts = np.unique(duplicateValuesArray, return_counts=True) 
# print(unique_values)
# print(occurance_counts)
duplicate_2D_array = np.array([[1, 2, 3, 4, 1],
                               [5, 6, 7, 8, 5],
                               [9, 10, 11, 12, 9],
                               [1, 2, 3, 4, 1]])
# print(np.unique(duplicate_2D_array)) # 2D array is flattened & sorted in ascending order
# flattening means converting a multidimensional array to 1 dimensional array
# flattens the 2D array
# print(duplicate_2D_array.flatten())
# unique also works with axis in multidimensional
unique_rows = np.unique(duplicate_2D_array, axis=0)
# print(unique_rows)
unique_cols = np.unique(duplicate_2D_array, axis=1)
# print(unique_cols)

# Transposing and reshaping a matrix
# data.reshape() - changes the dimensions of the matrix
reshaped_2D_array = duplicate_2D_array.reshape(5, 4)
# print(reshaped_2D_array)
# data.transpose() / data.T - returns the transpose of the matrix
# print(duplicate_2D_array.transpose())
# print(duplicate_2D_array.T)

# Reverse an array
# np.flip() - reverses the array along all axis by default
# print(np.flip(a))
# print(np.flip(duplicate_2D_array))
# reversing around axis=0
# print(np.flip(duplicate_2D_array, axis=0))
# reversing around axis=1
# print(np.flip(duplicate_2D_array, axis=1))
# reversing only one row
# duplicate_2D_array[2] = np.flip(duplicate_2D_array[2])
# print(duplicate_2D_array)
# reverse only one column
duplicate_2D_array[:, 0] = np.flip(duplicate_2D_array[:, 0])
# print(duplicate_2D_array)

# Reshapping and flattening multidimensional arrays
# data.flatten() & data.ravel() - helps in flattening the multidimensional array
# data.flatten() does deep copy while data.ravel() doesn't so changes reflect in original array
arr = np.array([[1,2,3,4],
                [5,6,7,8],
                [9,10,11,12]])
# print(arr.flatten())
# print(arr.ravel())