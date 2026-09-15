# Python Syntax Cheat Sheet

## 1. Variables & Basic Types

```python
name = "Abderrahmane"   # str
age = 23                # int
price = 19.99           # float
active = True           # bool
value = None            # NoneType

type(age)
isinstance(age, int)

int("42")
float("3.14")
str(42)
bool(1)
```


---

## 2. Operators

```python
# Arithmetic
+   -   *   /
//      # floor division
%       # modulo
**      # power

# Comparison
==  !=  >  <  >=  <=

# Logical
and
or
not

# Membership
x in items
x not in items

# Identity
x is None
x is not None
```

---

## 3. Strings

```python
text = "Hello World"

text[0]
text[-1]
text[0:5]

len(text)

text.lower()
text.upper()
text.strip()
text.replace("World", "Python")
text.split(" ")

"-".join(["a", "b", "c"])

name = "Ali"
age = 23

message = f"{name} is {age} years old"

multiline = """
Hello
World
"""
```

---

## 4. Conditions

```python
if age >= 18:
    print("Adult")
elif age >= 13:
    print("Teen")
else:
    print("Child")
```

Ternary:

```python
status = "Adult" if age >= 18 else "Minor"
```

---

## 5. Match / Case (Switch-Like Statement)

Available in Python 3.10 and newer:

```python
choice = input("Choose an option: ")

match choice:
    case "1":
        print("Add expense")
    case "2":
        print("List expenses")
    case "3" | "4":
        print("Search or statistics")
    case "6":
        print("Exit")
    case _:
        print("Invalid choice")
```

`case _` is the default case and matches anything not handled above.

---

## 6. Lists

```python
nums = [10, 20, 30]

nums[0]
nums[-1]
nums[1:3]

len(nums)

nums.append(40)
nums.extend([50, 60])
nums.insert(1, 15)

nums.remove(20)
value = nums.pop()
del nums[0]

20 in nums

nums.sort()
nums.sort(reverse=True)

new_nums = sorted(nums)

copy = nums.copy()
```

---

## 7. Tuples

```python
point = (10, 20)

point[0]

x, y = point

a, b = 1, 2

a, b = b, a
```

Single-item tuple:

```python
value = (10,)
```

---

## 8. Sets

```python
a = {1, 2, 3}
b = {3, 4, 5}

a.add(4)
a.remove(2)
a.discard(10)

a | b       # union
a & b       # intersection
a - b       # difference

3 in a
```

Remove duplicates:

```python
unique = set(items)
```

---

## 9. Dictionaries

```python
user = {
    "name": "Ali",
    "age": 23
}

user["name"]

user["email"] = "ali@example.com"

user.get("email")
user.get("country", "Morocco")

del user["age"]

user.keys()
user.values()
user.items()

"name" in user
```

Loop:

```python
for key, value in user.items():
    print(key, value)
```

---

## 10. For Loops

```python
for item in items:
    print(item)
```

Range:

```python
for i in range(5):
    print(i)

for i in range(1, 10):
    print(i)

for i in range(0, 10, 2):
    print(i)
```

Index + value:

```python
for index, item in enumerate(items):
    print(index, item)

for index, item in enumerate(items, start=1):
    print(index, item)
```

Multiple collections:

```python
for name, age in zip(names, ages):
    print(name, age)
```

Control:

```python
break
continue
```

---

## 11. While Loops

```python
count = 0

while count < 5:
    print(count)
    count += 1
```

---

## 12. List Comprehensions

```python
squares = [x ** 2 for x in nums]

evens = [x for x in nums if x % 2 == 0]

names = [user["name"] for user in users]
```

Conditional expression:

```python
labels = [
    "even" if x % 2 == 0 else "odd"
    for x in nums
]
```

---

## 13. Dict & Set Comprehensions

Dictionary:

```python
squares = {
    x: x ** 2
    for x in range(5)
}
```

Set:

```python
unique_squares = {
    x ** 2
    for x in nums
}
```

---

## 14. Functions

```python
def greet(name):
    return f"Hello {name}"
```

Type hints:

```python
def add(a: int, b: int) -> int:
    return a + b
```

Default arguments:

```python
def greet(name: str, greeting: str = "Hello"):
    return f"{greeting} {name}"
```

Keyword arguments:

```python
greet(name="Ali", greeting="Salam")
```

Multiple return values:

```python
def calculate(a, b):
    return a + b, a - b

total, difference = calculate(10, 5)
```

---

## 15. `*args` & `**kwargs`

```python
def total(*numbers):
    return sum(numbers)

total(1, 2, 3, 4)
```

```python
def create_user(**data):
    print(data)

create_user(
    name="Ali",
    age=23
)
```

---

## 16. Unpacking

List / tuple:

```python
values = [1, 2, 3]

a, b, c = values

first, *rest = values
```

Function arguments:

```python
def add(a, b):
    return a + b

values = [10, 20]

add(*values)
```

Dictionary:

```python
data = {
    "name": "Ali",
    "age": 23
}

create_user(**data)
```

Merge:

```python
combined = [*list1, *list2]

merged = {**dict1, **dict2}
```

---

## 17. Useful Built-ins

```python
len(items)

sum(nums)

min(nums)
max(nums)

abs(-10)
round(3.14159, 2)

sorted(items)

any([False, True])
all([True, True])

list(...)
tuple(...)
set(...)
dict(...)

range(...)
enumerate(...)
zip(...)
```

---

## 18. Sorting

```python
nums = sorted(nums)

nums = sorted(nums, reverse=True)
```

Objects/dictionaries:

```python
users = sorted(
    users,
    key=lambda user: user["age"]
)
```

Descending:

```python
users = sorted(
    users,
    key=lambda user: user["age"],
    reverse=True
)
```

---

## 19. Lambda

```python
square = lambda x: x ** 2

square(5)
```

Most commonly:

```python
sorted(users, key=lambda user: user["age"])
```

---

## 20. Exceptions

```python
try:
    number = int(input("Number: "))

except ValueError:
    print("Invalid number")

except Exception as e:
    print(e)

else:
    print("Success")

finally:
    print("Finished")
```

Raise:

```python
if age < 0:
    raise ValueError("Age cannot be negative")
```

---

## 21. User Input

```python
name = input("Name: ")

age = int(input("Age: "))

price = float(input("Price: "))
```

---

## 22. Files

Read entire file:

```python
with open("data.txt", "r") as file:
    content = file.read()
```

Read lines:

```python
with open("data.txt", "r") as file:
    lines = file.readlines()
```

Write:

```python
with open("data.txt", "w") as file:
    file.write("Hello")
```

Append:

```python
with open("data.txt", "a") as file:
    file.write("\nNew line")
```

---

## 23. JSON

JSON syntax:

```json
{
  "name": "Lunch",
  "amount": 65.50,
  "paid": true,
  "note": null,
  "categories": ["Food", "Work"],
  "details": {
    "date": "2026-09-02",
    "currency": "MAD"
  }
}
```

Common JSON structures:

```json
{"key": "value"}
["first", "second", "third"]
[
  {"id": 1, "description": "Lunch", "amount": 65.50},
  {"id": 2, "description": "Taxi", "amount": 30.00}
]
```

JSON rules:

- Objects use `{}` and contain `"key": value` pairs.
- Arrays use `[]` and contain comma-separated values.
- Strings and object keys require double quotes.
- Values can be strings, numbers, objects, arrays, `true`, `false`, or `null`.
- Do not place a comma after the final item.
- Standard JSON does not support comments.

Python equivalents:

```text
JSON object  → Python dict
JSON array   → Python list
JSON true    → Python True
JSON false   → Python False
JSON null    → Python None
```

Using JSON in Python:

```python
import json
```

File → Python:

```python
with open("users.json", "r") as file:
    users = json.load(file)
```

Python → file:

```python
with open("users.json", "w") as file:
    json.dump(users, file, indent=2)
```

String → Python:

```python
data = json.loads(json_string)
```

Python → string:

```python
json_string = json.dumps(data)
```

---

## 24. Imports

```python
import math

math.sqrt(16)
```

Specific import:

```python
from math import sqrt

sqrt(16)
```

Alias:

```python
import numpy as np
```

Own modules:

```python
from services import calculate_total
```

---

## 25. Classes

```python
class User:

    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

    def greet(self) -> str:
        return f"Hello, I'm {self.name}"


user = User("Ali", 23)

user.name
user.greet()
```

Inheritance:

```python
class Admin(User):

    def __init__(self, name, age, permissions):
        super().__init__(name, age)
        self.permissions = permissions
```

---

## 26. Dataclasses

```python
from dataclasses import dataclass


@dataclass
class User:
    name: str
    age: int
    active: bool = True


user = User(
    name="Ali",
    age=23
)
```

---

## 27. Type Hints

```python
name: str = "Ali"
age: int = 23
price: float = 10.5
active: bool = True

names: list[str] = ["Ali", "Sara"]

user: dict[str, str] = {
    "name": "Ali"
}
```

Functions:

```python
def find_user(user_id: int) -> dict | None:
    ...
```

---

## 28. Generators

Normal function:

```python
def numbers():
    return [1, 2, 3]
```

Generator:

```python
def numbers():
    yield 1
    yield 2
    yield 3


for number in numbers():
    print(number)
```

Generator expression:

```python
squares = (x ** 2 for x in range(100))
```

---

## 29. Useful `collections`

```python
from collections import Counter, defaultdict
```

Count:

```python
counts = Counter(["a", "b", "a"])

counts["a"]
```

Default dictionary:

```python
groups = defaultdict(list)

for user in users:
    groups[user["country"]].append(user)
```

---

## 30. Path Handling

```python
from pathlib import Path
```

Current working directory (where the program was launched):

```python
working_folder = Path.cwd()

# Relative to the current working directory
path = Path("data/users.json")
```

Directory containing the current Python script:

```python
current_file = Path(__file__)
script_folder = current_file.parent

# Reliable path to a file beside this Python script
json_path = script_folder / "expenses.json"
```

Useful path properties and methods:

```python
path = Path("data/users.json")

path.exists()
path.name
path.parent

content = path.read_text()
path.write_text("Hello")
```

Opening a `Path` works like opening a string path:

```python
with open(json_path, "r") as file:
    content = file.read()
```

- `Path.cwd()` is the folder from which the program was launched.
- `__file__` is the path of the current Python file.
- `.parent` gives the directory containing a path.
- `/` joins path components; it does not mean division here.
- A relative path such as `"expenses.json"` is relative to `Path.cwd()`, not automatically to the script.

---

## 31. Main Entry Point

```python
def main():
    print("Starting...")


if __name__ == "__main__":
    main()
```

---

# Quick Mental Reference

```python
# loop
for x in items:
    ...

# index + item
for i, x in enumerate(items):
    ...

# condition
if x:
    ...
elif y:
    ...
else:
    ...

# list transform
result = [f(x) for x in items]

# list filter
result = [x for x in items if condition(x)]

# function
def func(x: int) -> str:
    ...

# dictionary loop
for key, value in data.items():
    ...

# safe dictionary access
value = data.get("key", default)

# null check
if value is None:
    ...

# exception
try:
    ...
except ValueError:
    ...

# file
with open("file.txt", "r") as f:
    ...

# main
if __name__ == "__main__":
    main()
```