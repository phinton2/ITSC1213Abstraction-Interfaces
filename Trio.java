import java.util.List;
import java.util.ArrayList;
import java.text.*;

/**
 * @author Marc Burns & Paydreanne E. Hinton
 * instructor Professor Van Custodio
 * courseSection ITSC1213-106-27949
 * Module 19 Trio Group Activity
 * The following program showcases the usage of abstraction and interfaces to use methods
 */

interface MenuItem {
    /** @return the name of the menu item */
    String getName();

    /** @return the price of the menu item */
    double getPrice();
}

class SimpleLunchItem implements MenuItem {
    private String name;
    private double price;

    public SimpleLunchItem(String aName, double aPrice) {
        name = aName;
        price = aPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        DecimalFormat money = new DecimalFormat("0.00");
        return getName() + " " + money.format(getPrice());
    }
}

class Drink extends SimpleLunchItem {
    public Drink(String name, double price) {
        super(name, price);
    }
}

class Salad extends SimpleLunchItem {
    public Salad(String name, double price) {
        super(name, price);
    }
}

class Sandwich extends SimpleLunchItem {
    public Sandwich(String name, double price) {
        super(name, price);
    }
}

// Declare the Trio class. It must implement the MenuItem interface.
public class Trio implements MenuItem {
    // declare the instance variables that you need for a trio object
    Sandwich sandwich;
    Salad salad;
    Drink drink;

    // write a constructor that takes a Sandwich, Salad, and a Drink, in that order // COMPLETE!!!
    public Trio(Sandwich sandwich, Salad salad, Drink drink) {
        this.sandwich = sandwich;
        this.salad = salad;
        this.drink = drink;
    }

   // write the getName method it should return
   // sandwich name/salad name/drink name Trio
  public String getName() {
    return "Sandwich: " + sandwich + "\nSalad: " + salad + "\nDrink: " + drink; // toString may be changed...
  }

   // write the getPrice method
   // it should return the price of the two highest price items in the trio.
  public double getPrice() {
    double sandwichPrice = sandwich.getPrice();
    double saladPrice = salad.getPrice();
    double drinkPrice = drink.getPrice();
    double item1 = 0.0;
    double item2 = 0.0;
    if (sandwichPrice > saladPrice || sandwichPrice > drinkPrice) {
      item1 = sandwichPrice;
      if (saladPrice > drinkPrice) {
        item2 = saladPrice;
      }
      else {
        item2 = drinkPrice;
      }
    }
    else if (saladPrice > sandwichPrice && drinkPrice > sandwichPrice) {
      item1 = drinkPrice;
      item2 = saladPrice;
      }

    //because the class type is double it has to return a double
    return item1 + item2; // temporary variable; will be removed later time
  }

    public static void main(String[] args) {
        Sandwich burger = new Sandwich("Cheeseburger", 2.75);
        Sandwich club = new Sandwich("Club Sandwich", 2.75);
        Salad spinachSalad = new Salad("Spinach Salad", 1.25);
        Salad coleslaw = new Salad("Coleslaw", 1.25);
        Drink orange = new Drink("Orange Soda", 1.25);
        Drink cap = new Drink("Cappuccino", 3.50);
        Trio trio1 = new Trio(burger, spinachSalad, orange);
        System.out.println("It should print Cheeseburger/Spinach Salad/Orange Soda Trio and it prints: " + trio1.getName());
        System.out.println("It should print 4.0 and it prints: " + trio1.getPrice());
        Trio trio2 = new Trio(club, coleslaw, cap);
        System.out.println("It should print Club Sandwich/Coleslaw/Capuccino Trio and it prints: " + trio2.getName());
        System.out.println("It should print 6.25 and it prints: " + trio2.getPrice());
    }
}
