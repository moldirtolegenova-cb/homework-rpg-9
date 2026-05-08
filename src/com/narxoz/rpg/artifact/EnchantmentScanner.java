package com.narxoz.rpg.artifact;
    public class EnchantmentScanner implements ArtifactVisitor {
    @Override public void visit(Weapon w) { 
        System.out.println("Weapon: " + w.getName() + " (+ " + w.getAttackBonus() + " Atk)"); }
    @Override public void visit(Potion p) { 
        System.out.println("Potion: " + p.getName() + " (Restores " + p.getHealing() + " HP)"); }
    @Override public void visit(Scroll s) {
        System.out.println("Scroll: " + s.getName() + " (Spell: " + s.getSpellName() + ")"); }
    @Override public void visit(Ring r) {
         System.out.println("Ring: " + r.getName() + " (Magic: +" + r.getMagicBonus() + ")"); }
    @Override public void visit(Armor a) {
        System.out.println("Armor: " + a.getName() + " (Def: +" + a.getDefenseBonus() + ")"); }
}
