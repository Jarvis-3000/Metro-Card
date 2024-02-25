package com.example.geektrust.entities;

public class StationCollection {
  private int totalCollection = 0;
  private int totalDiscount = 0;

  public void addCollection(int collection) {
    this.totalCollection += collection;
  }

  public void addDiscount(int disocunt) {
    this.totalDiscount += disocunt;
  }

  public int getTotalCollection() {
    return this.totalCollection;
  }

  public int getTotalDiscount() {
    return this.totalDiscount;
  }

  public StationCollection(int totalCollection, int totalDiscount) {
    this.totalCollection = totalCollection;
    this.totalDiscount = totalDiscount;
  }

  public StationCollection(){

  }
}
