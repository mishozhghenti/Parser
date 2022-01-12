# Parser
Customized string parser

### Using: Java 1.8
#### This solution assumes that passed String value is valid.

#### Build command:
```
javac Main.java
```

#### Run command:
```
java Main
```

#### Brief Algorithm Overview (including the Bonus task):
Iteratively parse a string and recursively link its dependencies. Each Node (named 'Item') contains the name itself (named 'Value') and list of Nodes (named 'List').

For recursion, Depth First Search (DFS) is used.
For sorting, `ArrayList.sort()` is used. In order to sort every node and its list, I call the sorting recursively.

#### Includes unit tests
