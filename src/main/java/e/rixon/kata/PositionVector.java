package e.rixon.kata;

class PositionVector {
    private final int xModifier;
    private final int yModifier;

    PositionVector(int xModifier, int yModifier) {
        this.xModifier = xModifier;
        this.yModifier = yModifier;
    }

    public int getxModifier() {
        return xModifier;
    }

    public int getyModifier() {
        return yModifier;
    }
}
