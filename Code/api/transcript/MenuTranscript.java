package api.transcript;


import com.google.gson.annotations.SerializedName;

import api.bread.BreadAPI;

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
        // สร้าง HashMap เพื่อเก็บข้อมูลแบบ <id, Bread>
        HashMap<String, BreadAPI> breadMap = new HashMap<>();

        // นำข้อมูลจาก breadList และเก็บลงใน HashMap
        for (BreadAPI bread : breadAPIList) {
            breadMap.put(bread.getTitle(), bread);
        }

        return breadMap;
    }




    
}