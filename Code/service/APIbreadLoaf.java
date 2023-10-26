package service;

import java.util.*;

import service.api.*;
import service.api.bread.*;

public class APIbreadLoaf{
    private final static double PANSIZE = 1600; //Unit:milliliter 

    private ApiCaller importTool; 

    private BreadLoaf bread;
    private String inputMenu;

    public APIbreadLoaf() throws Exception{
        importTool = new ApiCaller();
    }
 
    public void makeABreadLoaf(String name) throws Exception{
        bread = new BreadLoaf();
        // putBreadLOAFName(name);
        // putIngredients(name);
        // putProcess(name);

        Thread breadThread = new Thread(() -> {
            this.putBreadLOAFName(name);
            try {
                this.putProcess(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.putIngredients(name);
            this.putPanSize();
        });

        breadThread.start();

        try {
            breadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }


    private void putIngredients(String name) {
        List<IngredientAPI> ingredientAPIlist = new ArrayList<>();
        String id = importTool.getBreadMap().get(name).getId();


        bread.setIngredients(new ArrayList<>());

        try {
            ingredientAPIlist = importTool.importIngredientsbyId(id);
        } catch (Exception e) {
            System.out.println("From input Ingredients haev an error");
            e.printStackTrace();
        }
        for(IngredientAPI ingredient : ingredientAPIlist){
            bread.addIngredient(new Ingredient(ingredient.getName(), ingredient.getAmount()));
        }
        
    
        int index = findflourIndex();
        Collections.swap(bread.getIngredients(),0,index);        
    }

    private int findflourIndex() {
        int index = 0;

        for (int i = 0; i < bread.getIngredients().size(); i++) {
            if (bread.getIngredients().get(i).getName().equals("flour")) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void putBreadLOAFName(String name){
        String breadLOAFName = name;
        bread.setMenuName(breadLOAFName);
   }

    private void putProcess(String name) throws Exception{
        String id = importTool.getBreadMap().get(name).getId();
        String process = importTool.importProcess(id);
        bread.setProcess(process);
    }

    private void putPanSize(){
        bread.setPanSize(PANSIZE);
    }   
    
   public ApiCaller getImportTool() {
       return importTool;
   }
   public BreadLoaf getBread(){
        return bread;
    }

    public String getInputMenu() {
        return inputMenu;
    }

    public void setInputMenu(String inputMenu) {
        this.inputMenu = inputMenu;
    }
}
