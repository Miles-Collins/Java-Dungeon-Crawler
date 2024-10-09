package com.dungeon_crawler;

import java.util.Scanner;

public class HeroService {

    public void nameHero(Hero hero, String name) {
        hero.name = name;
        System.out.println("Hero's name is: " + hero.name);
    }

    public void rollStats(Hero hero, Scanner scan) {
        for (int i = 0; i < 5; i++) {
            RerollCommand rerollCommand = getRerollCommand(scan);
            if (rerollCommand == null) {
                i--;
                continue;
            }
            if (rerollCommand == RerollCommand.SKIP) {
                break;
            }
            applyRerollCommand(hero, rerollCommand);
            hero;
        }
        System.out.println("You have finished rolling your stats.");
        System.out.println("Your final stats are: ");
        hero.printHeroStats();
    }

    private RerollCommand getRerollCommand(Scanner scan) {
        String input = scan.nextLine();
        try {
            return RerollCommand.fromString(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command. Please try again.");
            return getRerollCommand(scan);
        }
    }

    private void applyRerollCommand(Hero hero, RerollCommand rerollCommand) {
        switch (rerollCommand) {
            case HEALTH:
                hero.rerollHealth();
                break;
            case ATTACK:
                hero.rerollAttack();
                break;
            case DEFENSE:
                hero.rerollDefense();
                break;
            case SPEED:
                hero.rerollSpeed();
                break;
            case ALL:
                hero.rerollHealth();
                hero.rerollAttack();
                hero.rerollDefense();
                hero.rerollSpeed();
                break;
            case SKIP:
                break;
        }
        hero.printHeroStats();
    }
}
