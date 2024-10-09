package com.dungeon_crawler;

import java.util.Scanner;

public final class App {
    static Hero hero = new Hero();
    static HeroService heroService = new HeroService();

    public static void main(String[] args) {
        System.out.println("Welcome to Dungeon Crawler!");
        System.out.println("You are a hero in a dungeon.");
        try(Scanner scan = new Scanner(System.in)) {
            System.out.println("So let's start first with your name.");
            heroService.nameHero(hero, scan.nextLine());
            System.out.println("Now lets roll your stats.");
            Thread.sleep(2000);
            System.out.println("Your stats are: ");
             Thread.sleep(2000);
            hero.printHeroStats();
            System.out.println("You will be given 5 rerolls to change your stats.");
             Thread.sleep(2000);
            System.out.println("You can reroll health, attack, defense, or speed. But every reroll will cost you 1 reroll.");
             Thread.sleep(2000);
            System.out.println("You can also reroll all stats at once.");
             Thread.sleep(2000);
            System.out.println("You can also skip rerolling and continue with your current stats.");
            Thread.sleep(2000);
            System.out.println("Select which stat you would like to reroll, or reroll all stats, or skip rerolling.");
            Thread.sleep(2000);
            System.out.println("Type 'health', 'attack', 'defense', 'speed', 'all', or 'skip'.");
            Thread.sleep(2000);
            heroService.rollStats(hero, scan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
