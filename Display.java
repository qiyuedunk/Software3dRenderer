import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferByte;
import javax.swing.JFrame;

public class Display extends Canvas {

    private int mWidth;
    private int mHeight;
    private JFrame mFrame;
    private BufferStrategy mBufferStrategy;
    private Graphics mGraphics;
    private byte[] mDisplayComponents;
    private BufferedImage  mDisplayImage;
    private Bitmap mFrameBuffer;

    public Display(int width, int height, String title) {
        this.mWidth = width;
        this.mHeight = height;
        this.InitWindow(title);
        this.InitCanvas()
    }

    private void InitWindow(String title) {
        Dimension size = new Dimension(mWidth, mHeight);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        mFrame = new JFrame();
        mFrame.add(this);
        mFrame.pack();
        mFrame.setResizable(false);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setLocationRelativeTo(null);
        mFrame.setTitle(title);
        mFrame.setSize(mWidth, mHeight);
        mFrame.setVisible(true);
        setFocusable(true);
        requestFocus();
    }

    private void InitCanvas() {
        createBufferStrategy(1);
        mBufferStrategy = getBufferStrategy();
        mGraphics = mBufferStrategy.getDrawGraphics();
        mDisplayImage = BufferedImage(mWidth, mHeight, BufferedImage.TYPE_3BYTE_BGR);
        mDisplayComponents = ((DataBufferByte)(mDisplayImage.getRaster().getDataBuffer())).getData();
        mFrameBuffer =  new Bitmap(mWidth, mHeight);
    }

    public void SwapBuffer() {
        mContext.copyToBuffer(mDisplayComponents)
        mGraphics.drawImage(mDisplayImage, 0, 0, 
            mFrameBuffer.getWidth(), mFrameBuffer.getHeight(), null);
    }
}   