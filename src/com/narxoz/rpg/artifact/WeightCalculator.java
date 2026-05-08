package com.narxoz.rpg.artifact;
public class WeightCalculator implements ArtifactVisitor {
    private int totalWeight = 0;
    @Override public void visit(Weapon w) { totalWeight += w.getWeight(); }
    @Override public void visit(Potion p) { totalWeight += p.getWeight(); }
    @Override public void visit(Scroll s) { totalWeight += s.getWeight(); }
    @Override public void visit(Ring r) { totalWeight += r.getWeight(); }
    @Override public void visit(Armor a) { totalWeight += a.getWeight(); }
    public int getTotalWeight() { return totalWeight; }
}