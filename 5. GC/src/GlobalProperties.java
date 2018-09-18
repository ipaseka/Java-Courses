public class GlobalProperties implements GlobalPropertiesMBean {
    private int size = 0;
    private boolean saveGlobal = false;
    private int sleepTime = 0;
    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setSaveGlobal(boolean saveGlobal) {
        this.saveGlobal = saveGlobal;
    }

    @Override
    public int getSleepTime() {
        return sleepTime;
    }

    @Override
    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public boolean getSaveGlobal() {
        return saveGlobal;
    }

    @Override
    public int getSize() {
        return size;
    }
}
