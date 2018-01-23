package core;

public class FrameCounter {
    private int count;
    private int max;

    public FrameCounter(int max) {
        this.max = max;
        this.count = 0;
    }

    public boolean run() {
        if (this.count == this.max){
            return true;
        } else {
            this.count += 1;
            return false;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
