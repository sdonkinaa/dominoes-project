public class DominoeChip {
    
    private int leftChip;
    private int rightChip;
    public DominoeChip(int leftChip, int rightChip) {
        this.leftChip = leftChip;
        this.rightChip = rightChip;
    }
    public int getLeftChip() {
        return leftChip;
    }
    public void setLeftChip(int leftChip) {
        this.leftChip = leftChip;
    }
    public int getRightChip() {
        return rightChip;
    }
    public void setRightChip(int rightChip) {
        this.rightChip = rightChip;
    }
    @Override
    public String toString() {
        return "DominoeChip [leftChip=" + leftChip + ", rightChip=" + rightChip + "]";
    }

    


}
