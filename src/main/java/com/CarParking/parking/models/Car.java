package com.CarParking.parking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comment;
    private String carNumber;
    private String carModel;
    private String carColor;
    private Integer parkingNumber;
    private String parkingTimeStart;
    private String parkingTimeEnd;
    private Double parkingSum;
    private Boolean parkingPaid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Integer getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(Integer parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public String getParkingTimeStart() {
        return parkingTimeStart;
    }

    public void setParkingTimeStart(String parkingTimeStart) {
        this.parkingTimeStart = parkingTimeStart;
    }

    public String getParkingTimeEnd() {
        return parkingTimeEnd;
    }

    public void setParkingTimeEnd(String parkingTimeEnd) {
        this.parkingTimeEnd = parkingTimeEnd;
    }

    public Double getParkingSum() {
        return parkingSum;
    }

    public void setParkingSum(Double parkingSum) {
        this.parkingSum = parkingSum;
    }

    public Boolean getParkingPaid() {
        return parkingPaid;
    }

    public void setParkingPaid(Boolean parkingPaid) {
        this.parkingPaid = parkingPaid;
    }

    public Car() {
    }

    public Car(String comment, String carNumber, String carModel, String carColor, Integer parkingNumber, String parkingTimeStart, String parkingTimeEnd, Double parkingSum, Boolean parkingPaid) {
        this.comment = comment;
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.carColor = carColor;
        this.parkingNumber = parkingNumber;
        this.parkingTimeStart = parkingTimeStart;
        this.parkingTimeEnd = parkingTimeEnd;
        this.parkingSum = parkingSum;
        this.parkingPaid = parkingPaid;
    }
}
