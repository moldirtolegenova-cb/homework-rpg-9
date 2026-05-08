package com.narxoz.rpg.artifact;
public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;
    @Override public void visit(Weapon w) { 
        totalValue += w.getValue(); }
    @Override public void visit(Potion p) { 
        totalValue += p.getValue(); }
    @Override public void visit(Scroll s) {
         totalValue += s.getValue(); }
    @Override public void visit(Ring r) {
        totalValue += r.getValue(); }
    @Override public void visit(Armor a) {
         totalValue += a.getValue(); }
    public int getTotalValue() { return totalValue; }
}