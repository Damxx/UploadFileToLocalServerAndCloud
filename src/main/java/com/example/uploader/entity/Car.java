package com.example.uploader.entity;

import java.util.Objects;

public class Car {
    private String marka;
    private String model;
    private int rok;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return rok == car.rok &&
                Objects.equals(marka, car.marka) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, model, rok);
    }
    public Car(){};
    public Car(String marka, String model, int rok) {
        this.marka = marka;
        this.model = model;
        this.rok = rok;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rok=" + rok +
                '}';
    }
}
