# iterable - Iterable is an object that produces iterator. Exp- list, tuple, set, dict, str
# iterator - Iterator is a object that returns one value at a time using next()
marks: list[int] = [81, 87, 93, 95]
marksIter = iter(marks)

print(next(marksIter))
print(next(marksIter))
print(next(marksIter))
print(next(marksIter))
# print(next(marksIter))