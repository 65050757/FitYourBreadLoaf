package service;
import java.util.*;
public class Convertor {
    private BreadLoaf defalutmenu,usermenu;
    
    private ArrayList<Ingredient> ingredientsList;

    private double userPanSize; //volumn in milliliter

    private ArrayList<Ingredient> outputList;

    public Convertor(BreadLoaf menu){
        defalutmenu = menu;
    }
    

    private boolean ispanSizeEqual(double userPanSize,double defaultPanszie){
        return (userPanSize == defaultPanszie)? true:false;
    }

    public BreadLoaf calculateIngredient(double userPanSize){
        
        int doughQuantity = 0;
        double sumPercent = 0;
        double percent = 0;
        double flourPercent = defalutmenu.getIngredients().get(0).getQuantity();
        double loafRatio = 0;
        int doughCalculate = 0;
        
        if(ispanSizeEqual(userPanSize, defalutmenu.getPanSize())){
            usermenu = defalutmenu;
        }

        else{
            usermenu = new BreadLoaf();
            usermenu.setMenuName(defalutmenu.getMenuName());
            usermenu.setPanSize(userPanSize);
            usermenu.setProcess("Depented ou you... Luckily!!");
            
            ingredientsList = (ArrayList<Ingredient>) defalutmenu.getIngredients();
            outputList = new ArrayList<>(ingredientsList);
            
            int n = 0;
            for(Ingredient i : defalutmenu.getIngredients()){
                doughQuantity += i.getQuantity(); 
                percent = i.getQuantity()/flourPercent * 100;
                //percentList.add(percent);
                sumPercent += percent;
                loafRatio = defalutmenu.getPanSize()/doughQuantity;
                doughCalculate = (int)(userPanSize/loafRatio);

                double newQuantity = (doughCalculate/sumPercent)*percent;
                outputList.get(n).setQuantity(newQuantity);
                n++;
            }
            
            usermenu.setIngredients(outputList);
            
        }
        return usermenu;
    }

    public double getUserPanSize() {
        return userPanSize;
    }

    public void setUserPanSize(double userPanSize) {
        this.userPanSize = userPanSize;
    }
}
