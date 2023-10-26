package api;

import java.util.*;

import api.bread.*;
import api.transcript.*;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

//this class call spooacularAPI
public class ApiCaller {
    final static String APIKEY = "08d4c22276484528954fcbd64447ccd6";
    
    HttpRequest getRequest;
    HttpClient httpClient;
    HttpResponse<String> getResponse;
    Gson gson;

    List<BreadAPI> menuList;
    HashMap<String, BreadAPI> breadMap;

    public ApiCaller() throws Exception{
        gson = new Gson();
        httpClient = HttpClient.newHttpClient();
        importMenuName();
    }

    private void importMenuName() throws Exception{
        MenuTranscript transcript;
        String apiURL = "https://api.spoonacular.com/recipes/complexSearch?apiKey=08d4c22276484528954fcbd64447ccd6&query=bread&equipment=loafpan";
        

        getRequest = (HttpRequest) HttpRequest.newBuilder()
        .uri(new URI(apiURL))
        .header("apiKey",APIKEY)
        .build();

        getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
        transcript = gson.fromJson(getResponse.body(), MenuTranscript.class);

        menuList = transcript.getBreadAPIList();

        breadMap = transcript.getBreadMap();

        //System.out.print(menuList);
    }
    public List<IngredientAPI> importIngredientsbyId(String id) throws Exception{
        String apiURL = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=08d4c22276484528954fcbd64447ccd6";
        IngredientsTranscript transcript = new IngredientsTranscript();
        List<IngredientAPI> ingredientsList;

        getRequest = (HttpRequest) HttpRequest.newBuilder()
        .uri(new URI(apiURL))
        .header("apiKey",APIKEY)
        .build(); 

        getResponse = httpClient.send(getRequest, BodyHandlers.ofString());

        transcript = gson.fromJson(getResponse.body(), IngredientsTranscript.class);
        ingredientsList = transcript.getIngredientList();
    
        return ingredientsList;
    }
    public String importProcess(String id) throws Exception{
        String apiURL = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=08d4c22276484528954fcbd64447ccd6";
        ProcessTranscript transcript = new ProcessTranscript();

        getRequest = (HttpRequest) HttpRequest.newBuilder()
        .uri(new URI(apiURL))
        .header("apiKey",APIKEY)
        .build(); 
        

        getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
        transcript = gson.fromJson(getResponse.body(), ProcessTranscript.class);
        
       
        return transcript.getInstructions();
        
        //System.out.println(transcript.getInstructions());
    }

    public List<BreadAPI> getMenuList() {
        return menuList;
    }
    public HashMap<String, BreadAPI> getBreadMap() {
        return breadMap;
    }
}
