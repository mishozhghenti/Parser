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

#### Brief Algorithm Overview:
Iteratively parse a string and recursively link its dependencies. Each Node (named 'Item') contains the name itself (named 'Value') and list of Nodes (named 'List').

For recursion, I used Depth First Search (DFS).
