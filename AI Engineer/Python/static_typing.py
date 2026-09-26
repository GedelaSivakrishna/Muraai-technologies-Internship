# type hints - mentioning the data types for variables, function parameters, return values, data structures etc
name: str = 'Gedela Sivakrishna'
age: int = 23

def display(name: str, age: int) -> None:
    print(f"I am {name}, {age} years old")

# display(name, age)

marks: list[int] = [93, 95, 87, 81]
address: tuple[str, str, int] = ('Vistala', 'Odisha', 761208)
skills: set[str] = {'Java', 'React', 'Spring Boot'}
student: dict[str, str | int] = { 'name': 'Sivakrishna', 'age': 23 }

# static type checking - this helps in editors to highlight any mismatched types of variables, parameters. 
