package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    String inputPath;
    String outputPath;
    String newImageName;
    BufferedImage image = null;


    public Bitmap(String inputPath, String outputPath, String newImageName) throws IOException {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.newImageName = newImageName;
        try {
            this.image = ImageIO.read(new File(inputPath));

        } catch (IOException ioException) {
            System.out.println(ioException);
        }

    }

    public void saveImage(BufferedImage newImg) throws IOException {
        try {
            File output = new File(this.outputPath + "/" + newImageName + ".bmp");
            System.out.println(output);
            ImageIO.write(newImg, "bmp", output);

        } catch (IOException ioException) {
            System.out.println(ioException);
        }
    }

    public boolean edgeColor() throws IOException {
        boolean hasChanged = false;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int color = image.getRGB(i, j);
                System.out.println(color);
                if (color == -16777216) {
                    image.setRGB(i, j, Color.GREEN.getRGB());
                    hasChanged = true;
                }
            }
        }
        this.saveImage(this.image);
        return hasChanged;

    }


    public void convertToGrayScale() throws IOException {
        for (int i=0; i < this.image.getWidth(); i++){
            for( int j=0; j < this.image.getHeight(); j++){
                //getting RGB color on each pixel
                Color c = new Color(this.image.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                //turning color to grayscale
                int gr = (r + g + b) / 3;

                //create gray color
                Color grayColor = new Color (gr, gr, gr, a);
                this.image.setRGB(i, j, grayColor.getRGB());
            }
        }
        this.saveImage(image);
    }


    public void negativeImage() throws IOException {
        for (int i = 0; i < this.image.getWidth(); i++){
            for( int j=0; j < this.image.getHeight(); j++){
                Color color = new Color(this.image.getRGB(i, j), true);
                color = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
                this.image.setRGB(i, j, color.getRGB());
            }
        }
        this.saveImage(image);
    }


    public void reverseImageVertically() throws IOException {
        for (int i = 0; i < this.image.getWidth(); i++){
            for (int j = 0; j < this.image.getHeight()/2; j++){
                int temp = this.image.getRGB(i,j);
                this.image.setRGB(i,j, this.image.getRGB(i,this.image.getHeight() - j - 1));
                this.image.setRGB(i,this.image.getHeight() - j - 1, temp);
            }
        }
        this.saveImage(image);
    }


    public void convertToGreens() throws IOException {
        for (int i=0; i < this.image.getWidth(); i++){
            for( int j=0; j < this.image.getHeight(); j++){
                //getting RGB color on each pixel
                Color c = new Color(this.image.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();

                Color greenColor = new Color (0, g, 0, a);
                this.image.setRGB(i, j, greenColor.getRGB());
            }
        }
        this.saveImage(image);
    }


    public void convertImageToPinkBox() throws IOException {
        for (int i = 0; i < this.image.getWidth(); i++){
            for( int j = 0; j < this.image.getHeight(); j++){
                //getting RGB color on each pixel
                Color c = new Color(this.image.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();

                Color opacity = new Color (255,0,144,a);
                this.image.setRGB(i, j, opacity.getRGB());
            }
        }
        this.saveImage(image);
    }

}