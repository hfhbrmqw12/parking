package com.CarParking.parking.models.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestResult {

    @SerializedName("records")
    public List<Records> records;
    @SerializedName("count")
    public String count;
    @SerializedName("error")
    public String error;

    public String getCount() {
        return count;
    }

    public String getError() {
        return error;
    }

    public List<Records> getRecords() {
        return records;
    }

}
