package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Chronomancer's Vault ===");

        Hero alaric = new Hero("Alaric the Bold", 100, 20, 50, 10, 500, new Inventory());
        Hero elara = new Hero("Elara the Wise", 70, 100, 10, 5, 200, new Inventory());

        alaric.getInventory().addArtifact(new Weapon("Excalibur", 1000, 15, 50));
        alaric.getInventory().addArtifact(new Armor("Dragon Scale", 800, 30, 40));
        elara.getInventory().addArtifact(new Potion("Mana Draught", 50, 1, 30));
        elara.getInventory().addArtifact(new Scroll("Fireball", 150, 1, "Inferno"));
        elara.getInventory().addArtifact(new Ring("Cursed Band", 5, 1, -5)); 

        System.out.println("\n--- Initial Appraisal ---");
        ArtifactVisitor scanner = new EnchantmentScanner();
        alaric.getInventory().accept(scanner);
        elara.getInventory().accept(scanner);

        System.out.println("\n--- Curse Detection ---");
        ArtifactVisitor curseDetector = new CurseDetector();
        alaric.getInventory().accept(curseDetector);
        elara.getInventory().accept(curseDetector);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(alaric, elara));

        System.out.println("\n--- Post-Vault Weight Check (Open/Closed Proof) ---");
        WeightCalculator weightCalc = new WeightCalculator();
        alaric.getInventory().accept(weightCalc);
        System.out.println(alaric.getName() + "'s total burden: " + weightCalc.getTotalWeight() + " units.");

       
        System.out.println("\n--- Vault Run Summary ---");
        System.out.println(result);
    }
}