package com.ejercicios.vector;

public class CompanyPackage {
    private int idPackage;
    private int weight;

    public CompanyPackage(int idPackage, int weight) {
        this.idPackage = idPackage;
        this.weight = weight;
    }

    public int getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(int idPackage) {
        this.idPackage = idPackage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
