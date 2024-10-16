
# Days of the Week Program

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Concepts Demonstrated](#concepts-demonstrated)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
  - [Enum Declaration](#enum-declaration)
  - [Superclass: Week](#superclass-week)
  - [Subclass: WeekPlanner](#subclass-weekplanner)
  - [Main Class: DaysOfWeekDemo](#main-class-daysofweekdemo)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction
This Java program is designed to demonstrate fundamental Object-Oriented Programming (OOP) concepts using an example of displaying and interacting with the days of the week. The program employs **enums**, **classes**, **subclasses**, **static nested classes**, and **inner classes** to highlight key programming techniques.

The main goal of this program is to:
1. Display the current day of the week.
2. Distinguish between weekdays and weekends.
3. Show usage of enums, access control, object instantiation, and different types of classes (nested and inner).

## Features
- **Enum for Days of the Week**: The program defines the days of the week using the `enum` type for better readability and maintainability.
- **Inheritance**: Demonstrates how to use inheritance via a subclass (`WeekPlanner`) that extends a superclass (`Week`).
- **Static Nested Class and Inner Class**: Illustrates how to create and use static nested and inner classes in Java.
- **Access Control**: Shows how to protect class members using different access modifiers such as `protected` and `public`.

## Concepts Demonstrated
This program showcases several Java concepts:
- **Enum**: Creating and using enums to represent constants.
- **Class Declaration**: Declaring a superclass and a subclass.
- **Object Instantiation**: Creating objects of classes and accessing their methods and variables.
- **Method and Variable Access**: Accessing methods and variables in the class hierarchy.
- **Static Nested Classes**: Defining and using static nested classes that don't require an instance of the outer class.
- **Inner Classes**: Defining and using inner classes that require an instance of the outer class.
- **Access Control**: Demonstrating protected and public access modifiers.

## Installation
To run this program, you need:
1. Java Development Kit (JDK) installed on your system. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).
2. A text editor or an IDE (such as IntelliJ IDEA or Eclipse) to write and execute the code.

### Steps:
1. Clone this repository or download the source code.
2. Open the project in your favorite Java IDE or text editor.
3. Compile and run the `DaysOfWeekDemo.java` file.

## Usage
Follow these steps to run the program:

1. Open the terminal or command prompt.
2. Navigate to the directory where the source file is located.
3. Compile the program using the following command:

   ```bash
   javac DaysOfWeekDemo.java
   ```

4. Run the program:

   ```bash
   java DaysOfWeekDemo
   ```

The output will display the current day, followed by whether it is a weekday or a weekend.

## Code Structure

### Enum Declaration

```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```
The `Day` enum defines constants for each day of the week. Enums are used for a fixed set of related constants and make the code more readable.

### Superclass: Week

```java
class Week {
    protected Day currentDay;

    public Week(Day currentDay) {
        this.currentDay = currentDay;
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void displayDay() {
        System.out.println("Today is: " + currentDay);
    }

    static class Weekdays {
        public void showWeekdays() {
            System.out.println("Weekdays: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY");
        }
    }

    class Weekend {
        public void showWeekend() {
            System.out.println("Weekend: SATURDAY, SUNDAY");
        }
    }
}
```

- `currentDay`: A protected variable that holds the current day.
- `Weekdays`: A static nested class that lists the weekdays.
- `Weekend`: An inner class that lists the weekend days.

### Subclass: WeekPlanner

```java
class WeekPlanner extends Week {

    public WeekPlanner(Day currentDay) {
        super(currentDay);
    }

    public void planActivity() {
        if (currentDay == Day.SATURDAY || currentDay == Day.SUNDAY) {
            System.out.println("It's weekend! Time to relax.");
        } else {
            System.out.println("It's a weekday. Stay focused and keep working.");
        }
    }
}
```

- `WeekPlanner`: A subclass that extends `Week`. It inherits the `currentDay` variable and `displayDay` method. Additionally, it defines a new method, `planActivity`, to suggest activities based on the day.

### Main Class: DaysOfWeekDemo

```java
public class DaysOfWeekDemo {
    public static void main(String[] args) {
        WeekPlanner weekPlanner = new WeekPlanner(Day.WEDNESDAY);
        weekPlanner.displayDay();
        weekPlanner.planActivity();

        Week.Weekdays weekdays = new Week.Weekdays();
        weekdays.showWeekdays();

        Week.Weekend weekend = weekPlanner.new Weekend();
        weekend.showWeekend();

        weekPlanner = new WeekPlanner(Day.SATURDAY);
        weekPlanner.displayDay();
        weekPlanner.planActivity();
    }
}
```

- In the `main` method, objects are created for both the subclass (`WeekPlanner`) and nested/inner classes (`Weekdays` and `Weekend`), and their respective methods are called.

## Examples
### Sample Output:

```
Today is: WEDNESDAY
It's a weekday. Stay focused and keep working.
Weekdays: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
Weekend: SATURDAY, SUNDAY
Today is: SATURDAY
It's weekend! Time to relax.
```

The program displays the day and suggests activities based on whether it's a weekday or weekend.

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request or open an issue for improvements and suggestions.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
