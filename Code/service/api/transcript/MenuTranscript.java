package service.api.transcript;


import com.google.gson.annotations.SerializedName;

import service.api.bread.BreadAPI;

import java.util.*;

public class MenuTranscript {
    @SerializedName("results")
    private List<BreadAPI> breadAPIList;

    // Getter and setter for 'BreadAPIList'

    public List<BreadAPI> getBreadAPIList() {
        return breadAPIList;
    }

    public void setBreadAPIList(List<BreadAPI> BreadAPIList) {
        this.breadAPIList = BreadAPIList;
    }

    public HashMap<String, BreadAPI> getBreadMap() {
        HashMap<String, BreadAPI> breadMap = new HashMap<>();
        
        for (BreadAPI bread : breadAPIList) {
            breadMap.put(bread.getTitle(), bread);
        }

        return breadMap;
    }




    
}