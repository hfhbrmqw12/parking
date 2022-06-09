package com.CarParking.parking.models.json;

import com.google.gson.annotations.SerializedName;

public class Wanted {

    @SerializedName("RequestResult")
    public RequestResult requestResult;

    @SerializedName("requestTime")
    public String requestTime;

    @SerializedName("status")
    public String status;

    @SerializedName("code")
    public String code;

    @SerializedName("message")
    public String message;

    @SerializedName("vin")
    public String vin;

    public RequestResult getRequestResult() {
        return requestResult;
    }

    public String getVin() {
        return vin;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
