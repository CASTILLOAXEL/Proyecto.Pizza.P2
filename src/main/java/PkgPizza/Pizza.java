package PkgPizza;

public class Pizza {
    private String name;
    private double precioBase;
    private Topping[] toppings;

    //Constructor
 public Pizza(String name, double precioBase, Topping[] toppings) {
        this.name = name;
        this.precioBase = precioBase;
        this.toppings = toppings;
    }
//getters

    public String getName() {
        return name;
    }
    public double getPrecioBase() {
        return precioBase;
    }

    public Topping[] getToppings() {
        return toppings;
    }

}
