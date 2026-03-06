package pizza;

public class Main {
    public static void main(String[] args) throws Exception {
        Pizza pizzaobject = new Pizza();
        pizzaobject.pizzaName = "Margherita";
        pizzaobject.makePizza();
        System.out.println("Tank you for ordering " + pizzaobject.pizzaName);
        System.out.println("The secret recipe is" + pizzaobject.getSecretRecipe());
    }
}
