package edu.uci.swe264p.retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TopRatedResponse {
    @SerializedName("results")
    private List<JsonObject> result;

    public TopRatedResponse(List<JsonObject> result) {
        this.result = result;
    }


    public List<JsonObject> getResult() { return result;}

}