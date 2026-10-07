# List - Ordered collection of different data types and mutable
skills = ['Java', 'React', 'Spring boot']

# add
skills.append('Angular')
skills.append('Python')

# access
# print(skills[0])

# Tuple - Ordered collection of different data types and immutable
imp_dates = ('21/04/2003', '07/01/2025', '07/07/2026', '08/10/2026')

# access
# print(imp_dates[0])

# Set - Collection of unique values of different data types and mutable
student = {10, 20, 'Siva', 54}

# add
student.add(175)
student.add(251)

# remove
student.remove('Siva')

# access
# print(student)

# dict - collection of key value pairs, mutable and only unique keys
employee: dict[str, str | int] = {
    'name': 'Gedela Sivakrishna',
    'joining date': '07/07/2025',
    'blood group': 'O+ve',
    'role': 'software engineer'
}

# add
employee['contact no'] = 9692849788

# access
# print(employee['name'])
# print(employee)