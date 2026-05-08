package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.GoldAppraiser;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        int mementosCreated = 0;
        int restoredCount = 0;
        int artifactsAppraised = 0;
        Caretaker caretaker = new Caretaker();

        for (Hero hero : party) {
            System.out.println("\n--- " + hero.getName() + " enters the Vault ---");
            
            caretaker.save(hero.createMemento());
            mementosCreated++;

            GoldAppraiser appraiser = new GoldAppraiser();
            hero.getInventory().accept(appraiser);
            artifactsAppraised += hero.getInventory().size();
            System.out.println("Inventory Value: " + appraiser.getTotalValue() + "g");

            System.out.println("A temporal trap explodes!");
            hero.takeDamage(50);
            hero.spendGold(100);
            System.out.println("Post-trap state: " + hero);

            System.out.println("[Chronos] Activating Time Crystal... Rewinding time!");
            hero.restoreFromMemento(caretaker.undo());
            restoredCount++;
        
            System.out.println("Restored state:  " + hero);
        }

        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}