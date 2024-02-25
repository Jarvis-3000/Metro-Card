package com.example.geektrust.entities;

import com.example.geektrust.enums.PassengerType;

public class PassengerTypeCount implements Comparable<PassengerTypeCount> {
   private PassengerType passengerType;
   private int count;

   public PassengerType getPassengerType() {
      return this.passengerType;
   }

   public int getCount() {
      return this.count;
   }

   public PassengerTypeCount(PassengerType passengerType, int count) {
      this.passengerType = passengerType;
      this.count = count;
   }

   // descending order
   @Override
   public int compareTo(PassengerTypeCount other) {
      // first compare by counts by descending order
      int countComparison = Integer.compare(other.getCount(), this.getCount());

      if (countComparison != 0) {
         return countComparison;
      }

      // If counts are the same, compare by passengerType in lexicographic order
        return this.passengerType.compareTo(other.passengerType);
   }
}
