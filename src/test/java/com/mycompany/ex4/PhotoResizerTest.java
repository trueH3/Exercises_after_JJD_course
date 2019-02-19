/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex4;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author szymon
 */
public class PhotoResizerTest {


    @Test
    public void shouldShrinkPictureByHalf() throws Exception {
        String inputPath = "./src/test/java/com/mycompany/ex4/test.jpg";
        String outputPath = "./src/test/java/com/mycompany/ex4/te.jpg";

        PhotoResizer.main(new String[]{inputPath, outputPath});
        File outputFile = new File(outputPath);
        BufferedImage bufferedImInput = ImageIO.read(new File(inputPath));
        BufferedImage bufferedImOutput = ImageIO.read(outputFile);
        assertEquals(bufferedImInput.getHeight() / 2, bufferedImOutput.getHeight());
        assertEquals(bufferedImInput.getWidth() / 2, bufferedImOutput.getWidth());
        outputFile.delete();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowException() throws Exception {
        PhotoResizer.main(new String[]{});
    }

}
