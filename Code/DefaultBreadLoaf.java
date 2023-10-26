public class DefaultBreadLoaf extends BreadLoaf {
    
    BreadLoaf butterBreadLoaf = new BreadLoaf();
    BreadLoaf chocoBreadLoaf  = new BreadLoaf();
    BreadLoaf eggBreadLoaf    = new BreadLoaf();
    Ingredient flour  = new Ingredient("flour",300);
    Ingredient yeast = new Ingredient("yeast", 4);
    
public DefaultBreadLoaf(String name){
    
    if(name == butterBreadLoaf.getMenuName()){//name ที่ใส่ตรงกับ input
        butterBreadLoaf.setPanSize(2400);
        butterBreadLoaf.addIngredient(new Ingredient("flour", 313));
        butterBreadLoaf.addIngredient(new Ingredient("yeast", 4));
        butterBreadLoaf.addIngredient(new Ingredient("sugar", 15));
        butterBreadLoaf.addIngredient(new Ingredient("salt", 6));
        butterBreadLoaf.addIngredient(new Ingredient("lukewarmWater", 225));
        butterBreadLoaf.addIngredient(new Ingredient("butter", 17));
    }

    else if(name == chocoBreadLoaf.getMenuName()){
        chocoBreadLoaf.setPanSize(1600);
        chocoBreadLoaf.addIngredient(new Ingredient("flour", 175));
        chocoBreadLoaf.addIngredient(new Ingredient("butter", 175));
        chocoBreadLoaf.addIngredient(new Ingredient("brownSugar", 175));
        chocoBreadLoaf.addIngredient(new Ingredient("meltchoc", 75));
        chocoBreadLoaf.addIngredient(new Ingredient("chopchoc", 75));
        chocoBreadLoaf.addIngredient(new Ingredient("egg", 180));
        chocoBreadLoaf.addIngredient(new Ingredient("cocoapowder", 22.5));
        chocoBreadLoaf.addIngredient(new Ingredient("bakingpowder", 21.6));
    }
    
    else if(name == eggBreadLoaf.getMenuName()){
        chocoBreadLoaf.setPanSize(1600);
        chocoBreadLoaf.addIngredient(new Ingredient("flour", 461));
        chocoBreadLoaf.addIngredient(new Ingredient("butter", 42));
        chocoBreadLoaf.addIngredient(new Ingredient("sugar", 18.4));
        chocoBreadLoaf.addIngredient(new Ingredient("salt", 7.2));
        chocoBreadLoaf.addIngredient(new Ingredient("water", 217));
        chocoBreadLoaf.addIngredient(new Ingredient("egg", 46));
        chocoBreadLoaf.addIngredient(new Ingredient("yeast", 6.9));
    }
}
}