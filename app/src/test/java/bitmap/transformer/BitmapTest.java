/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BitmapTest {
    @Test public void testEdgeColor() throws IOException {
        Bitmap classUnderTest = new Bitmap("test", "edgeColor", "Edged");
        assertTrue(Files.exists(Paths.get("./src/main/resources/NewImages/Edged.bmp")));
    }

    @Test public void testConvertToGrayScale() throws IOException {
        Bitmap classUnderTest = new Bitmap("test", "convertToGrayScale", "GrayScale");
        assertTrue(Files.exists(Paths.get("./src/main/resources/NewImages/GrayScale.bmp")));
    }

    @Test public void reverseImageVertically() throws IOException {
        Bitmap classUnderTest = new Bitmap("test", "reverseImageVertically", "Vertical");
        assertTrue(Files.exists(Paths.get("./src/main/resources/NewImages/Vertical.bmp")));
    }

    @Test public void convertToGreens() throws IOException {
        Bitmap classUnderTest = new Bitmap("test", "convertToGreens", "Green");
        assertTrue(Files.exists(Paths.get("./src/main/resources/NewImages/Green.bmp")));
    }

    @Test public void convertImageToPinkBox() throws IOException {
        Bitmap classUnderTest = new Bitmap("test", "convertImageToPinkBox", "Pink");
        assertTrue(Files.exists(Paths.get("./src/main/resources/NewImages/Pink.bmp")));
    }

}
