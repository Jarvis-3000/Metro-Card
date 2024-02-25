package com.example.geektrust.entities;

public class MetroCard {
   private String cardNumber;
   private int balance;

   public void recharge(int amount) {
      this.balance += amount;
   }

   public void deduct(int amount) {
      this.balance -= amount;
   }

   public String getCardNumber() {
      return this.cardNumber;
   }

   public int getBalance() {
      return this.balance;
   }

   public MetroCard(String cardNumber, int balance) {
      this.cardNumber = cardNumber;
      this.balance = balance;
   }
}
