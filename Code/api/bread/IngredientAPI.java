package api.bread;

import com.google.gson.annotations.SerializedName;

public class IngredientAPI {
    @SerializedName("name")
    private String name;
    @SerializedName("measures")
    private Measures measures;

    private class Measures {
        @SerializedName("metric")
        private Metric metric;
    }

    private class Metric {
        @SerializedName("amount")
        private double amount;
        @SerializedName("unitShort")
        private String unitShort;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return measures.metric.amount;
    }

    public String getUnit() {
        return measures.metric.unitShort;
    }

    
}
