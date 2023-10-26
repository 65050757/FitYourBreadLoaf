import java.util.ArrayList;

public class DefaultBreadLoaf extends BreadLoaf {
    
    BreadLoaf bread;
    
    public DefaultBreadLoaf(String name){
        makeBread(name);
    }

    private void makeBread(String name){
        bread = new BreadLoaf();
        bread.setIngredients(new ArrayList<>());
    
        if(name.equals("Original")){//name ที่ใส่ตรงกับ input
            bread.setMenuName("Original");
            bread.setPanSize(2400);
            bread.addIngredient(new Ingredient("flour", 313));
            bread.addIngredient(new Ingredient("yeast", 4));
            bread.addIngredient(new Ingredient("sugar", 15));
            bread.addIngredient(new Ingredient("salt", 6));
            bread.addIngredient(new Ingredient("lukewarmWater", 225));
            bread.addIngredient(new Ingredient("butter", 17));
        }

        else if(name.equals("Chocolate")){
            bread.setMenuName("Chocolate");
            bread.setPanSize(1600);
            bread.addIngredient(new Ingredient("flour", 175));
            bread.addIngredient(new Ingredient("butter", 175));
            bread.addIngredient(new Ingredient("brownSugar", 175));
            bread.addIngredient(new Ingredient("meltchoc", 75));
            bread.addIngredient(new Ingredient("chopchoc", 75));
            bread.addIngredient(new Ingredient("egg", 180));
            bread.addIngredient(new Ingredient("cocoapowder", 22.5));
            bread.addIngredient(new Ingredient("bakingpowder", 21.6));
        }
        
        else if(name.equals("Butter")){
            bread.setMenuName("Butter");
            bread.setPanSize(1600);
            bread.addIngredient(new Ingredient("flour", 461));
            bread.addIngredient(new Ingredient("butter", 42));
            bread.addIngredient(new Ingredient("sugar", 18.4));
            bread.addIngredient(new Ingredient("salt", 7.2));
            bread.addIngredient(new Ingredient("water", 217));
            bread.addIngredient(new Ingredient("egg", 46));
            bread.addIngredient(new Ingredient("yeast", 6.9));
        }
    } 

    public BreadLoaf getBread() {
        return bread;
    }

    public void setBread(BreadLoaf bread) {
        this.bread = bread;
    }




}