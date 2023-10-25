public class Ingredient{
    private String name;
    private double quantityIngram; //gram in unit

    public Ingredient(String name,double quantity){
        this.name = name;
        this.quantityIngram = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity(){
        return quantityIngram;
    }

     public void setQuantity(double quantity){
        quantityIngram = quantity;
    }

    @Override
    public String toString(){
        return name + " " + quantityIngram + " gram";
    }
}