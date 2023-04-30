package eksamesprojekt;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BilledeManipulation extends JPanel {
    private static BufferedImage OriginalImage;
    private static BufferedImage DisplayImage;
    private static BufferedImage TempImage;

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


    public static void Blur() {
        float[][] BlurMatrix = {{0,0.2f,0},{0.2f,0.2f,0.2f},{0,0.2f,0}};

    }

    public static void Sharpen() {
        float[][] SharpenMatrix = {{0,-0.2f,0},{-0.2f,-1f,-0.2f},{0,-0.2f,0}};
 
    }

    public static void Lysning() {
        float[][] LysningMatrix = {{0,0.2f,0},{0.2f,0.2f,0.2f},{0,0.2f,0}};
 
    }
    
   public static void ApplyMatrix(float[][] matrix) {
	   TempImage = copyImage(OriginalImage);
	    int width = TempImage.getWidth();
	    int height = TempImage.getHeight();   
	   
	    for(int y = 0; y < height; y++) {
	        for(int x = 0; x < width; x++) {
	            int pixel = TempImage.getRGB(x, y);

	            int alpha = (pixel>>24)&0xff;
	            int red = (pixel>>16)&0xff;
	            int green = (pixel>>8)&0xff;
	            int blue = pixel&0xff;

	            //Apply matrix to each color component separately
	            red = (int)(red*matrix[0][0] + green*matrix[0][1] + blue*matrix[0][2]);
	            green = (int)(red*matrix[1][0] + green*matrix[1][1] + blue*matrix[1][2]);
	            blue = (int)(red*matrix[2][0] + green*matrix[2][1] + blue*matrix[2][2]);

	            //clamp values to [0, 255]
	            red = Math.min(255, Math.max(0, red));
	            green = Math.min(255, Math.max(0, green));
	            blue = Math.min(255, Math.max(0, blue));

	            //Combine color components back into a single pixel
	            int newPixel = (alpha<<24) | (red<<16) | (green<<8) | blue;
	            TempImage.setRGB(x, y, newPixel);
	        }
	    }

	    DisplayImage = TempImage;
   } 
    
} 