package Delivery;
import pizza.Pizza;

public class Delivery {
    public static void main(String[] args) throws Exception {
        Pizza pizzaobject = new Pizza();
        pizzaobject.pizzaName = "Margherita";
        pizzaobject.makePizza();
        System.out.println("Tank you for ordering " + pizzaobject.pizzaName);
    }
}
