public class Bitmap {
    private int mWidth;
    private int mHeight;
    private byte[] mComponents;

    public Bitmap(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
        this.mComponents = new int[width * height * 4];
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public void copyToBuffer(byte[] buffer) {
        for(int i=0; i<mWidth * mHeight; i++) {
            buffer[3 * i] = mComponents[4 * i + 1];
            buffer[3 * i + 1] = mComponents[4 * i + 2];
            buffer[3 * i + 2] = mComponents[4 * i + 3];
        }
    }
}