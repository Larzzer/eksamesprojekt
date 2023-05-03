package eksamesprojekt;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BilledeManipulation extends JPanel {
	private BufferedImage OriginalImage;
	private BufferedImage DisplayImage;

	
	public final static float[][] BlurMatrix = new float[][] {{0,0.2f,0},{0.2f,0.2f,0.2f},{0,0.2f,0}};
	
	public final static float[][] SharpenMatrix = new float[][] {{0,-0.2f,0},{-0.2f,-1f,-0.2f},{0,-0.2f,0}};
	
	public final static float[][] LysningMatrix = new float[][] {{0,0.2f,0},{0.2f,0.2f,0.2f},{0,0.2f,0}};
	
    public BilledeManipulation() {
       try {                
    	   OriginalImage = ImageIO.read(new File("C:\\Users\\lars\\OneDrive\\Desktop\\Kom IT reklame\\umar_der_ser_sød_ud.jpg"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(OriginalImage,0,0, this.getWidth(), this.getHeight(), this); // see javadoc for more info on the parameters            
    }

    //Stackoverflow (https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage) How do you clone a bufferedimage?
    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }
    
    
    public void Blur() {
    	ApplyMatrix(BlurMatrix);
    }
    
    public void Sharpen() {
    	ApplyMatrix(BlurMatrix);
    }
    
    public void Lysning() {
    	ApplyMatrix(BlurMatrix);
    }

    
    public void ApplyMatrix(float[][] filter) {
        BufferedImage TempImage;

        TempImage = copyImage(OriginalImage);
        int width = TempImage.getWidth();
        int height = TempImage.getHeight();

        float[][] output = new float[width][height];
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                float sumR = 0, sumG = 0, sumB = 0;
                for (int j = -1; j <= 1; j++) {
                    for (int i = -1; i <= 1; i++) {
                        int pixel = TempImage.getRGB(x + i, y + j);

                        float factor = filter[i + 1][j + 1];
                        sumR += factor * ((pixel >> 16) & 0xff);
                        sumG += factor * ((pixel >> 8) & 0xff);
                        sumB += factor * (pixel & 0xff);
                    }
                }
                int newPixel = ((int) sumR << 16) | ((int) sumG << 8) | (int) sumB;
                TempImage.setRGB(x, y, newPixel);
            }
        }
        DisplayImage = copyImage(TempImage);
        repaint();
    }
}