package com.dungeon_crawler;

public class Hero {
    String name;
    int health = (int) (Math.random() * 100);
    int attack = (int) (Math.random() * 10);
    int defense = (int) (Math.random() * 10);
    int speed = (int) (Math.random() * 10);
    String[] randomMalePrefix = {"Sir", "Lord", "King", "Prince", "Duke", "Baron", "Count", "Emperor", "Master", "Knight"};
    String[] randomFemalePrefix = {"Lady", "Queen", "Princess", "Duchess", "Baroness", "Countess", "Empress", "Mistress", "Knightess"};

    public void rerollHealth() {
        health = (int) (Math.random() * 100);
    }

    public void rerollAttack() {
        attack = (int) (Math.random() * 10);
    }

    public void rerollDefense() {
        defense = (int) (Math.random() * 10);
    }

    public void rerollSpeed() {
        speed = (int) (Math.random() * 10);
    }

    public void printHeroStats() {
        printWithRolling("Name: " + name);
        printWithRolling("Health: " + health);
        printWithRolling("Attack: " + attack);
        printWithRolling("Defense: " + defense);
        printWithRolling("Speed: " + speed);
    }

    private void printWithRolling(String message) {
        int rollingTime = 2000; // Total rolling time in milliseconds
        int interval = 500; // Interval between "Rolling..." messages in milliseconds
        int elapsed = 0;

        while (elapsed < rollingTime) {
            System.out.print("Rolling");
            for (int i = 0; i < 3; i++) {
                if (elapsed >= rollingTime) break;
                System.out.print(".");
                try {
                    Thread.sleep(interval / 3);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted, Failed to complete operation");
                    return;
                }
                elapsed += interval / 3;
            }
            System.out.print("\r"); // Carriage return to overwrite the line
        }
        System.out.println(message);
    }
}
