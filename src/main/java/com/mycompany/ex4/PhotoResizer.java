package com.mycompany.ex4;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author szymon
 */
public class PhotoResizer {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalStateException("You must give a source file path and target file path as parameter");
        }

        String inputPath = args[0];
        String outputPath = args[1];

        resize(inputPath, outputPath);

    }

    private static void resize(String inputPath, String outputPath) throws IOException {
        File inputFile = new File(inputPath);
        BufferedImage bufferedIm = ImageIO.read(inputFile);

        int widthOutput = (int) (bufferedIm.getWidth() * 0.5);
        int heightOutput = (int) (bufferedIm.getHeight() * 0.5);
        BufferedImage bufferedOut = new BufferedImage(widthOutput, heightOutput, bufferedIm.getType());
        Graphics2D g2d = bufferedOut.createGraphics();
        g2d.drawImage(bufferedIm, 0, 0, widthOutput, heightOutput, null);
        g2d.dispose();
        String formatName = outputPath.substring(outputPath.lastIndexOf(".") + 1);
        ImageIO.write(bufferedOut, formatName, new File(outputPath));
    }
}