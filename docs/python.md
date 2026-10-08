# Python practical Cheat Sheet

## Navigation

- [1. Core Syntax](#1-core-syntax)
  - [1.1 Variables & Basic Types](#11-variables--basic-types)
  - [1.2 Operators](#12-operators)
  - [1.3 Conditions](#13-conditions)
  - [1.4 For Loops](#14-for-loops)
  - [1.5 While Loops](#15-while-loops)
  - [1.6 Match / Case](#16-match--case)
  - [1.7 Functions](#17-functions)
  - [1.8 Basic Input & Output](#18-basic-input--output)

- [2. Core Data Structures](#2-core-data-structures)
  - [2.1 Strings](#21-strings)
  - [2.2 Lists](#22-lists)
  - [2.3 Tuples](#23-tuples)
  - [2.4 Sets](#24-sets)
  - [2.5 Dictionaries](#25-dictionaries)

---

## Core syntaxe 

### 1. Variables & Basic Types

Python is dynamically typed: variables do not need an explicit type declaration.

```python
name = "Ali"        # str
age = 23            # int
price = 19.99       # float
active = True       # bool
value = None        # NoneType
```

Check types:

```python
type(age)                 # <class 'int'>
isinstance(age, int)      # True
```

Type conversion:

```python
int("42")          # 42
float("3.14")      # 3.14
str(42)            # "42"

list("abc")        # ["a", "b", "c"]
set([1, 1, 2])     # {1, 2}
tuple([1, 2])      # (1, 2)
```

Multiple assignment:

```python
a, b = 10, 20

x = y = 0
```

Swap values:

```python
a, b = b, a
```

---

### 2. Operators

#### Arithmetic

```python
a + b       # addition
a - b       # subtraction
a * b       # multiplication
a / b       # division -> float
a // b      # floor division
a % b       # remainder / modulo
a ** b      # power
```

#### Comparison

```python
 ==  !=  >  <  >=  <= 

# Comparisons can be chained:
0 <= x < 10

#Logical
and or not
```


#### Membership

Checks whether an element exists inside a collection.

```python
x in items
x not in items
```

#### Identity

```python
# Use `is` mainly when comparing with `None`.
value is None
value is not None

# Use `==` for value comparison:
a == b
```

---

### 3. Conditions

```python
if condition:
    instruction

elif other_condition:
    other_instruction

else:
    something

#Multiple conditions:


if age >= 18 and active:
    print("Allowed")
```



#### Truthy / Falsy

These values behave as `False`:

```python
False None 0 0.0 "" [] {} set()
```

#### Ternary Expression

Compact conditional assignment:

```python
status = "Adult" if age >= 18 else "Minor"
```

---

### 4. For Loops

Loop directly over values:

```python
for item in items:
    print(item)
```

#### `range()`

```python
for i in range(2, 5, step): # loops in reverse if step is negative
    print(i)
```


#### Index + Value : `enumerate()`

```python
for i in range(len(items)):
    print(i, items[i])

# prefer this way over for i ... items [i]
for i, item in enumerate(items):
    print(i, item)

# Custom starting index:
for i, item in enumerate(items, start=1):
    print(i, item)
```

#### Multiple Collections — `zip()`

Iterate over collections together:

```python
for name, age in zip(names, ages):
    print(name, age)
```

#### Loop Control

```python
# Exit the loop:
break

# Skip the current iteration:
continue
```

---

### 5. While Loops

Repeat while a condition remains true.

```python

while condition:
    instructions
```

---

### 6. Match / Case

Python's switch-like statement, Available from Python 3.10+.

```python
match choice:

    case something:
        instruction
    case _:
        print("Invalid choice")
```

`|` matches multiple possible values:

```python
case "yes" | "y":
```

`case _` acts as the default case.

---

### 7. Functions

#### core Basics 
```python
def greet(name):
    return f"Hello {name}"

# Call it:
message = greet("Ali")

#Type Hints
def add(a: int, b: int) -> int:
    return a + b

# Default Arguments can be ovverriden
def greet(name: str, greeting: str = "Hello"):
    return f"{greeting} {name}"

greet("Ali")             # Hello Ali
greet("Ali", "Salam")    # Salam Ali
```

#### Keyword Arguments

Arguments can be explicitly named:

```python
greet(name="Ali", greeting="Salam"
)
```

#### Multiple Return Values

Python can return multiple values as a `tuple`:

```python
def calculate(a, b):
    return a + b, a - b

total, difference = calculate(10, 5)
```

---

### 8. Basic Input & Output

#### Output

Formatted output:

```python
print(f"{name} is {age} years old")
```

#### Input

`input()` always returns a string.

```python
name = input("Name: ")

age = int(input("Age: "))

price = float(input("Price: "))

# Multiple values from one line:
a, b = input().split()

# Convert them:
a, b = map(int, input().split())

# For an arbitrary number of integers:
nums = list(map(int, input().split()))
```

## 2. Core Data Structures

### 2.1 Strings

A string is an **ordered, immutable sequence of Unicode characters**.

Being ordered means every character has an index. Being immutable means a string cannot be modified in place: operations such as `replace()` or `upper()` return a new string.

```python
text = "Hello World"

# INDEXING / SLICING
text[0]                    # first character
text[-1]                   # last character

text[start:end:step]       # end is excluded
text[::-1]                 # reversed copy

len(text)

# MEMBERSHIP
"Hello" in text
"Python" not in text


# CASE / CLEANING
text.lower()
text.upper()
text.capitalize()          # first character uppercase
text.title()               # first character of each word uppercase

text.strip()               # remove surrounding whitespace
text.lstrip()
text.rstrip()

text.strip("-")            # remove specified characters from both ends
text.replace(old, new)     # returns a new string


# SPLIT / JOIN
text.split()               # split on whitespace -> list
text.split(separator)

separator.join(strings)    # list/iterable of strings -> one string


# SEARCH
text.find(value)           # first index, -1 if not found
text.count(value)          # number of occurrences

text.startswith(prefix)
text.endswith(suffix)


# CHARACTER CHECKS
text.isdigit()             # only digits
text.isalpha()             # only letters
text.isalnum()             # only letters and/or digits
text.isspace()
text.islower()
text.isupper()


# CHARACTER <-> UNICODE NUMBER
ord(char)                  # character -> Unicode integer
chr(number)                # Unicode integer -> character

index = ord(char) - ord("a")   # a -> 0, b -> 1, ..., z -> 25


# STRINGS ARE IMMUTABLE
text[0] = "A"              # ERROR

text = "A" + text[1:]      # create a new string instead

# For many character modifications:
chars = list(text)
chars[index] = new_char
text = "".join(chars)


# COMMON PATTERNS
text[::-1]                 # reverse
text == text[::-1]         # palindrome check
text.replace(" ", "")      # remove spaces
list(text)                 # string -> list of characters
text.split()               # string -> list of words
```

---

### 2.2 Lists

A Python list is essentially a **dynamic array**.

It is ordered, indexed and mutable. Unlike a fixed-size array, Python automatically grows or shrinks the underlying storage when elements are added or removed.

Lists can contain any Python objects, including objects of different types.

```python
items = [item1, item2, item3]


# INDEXING / SLICING
items[0]                   # first element
items[-1]                  # last element

items[start:end:step]
items[::-1]                # reversed copy

len(items)

value in items
value not in items


# MODIFY ELEMENTS
items[index] = new_value


# ADD ELEMENTS
items.append(value)        # add ONE object at the end

items.extend(iterable)     # add EACH element from iterable at the end

items.insert(index, value) # insert ONE object before index

# Insert several separate elements at an index:
items[index:index] = values


# REMOVE ELEMENTS
items.pop()                # remove + return last element
items.pop(index)           # remove + return element at index

items.remove(value)        # remove first occurrence of value

del items[index]           # delete by index
del items[start:end]       # delete a slice

items.clear()              # empty the existing list


# SEARCH / COUNT
items.index(value)         # index of first occurrence
items.count(value)         # number of occurrences


# SORTING
items.sort()               # modify list in place
items.sort(reverse=True)

new_items = sorted(items)  # return new sorted list

# key = value Python should use when comparing each element
items.sort(key=lambda item: item["field"])

sorted(
    items,
    key=lambda item: item["field"],
    reverse=True
)


# REVERSING
items.reverse()            # modify in place
items[::-1]                # return reversed copy


# USEFUL BUILT-INS
min(items)
max(items)
sum(items)

list1 + list2              # concatenate
[value] * n                # repeat value n times
```

#### References, Copies & Nested Lists

Variables store references to list objects. Assigning one list variable to another does **not** create a new list.

```python
# SAME OBJECT
a = [1, 2, 3]
b = a

b[index] = value           # change is also visible through a


# SHALLOW COPY
b = a.copy()
b = a[:]
b = list(a)

# b is now a different outer list
```

Nested lists require extra care because the elements of the outer list are themselves mutable list objects.

```python
# MATRIX / NESTED LIST
matrix[row][column]


# SAFE: creates a new row on every iteration
matrix = [[0] * columns for _ in range(rows)]


# AVOID:
matrix = [[0] * columns] * rows

# The same row object is referenced several times,
# so modifying one row also modifies the others.
```

---

### 2.3 Tuples

A tuple is an **ordered, immutable sequence**.

It behaves similarly to a list for reading, indexing and iteration, but its elements cannot be added, removed or replaced after creation.

Tuples are useful for fixed groups of values such as coordinates, pairs, function results or dictionary keys.

```python
values = (value1, value2, value3)


# INDEXING / SLICING
values[0]
values[-1]
values[start:end:step]

len(values)

value in values


# IMMUTABLE
values[index] = new_value      # ERROR


# SINGLE-ELEMENT TUPLE
value = (item,)                # comma is required


# UNPACKING
a, b = (value1, value2)

first, *rest = values


# SEARCH / COUNT
values.index(value)
values.count(value)


# CONVERSION
tuple(items)                   # iterable -> tuple
list(values)                   # tuple -> list
```

Multiple return values are automatically packed into a tuple:

```python
def function():
    return value1, value2

a, b = function()
```

---

### 2.4 Sets

A Python set is essentially a **hash set**.

It stores **unique values only** and is optimized for fast membership checks. Sets are unordered from the programmer's point of view and do not support indexing.

Lookup, insertion and deletion are typically **O(1) average time** because values are located using their hash.

```python
items = {value1, value2, value3}

empty_set = set()           # {} creates an empty dictionary, NOT a set


# UNIQUENESS
set([1, 1, 2])              # duplicates automatically removed


# MEMBERSHIP
value in items
value not in items


# ADD / REMOVE
items.add(value)

items.remove(value)         # error if value does not exist
items.discard(value)        # does nothing if value does not exist

items.pop()                 # remove + return an arbitrary element
items.clear()


# SET OPERATIONS
a | b                       # union: values in either set
a & b                       # intersection: values in both
a - b                       # difference: values in a but not b
a ^ b                       # symmetric difference: values in only one set

a.issubset(b)
a.issuperset(b)
a.isdisjoint(b)             # True if they share no values


# CONVERSION
set(iterable)
list(items)
```

A common use is removing duplicates when order does not matter:

```python
unique = set(items)
```

Set elements must be **hashable**, so mutable objects such as lists cannot be stored directly inside a set.

```python
{1, "abc", (1, 2)}         # valid

{[1, 2]}                   # ERROR: list is unhashable
```

---

### 2.5 Dictionaries

A Python dictionary is essentially a **hash map**.

It stores data as **key → value pairs**. Instead of accessing a value using a numeric index, you access it using its key.

Keys are unique and hashable. Lookup, insertion and deletion by key are typically **O(1) average time**.

Modern Python dictionaries preserve insertion order, but their main purpose is key-based lookup rather than positional indexing.

```python
data = {
    key1: value1,
    key2: value2
}

empty = {}


# ACCESS
data[key]                   # error if key does not exist

data.get(key)               # None if missing
data.get(key, default)      # custom fallback


# ADD / UPDATE
data[key] = value           # add new key or replace existing value

data.update(other_dict)     # add/update several pairs


# MEMBERSHIP
key in data                 # checks KEYS
key not in data


# REMOVE
del data[key]

data.pop(key)               # remove + return value
data.pop(key, default)      # avoid error if missing

data.clear()


# VIEWS
data.keys()
data.values()
data.items()                # (key, value) pairs


# ITERATION
for key in data:
    ...

for value in data.values():
    ...

for key, value in data.items():
    ...


# LENGTH
len(data)


# CONVERSION
dict(pairs)
```

Dictionary values can be any objects. Keys must be hashable, so common key types are strings, numbers and tuples.

```python
data["name"]
data[10]
data[(row, column)]

data[[1, 2]]                # ERROR: list cannot be a key
```

A common counting pattern:

```python
counts = {}

for item in items:
    counts[item] = counts.get(item, 0) + 1
```

A common grouping pattern:

```python
groups = {}

for item in items:
    key = get_key(item)

    if key not in groups:
        groups[key] = []

    groups[key].append(item)
```