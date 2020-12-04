# WEB Java Fundamentals Sprint Challenge

**Read these instructions carefully. Understand exactly what is expected _before_ starting this Sprint Challenge.**

Test
This challenge allows you to practice the concepts and techniques learned over the past sprint and apply them in a concrete project. This sprint explored **Java Fundamentals**. During this sprint, you studied **Java Fundamentals*. In your challenge this week, you will demonstrate your mastery of these skills by creating **a Java Spring Database Application using Object Oriented Programming**.

This is an individual assessment. All work must be your own. Your challenge score is a measure of your ability to work independently using the material covered through this sprint. You need to demonstrate proficiency in the concepts and objectives introduced and practiced in preceding days.

You are not allowed to collaborate during the sprint challenge. However, you are encouraged to follow the twenty-minute rule and seek support from your TL if you need direction.

_You have **three hours** to complete this challenge. Plan your time accordingly._

## Introduction

This sprint challenge combines the knowledge from this week's Java Fundamentals lessons to create a Magical Piggy Bank using Java and the Spring Frame. We have a magical "piggy bank" (a piggy bank is the traditional name of a place to store coins, bills, money). The piggy bank is magical because it can hold unlimited amounts of money. However, you can not get the money out of it.

### Commits

Commit your code regularly and meaningfully. This helps both you (in case you ever need to return to old code for any number of reasons) and your team lead as the evaluate your solution.

## Interview Questions

Be prepared to demonstrate your understanding of this week's concepts by answering questions on the following topics. You might prepare by writing down your own answers before hand.

1. Explain how you took advantage of Java's Object-Oriented approach to solve the sprint challenge.
   - I created multiple classes to blueprint individual objects with class-level attributes and behaviors. These classes (with one interface) effectively employ abstraction via getters, setters, helper functions, and the like. Encapsulation is employed only in the Coin Model class, but that's because the Spring framework effectively takes care of the heavy lifting (hell, talk about encapsulation & abstraction——let's look at Spring!).
  There's a little hint of Polymorphism in each endpoint in the controller with the annotation `GetMapping`. If you look at their return statement, you'll find that it returns a ResponseEntity<?>. Some of the most blatant Polymorphism you could find! That function has the ability to return a ResponseEntity containing an object of an unknown type, shape, etc. That is the essence behind Polymorphism, the ability to take many different forms.
   - I employed SOLID principles as best I could. For Sigle-responsibilty principle, I managed each task within it's contained space (see HelperFunctions class for helper functions to allow CoinController ONLY work on managing coins). 
2. Explain the three steps needed to run a Java application (using the JDK) including what each step does and how those step correlate to running a JavaScript application.
    - `javac <project_name>*/.java` 
      - Converts source code to bytecode for, code ready for execution in the JVM. This command creates an associated `.class` file for each found `.java` file—that `.class` file contains the executable bytecode. Any runtime error found will be printed to the console to notify the class and line that contains the error.   
    - `jar cvfe <arbitrary_name_for_jar_file (chosen now)>.jar <project_name>.<ClassToCompile> <project_name>/*.class`
      - Creates `c` a new file archive with the given name. (I had to reference notes for this one) — the `v` directs the archive file to generate verbose output. The `f` specifies the jar output file will be created, under whatever name you specify in this command. `e` sets the main class (also known as the Entry point). 
    - `java -jar <arbitrary_name_for_jar_file (chosen above)>`
      - `java` launches the Java Virtual Machine. `-jar` specifies that we are using a jar file (created in the step above). The final argument `<arbitrary_name>` is the name of the `.jar` file given to the `jar` command in the step above. This is how we select that specific program for execution.
3. Explain how Java being a strongly typed language affected you solution.
   - For one it made me happier to write a solution with constraints set by me. Every little step of execution at runtime will know what data type to expect. This allows for way more errors to be thrown, which is really just preferable for a program like this... it allows me, as the dev, to say—_hey, this function needs to take in X and return Y. If it DOESN'T do that, something is wrong and I want to kill the program (or, preferably, handle the error with custom error handling, but we haven't quite made it there yet)_. 
4. Can you explain the differences between Abstract Classes and Interfaces including how they are used in your application? 
   - `Abstract classes` are quite a bit more fully fleshed-out than `Interfaces` in that they are fully-fledged classes. They can have `constructors`, `fields`, `abstract methods` (which allow subclasses to implement themselves), and fully-operational ready-to-go `methods`. Classes can only inherit from ONE `Abstract class`, via the `extends` keyword.
   - `Interfaces`, on the other hand, are really just a list of methods signatures specifying the name of the method, the return type of the method, and the parameters taken in by that method. Then, whenever a class `implements` an interface or multiple interfaces, the implementation class must IMPLEMENT all the methods specified in the `Interface`.   

## Instructions

### Task 1: Project Set Up

- [x] Create a forked copy of this project
- [x] Add your team lead as collaborator on Github
- [x] Clone your OWN version of the repository (Not Lambda's by mistake!)
- [x] Create a new branch: git checkout -b `<firstName-lastName>`.
- [x] Create the proper directory structure for developing a Java Application
- [x] Push commits: `git push origin <firstName-lastName>`
- [x] Implement the project on your newly created `<firstName-lastName>` branch, committing changes regularly
- [x] Push commits: git push origin `<firstName-lastName>`

### Task 2: Project Requirements

- [x] You are creating a project from scratch! There is no initial project from where to start.
- [x] Using the wizard in IntelliJ, create a Java Spring Application
  - [x] Name the application piggybank
  - [x] Steps to remember in generating the initial application
    - [x] Set the Group and Artifact Name
    - [x] Set that this is a Maven Project
    - [x] Select the proper Java Version
    - [x] Select Spring Boot Version 2.2.X
    - [x] Add the 4 Dependencies we need for a Java Spring Database Application
    - [x] You do not need to use services or configuration packages
    - [x] You do need to
      - [x] update your POM.XML so H2 will work
      - [x] update the applications.properties configuration file
      - [x] add the data.sql file
      - [x] create the necessary packages (at least 3 are needed) and classes
- [x] Create a model Coin to represent the table for the piggy bank
  - Each row in the table contains: (use the provided data.sql as a guide)
    - The number of coins in this group
    - The face value of the coins in the group
    - The name of a single coin
    - The name of more than one coin
- [x] Create an endpoint http://localhost:2019/total that prints to console the contents of the Piggy Bank as follows and returns an HTTP Status of OK:

In your console in IntelliJ you should see:

```TEXT
    1 Quarter
    1 Dime
    5 Dollars
    3 Nickels
    7 Dimes
    1 Dollar
    10 Pennies
    The piggy bank holds 7.3
```

In Postman you should see

![Postman Image](postman.png)

Note: 7.30 = ( 1 * 0.25) + ( 1 * 0.10) + ( 5 * 1.00) + ( 3 * 0.05) + ( 7 * 0.10) + ( 1 * 1.00) + (10 * 0.10)

Note: that when you have more than 1 coin, the plural of the coin's name is printed.

### Required best practices

- [x] Consistent naming. Examples: variables, functions, Components, and file/folder organization.
- [x] Consistent spacing. Examples: line breaks, around arguments and before/after functions.
- [x] Consistent quotation usage.
- [x] Spell-check.
- [x] Schedule time to review, refine and reassess your work.

It is better to submit a challenge that meets [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) than one that attempts too much and fails.

### Tips and Gotchas

In your solution, it is essential that you follow best practices and produce clean and professional results. You will be scored on your adherence to proper code style and good organization. Schedule time to review, refine, and assess your work and perform basic professional polishing including spell-checking and grammar-checking on your work. It is better to submit a challenge that meets MVP than one that attempts too much and does not.

### Task 3: Stretch Goals

After finishing your required elements, you can push your work further. These goals may or may not be things you have learned in this module but they build on the material you just studied. Time allowing, stretch your limits and see if you can deliver on the following optional goals:

- [ ] Add the ability to remove coins from the piggy bank
  - Prevent taking more coins than present in the piggy bank
  - Coins do not have to be removed in the same quantity that were added. For example based on the main program above, removing 3 dimes would be allowed. The Piggy Bank should adjust appropriately.
  - Just the amount to be removed should be given. The program will figure out which coins to remove.
  - You are to create an endpoint http://localhost:2019/money/{amount} that prints to the console the following (using 1.5 as the amount to remove) and returns an HTTP Status of OK

```TEXT
    $4
    7 Dimes
    $1
    10 Pennies
    The piggy bank holds $5.8
```

  - If the money cannot be removed, the following should be printed to the console and return an HTTP Status of OK

```TEXT
    Money not available
```

## Submission format

Follow these steps for completing your project.

- [ ] Submit a Pull-Request to merge <firstName-lastName> Branch into master (student's  Repo). **Please don't merge your own pull request**
- [ ] Add your team lead as a reviewer on the pull-request
- [ ] Your team lead will count the project as complete after receiving your pull-request
