package pizza;


public class Pizza {
    public String pizzaName;
    int discount;
    private String pizzaRecipe = "Secret Sauce";

    public Pizza(){}
    
    public void makePizza(){
        System.out.println("Your pizza is being made");
    }
    public String getSecretRecipe(){
        return pizzaRecipe;
    }
}
