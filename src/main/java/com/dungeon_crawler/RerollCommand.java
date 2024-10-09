package com.dungeon_crawler;

public enum RerollCommand {
    HEALTH, ATTACK, DEFENSE, SPEED, ALL, SKIP;

    public static RerollCommand fromString(String command) {
        switch (command.toLowerCase()) {
            case "health":
                return HEALTH;
            case "attack":
                return ATTACK;
            case "defense":
                return DEFENSE;
            case "speed":
                return SPEED;
            case "all":
                return ALL;
            case "skip":
                return SKIP;
            default:
                throw new IllegalArgumentException("Invalid reroll command: " + command);
        }
    }
}
