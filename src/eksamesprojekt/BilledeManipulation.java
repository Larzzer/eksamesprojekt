package eksamesprojekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


// Pictures	
public class BilledeManipulation extends JPanel {
	private BufferedImage OriginalImage;
	private BufferedImage DisplayImage;
	private static BufferedImage TempImage;

	//Matrix fliters, how they are calculeted for each filter.
	public final static float[][] BlurMatrix = new float[][] {{0,0.2f,0},{0.2f,0.2f,0.2f},{0,0.2f,0}};
	
	public final static float[][] SharpenMatrix = new float[][] {{0,-1f,0},{-1f,5f,-1f},{0f,-1f,0}};
	
	public final static float[][] LysningMatrix = new float[][] {{0,0.2f,0},{0.2f,0.4f,0.2f},{0,0.2f,0}};
	
	// Loading pictures from files, through C:\\
    public BilledeManipulation() {
       try {                
    	   OriginalImage = ImageIO.read(new File("C:\\Users\\lars\\OneDrive\\Desktop\\Programmering eksamensbillede\\frog-1280x720.png"));
    	   DisplayImage = OriginalImage;
       } catch (IOException ex) {
            // handle exception...
       }
    }

    //This method is used to draw the panel and its contents, and in this case, it is used to display an image on the panel. 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(DisplayImage,0,0, this.getWidth(), this.getHeight(), this); // see javadoc for more info on the parameters            
    }

    //Explained: the copyImage() method creates a copy of a BufferedImage object by creating a new image with the same dimensions and, 
    //image type as the original, drawing the contents of the original onto the new image, and returning the new image.
    //Stackoverflow (https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage) How do you clone a bufferedimage?
//    public static BufferedImage copyImage(BufferedImage source){
//        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
//        Graphics g = b.getGraphics();
//        g.drawImage(source, 0, 0, null);
//        g.dispose();
//        return b;
//    }
    
    public static BufferedImage copyImage(BufferedImage source){
    	TempImage = source;
        return TempImage;
    }
    
    public void Blur()
    {
    	DisplayImage = copyImage(Blur(DisplayImage));
    	repaint();

    }
    
    public void Lysning()
    {
    	DisplayImage = copyImage(Lysning(DisplayImage));
    	repaint();
    	
    }
    
    public void Sharpen()
    {
    	DisplayImage = copyImage(Sharpen(DisplayImage));
    	repaint();
    	
    }
    
    public void Grayscale()
    {
    	DisplayImage = copyImage(toGrayScale(DisplayImage));
    	repaint();
    	
    }
    
    public void Reset()
    {
    	DisplayImage = OriginalImage;
    	repaint();
    	
    }
    
    public void RedScale()
    {
    	DisplayImage = copyImage(ToRedScale(DisplayImage));
    	repaint();
   
    }
  
    public void BlueScale()
    {
    	DisplayImage = copyImage(ToBlueScale(DisplayImage));
    	repaint();
   
    }
    
    public void GreenScale()
    {
    	DisplayImage = copyImage(ToGreenScale(DisplayImage));
    	repaint();
   
    }
    
    
    
    //Applies Matrix code from the start
    public static BufferedImage Blur(BufferedImage image) {
    	return ApplyMatrix(image, BlurMatrix);
    }
    
    public static BufferedImage Sharpen(BufferedImage image) {
    	return ApplyMatrix(image, SharpenMatrix);
    }
    
    public static BufferedImage Lysning(BufferedImage image) {
    	return ApplyMatrix(image, LysningMatrix);
    }
    
    
   
    // https://www.youtube.com/watch?v=gp9H0WLxKgU
    public static BufferedImage toGrayScale (BufferedImage img) {
		BufferedImage grayImage = new BufferedImage(
			img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = grayImage.getGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		return grayImage;
	}
    // https://www.youtube.com/watch?v=gp9H0WLxKgU
   public static BufferedImage ToRedScale (BufferedImage img) {
	   BufferedImage redImage = new BufferedImage(
				img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
	   Graphics gr = redImage.getGraphics();
	   for (int y = 0; y < redImage.getHeight(); y++) 
	    {
	        for (int x = 0; x < redImage.getWidth(); x++)
	        {
	        	
	        	int[] color = getPixelValue(img,x, y);
	        	int red = color[0];
	           
	        	int redScale = getIntColor(red, 0, 0);
	        	redImage.setRGB(x, y, redScale);
	        }
	    }
	   
	   return redImage;
   }
    
   public static BufferedImage ToBlueScale (BufferedImage img) {
	   BufferedImage blueImage = new BufferedImage(
				img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
	   Graphics g = blueImage.getGraphics();
	   for (int y = 0; y < blueImage.getHeight(); y++) 
	    {
	        for (int x = 0; x < blueImage.getWidth(); x++)
	        {
	        	
	        	int[] color = getPixelValue(img,x, y);
	        	int Blue = color[2];
	           
	        	int BlueScale = getIntColor(0, 0, Blue);
	        	blueImage.setRGB(x, y, BlueScale);
	        }
	    }
	   
	   return blueImage;
   }
   
   public static BufferedImage ToGreenScale (BufferedImage img) {
	   BufferedImage GreenImage = new BufferedImage(
				img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
	   Graphics g = GreenImage.getGraphics();
	   for (int y = 0; y < GreenImage.getHeight(); y++) 
	    {
	        for (int x = 0; x < GreenImage.getWidth(); x++)
	        {
	        	
	        	int[] color = getPixelValue(img,x, y);
	        	int Green = color[1];
	           
	        	int GreenScale = getIntColor(0, Green, 0);
	        	GreenImage.setRGB(x, y, GreenScale);
	        }
	    }
	   
	   return GreenImage;
   }
   
    
    
// This code applies a filter matrix to an image by iterating over each pixel and multiplying it by the corresponding value in the filter matrix. 
// The resulting values are then used to set the RGB values of the pixels in a new image, which is displayed. 
// The getPixelValue method is used to get the grayscale value of a pixel.
    
    
//This code applies a 3x3 matrix filter to an image. The method takes a 2D array of float values as input which represents the filter matrix. 
//The method first creates a copy of the original image and then loops through each pixel of the image (except for the edges, --
//where the filter matrix cannot be applied). For each pixel, the method loops through the 3x3 filter matrix and multiplies each value by the --
//corresponding pixel value in the image. The sum of these multiplications is stored in a 2D array called "output".
//After the filter has been applied to each pixel, the method loops through the image again (again excluding the edges) --
//and sets the new pixel value to be the integer value of the corresponding value in the "output" array. Each color channel (red, green, and blue) --
//is set to the same value, resulting in a grayscale image. The resulting image is stored in a temporary buffer called "TempImage" --
//and then copied back to the original display image. Finally, the method repaints the image to update it in the UI.   
    
    
public static BufferedImage ApplyMatrix(BufferedImage image, float[][] filter) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][][] imagePixels = getImagePixels(image);
    float[][][] output = new float[3][width][height];
    for (int c = 0; c < 3; c++)
    {
    	for (int y = 0; y < height; y++) 
        {
            for (int x = 0; x < width; x++)
            {
            	float sum = 0f;
                for (int i = -1; i <= 1; i++) 
                {
                    for (int j = -1; j <= 1; j++) 
                    {
                    	int iX = x + i;
                    	int iY = y + j;
                    	
                    	if (iX < 0 || iX >= width || iY < 0 || iY >= height) continue;
                    	output[c][x][y] += imagePixels[c][iX][iY] * filter[i + 1][j + 1];
                    }
                }
            }
        }
    }
    
    BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int y = 0; y < height; y++) 
    {
        for (int x = 0; x < width; x++)
        {
        	int r = (int)output[0][x][y];
        	int g = (int)output[1][x][y];
        	int b = (int)output[2][x][y];
        	
        	int color = getIntColor(r, g, b);
        	newImage.setRGB(x, y, color);
        }
    }
    return newImage;
}

private static int[][][] getImagePixels(BufferedImage image)
{
    int width = image.getWidth();
    int height = image.getHeight();
    
	int[][][] pixels = new int[3][width][height];
	for (int x = 0; x < width; x++)
	{
        for (int y = 0; y < height; y++)
        {
        	int[] pixel = getPixelValue(image, x, y);
        	for (int c = 0; c < 3; c++)
        	{
        		pixels[c][x][y] = pixel[c];
        	}
        }
	}
	
	return pixels;
}

private static int[] getPixelValue(BufferedImage image, int x, int y) {
    Color color = new Color(image.getRGB(x, y));
    
    return new int[] {color.getRed(), color.getGreen(), color.getBlue()};
}

private static int getIntColor(int r, int g, int b)
{
	return (r<<16) | (g<<8) | b;
}
}
    

    


/*
public void ApplyMatrix(float[][] filter) {
	BufferedImage TempImage;
	

	TempImage = copyImage(OriginalImage);
	int width = TempImage.getWidth();
	int height = TempImage.getHeight();
	
	float[][] output = new float[width][height];
	for( int y = 0; y < height; y++) {
		for( int x = 0; x < width; x++){    	
			for( int i = -1; i <= 1; i++ ){
				for( int j = -1; j <= 1; j++){
						output[x][y] += filter[i + 1][j + 1] * getPixelValue(TempImage, x + i, y + j);
					
					int pixel = DisplayImage.getRGB(x, y);
					
					int red = (pixel>>16)&0xff;
					int green = (pixel>>8)&0xff;
					int blue = pixel&0xff;
					
					int newPixel = (red<<16) | (green<<8) | blue;
					DisplayImage.setRGB(pixel, y,  newPixel);
					}
				}
			}
		DisplayImage = copyImage(TempImage);
	    repaint();
	}
}
}
*/


