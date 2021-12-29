package com.example.jeweller;

import java.util.Comparator;

public class Stone {
    private String name;
    private String descripion;
    private int karat;
    private int transPar;
    private int price;
    private int rank;
    private String stoneValue;

    public Stone(String name, String descripion, int karat, int transPar, int price, int rank, String stoneValue) {
        this.name = name;
        this.descripion = descripion;
        this.karat = karat;
        this.transPar = transPar;
        this.price = price;
        this.rank = rank;
        this.stoneValue = stoneValue;
    }

    public Stone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public int getKarat() {
        return karat;
    }

    public void setKarat(int karat) {
        this.karat = karat;
    }

    public int getTransPar() {
        return transPar;
    }

    public void setTransPar(int transPar) {
        this.transPar = transPar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getStoneValue() {
        return stoneValue;
    }

    public void setStoneValue(String stoneValue) {
        this.stoneValue = stoneValue;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "name='" + name + '\'' +
                ", descripion='" + descripion + '\'' +
                ", karat=" + karat +
                ", transPar=" + transPar +
                ", price=" + price +
                ", rank=" + rank +
                ", stoneValue='" + stoneValue + '\'' +
                '}';
    }


}
