# File I/O means reading data from files and writing data to files.
# File I/O helps in storing data permanently instead of keeping it in memory.

# file = open("notes.txt", "r")
# content = file.read()

# file.close()

# print(content)

# write - This operation overwrites the existing content
# file = open("notes.txt", "w")
# file.write("I am sivakrishna, learning python file i/o operations")

# append - Adds new content to the existing file content
# file = open("notes.txt", "a")
# file.write("\n This sentence gets appended to the end of existing file content")

# different modes to open a file
# 1. r -> read content from file
# 2. w -> write content to file. This overwrites the existing content.
# 3. a -> Adds new content to the existing file content. This operation
# doesn't overwrite the existing content.
# 4. x -> creates new file, fails if file exists
# 5. rb -> read binary data like images, videos, audio.

# file = open("Profile 2.jpg", "rb")
# data = file.read()
# print(data)

# file.close()

# with keyword - helps in resource management. It closes the files automatically even if error occurs.
# This is a clean syntax for try-catch-finally block where we have to manually close the file.
# with open("notes.txt") as file, open("notes2.txt", "x") as file2:
#     print(file.read())
#     file2.write("This is notes2 file")


