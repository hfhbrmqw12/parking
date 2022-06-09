package com.CarParking.parking.models.json;

import com.google.gson.annotations.SerializedName;

public class Records {

    @SerializedName("w_reg_inic")
    public String region;

    @SerializedName("w_kuzov")
    public String kuzov;

    @SerializedName("w_model")
    public String model;

    @SerializedName("w_data_pu")
    public String dateWanted;

    @SerializedName("w_vin")
    public String vin;

    @SerializedName("w_god_vyp")
    public String godVyp;

    public String getGodVyp() {
        return godVyp;
    }

    public String getRegion() {
        return region;
    }

    public String getKuzov() {
        return kuzov;
    }

    public String getModel() {
        return model;
    }

    public String getDateWanted() {
        return dateWanted;
    }

    public String getVin() {
        return vin;
    }
}
