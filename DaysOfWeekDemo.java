// Enum declaration to capture days of the week
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

// Superclass
class Week {
    // Protected variable (accessible in subclasses)
    protected Day currentDay;

    // Constructor to set the current day
    public Week(Day currentDay) {
        this.currentDay = currentDay;
    }

    // Public method to get the current day
    public Day getCurrentDay() {
        return currentDay;
    }

    // Public method to display the day
    public void displayDay() {
        System.out.println("Today is: " + currentDay);
    }

    // Static nested class (can be instantiated without an instance of the outer class)
    static class Weekdays {
        public void showWeekdays() {
            System.out.println("Weekdays: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY");
        }
    }

    // Inner class (requires an instance of the outer class to instantiate)
    class Weekend {
        public void showWeekend() {
            System.out.println("Weekend: SATURDAY, SUNDAY");
        }
    }
}

// Subclass extending the superclass Week
class WeekPlanner extends Week {

    // Constructor for the subclass
    public WeekPlanner(Day currentDay) {
        super(currentDay); // Calling the superclass constructor using super
    }

    // Public method to plan an activity based on the current day
    public void planActivity() {
        if (currentDay == Day.SATURDAY || currentDay == Day.SUNDAY) {
            System.out.println("It's weekend! Time to relax.");
        } else {
            System.out.println("It's a weekday. Stay focused and keep working.");
        }
    }
}

// Main class
public class DaysOfWeekDemo {
    public static void main(String[] args) {
        // Object instantiation of the WeekPlanner subclass
        WeekPlanner weekPlanner = new WeekPlanner(Day.WEDNESDAY);
        
        // Accessing methods and displaying the current day
        weekPlanner.displayDay();
        weekPlanner.planActivity();

        // Instantiating the static nested class
        Week.Weekdays weekdays = new Week.Weekdays();
        weekdays.showWeekdays();

        // Instantiating the inner class through an instance of the outer class
        Week.Weekend weekend = weekPlanner.new Weekend();
        weekend.showWeekend();

        // Demonstrating a different day
        weekPlanner = new WeekPlanner(Day.SATURDAY);
        weekPlanner.displayDay();
        weekPlanner.planActivity();
    }
}
