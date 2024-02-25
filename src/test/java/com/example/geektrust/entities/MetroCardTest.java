package com.example.geektrust.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MetroCardTest {

    @Test
    public void testCreateMetroCard() {
        MetroCard card = new MetroCard("123456789", 100);
        assertNotNull(card);
    }

    @Test
    public void testCreateMetroCardWithNegativeBalance() {
        MetroCard card = new MetroCard("123456789", -100);
        assertEquals(-100, card.getBalance());
    }

    @Test
    public void testRecharge() {
        MetroCard card = new MetroCard("123456789", 100);
        card.recharge(50);
        assertEquals(150, card.getBalance());
    }

    @Test
    public void testDeductSufficientBalance() {
        MetroCard card = new MetroCard("987654321", 100);
        card.deduct(50);
        assertEquals(50, card.getBalance());
    }

    @Test
    public void testDeductInsufficientBalance() {
        MetroCard card = new MetroCard("987654321", 30);
        card.deduct(50);
        assertEquals(-20, card.getBalance());
    }

}
