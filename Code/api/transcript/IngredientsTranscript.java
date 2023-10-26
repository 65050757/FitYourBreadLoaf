package api.transcript;
import com.google.gson.annotations.SerializedName;

import api.bread.IngredientAPI;

import java.util.*;

public class IngredientsTranscript {
    @SerializedName("extendedIngredients")
    private List<IngredientAPI> ingredientList;

    public List<IngredientAPI> getIngredientList() {
        return ingredientList;
    }
}
