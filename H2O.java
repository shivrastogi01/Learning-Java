class H2O {
    private int cntH;
    
    public H2O() {
        cntH = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized(this) {
            while (cntH == 2) {
                wait();
            }
            releaseHydrogen.run();
            ++cntH;
            notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized(this) {
            while (cntH != 2) {
                wait();
            }
            releaseOxygen.run();
            cntH -= 2;
            notifyAll();
        }
    }
}