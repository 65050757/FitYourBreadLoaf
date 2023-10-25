import java.util.*;
public class Convertor {
    private final static String INGREDIENT_NAME = "dough";

    private BreadLoaf menu;
    private int magicnumber;
    private double userPanSize; //volumn in milliliter

    Convertor(BreadLoaf menu){
        this.menu = menu;
        findMagicNumber(menu);
        calculateIngredient(menu);
    }

    private boolean ispanSizeEqual(double userPanSize,double defaultPanszie){
        return (userPanSize == defaultPanszie)? true:false;
    }

    private void findMagicNumber(BreadLoaf menu){
        //fillter menu from ingredients in loafbread that have a name DOUGH
    }

    // public BreadLoaf calculateIngredient(BreadLoaf menu){
    //     BreadLoaf usermenu;
    //     if(ispanSizeEqual(userPanSize, menu.getPanSize())){
    //         return menu;
    //     }
    //     else{
    //         usermenu = new BreadLoaf();
    //         ingredientslist = menu.getIngredients;
    //         for(Ingredient i : menu.getIngredients()){
    //             //i.getQuantity() = quantity / ;
    //         }
    //     }
    //     return usermenu;
    // }


}
