public class Ingredient{
    private String name;
    private double quantityIngram; //gram in unit

    public Ingredient(String name,double quantity){
        this.name = name;
        this.quantityIngram = quantity;
    }

    @Override
    public String toString(){
        return name + " " + quantityIngram + " gram";
    }
}