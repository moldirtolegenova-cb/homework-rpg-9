package com.narxoz.rpg.artifact;
public class CurseDetector implements ArtifactVisitor {
    
    private int cursesFound = 0;

    @Override
    public void visit(Weapon weapon) { checkCurse(weapon); }

    @Override
    public void visit(Potion potion) { checkCurse(potion); }

    @Override
    public void visit(Scroll scroll) { checkCurse(scroll); }

    @Override
    public void visit(Ring ring) { checkCurse(ring); }

    @Override
    public void visit(Armor armor) { checkCurse(armor); }

    private void checkCurse(Artifact artifact) {
        if (artifact.getName().toLowerCase().contains("cursed")) {
            System.out.println("[WARNING] Dark magic detected: " + artifact.getName() + " is cursed!");
            cursesFound++;
        }
    }

    public int getCursesFound() {
        return cursesFound;
    }
}