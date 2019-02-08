package com.mycompany.ex5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author szymon
 */
public class ZipDir {

    public static void main(String[] args) {

        if (args.length < 1) {
            throw new IllegalStateException("You must give at least a source file path as parameter");
        }

        String sourceFile = args[0];
        String targetFile = (args.length < 2) ? sourceFile.substring(0, sourceFile.lastIndexOf("/")) + "/nazwaFolderu.zip" : args[1];

        zipFiles(sourceFile, targetFile);

    }

    private static void zipFiles(String sourceFile, String targetFile) {

        File dirToZip = new File(sourceFile);
        File[] files = dirToZip.listFiles();
        try (ZipOutputStream zOutStream = new ZipOutputStream(new FileOutputStream(targetFile))) {

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    try (FileInputStream fInStream = new FileInputStream(files[i])) {
                        zOutStream.putNextEntry(new ZipEntry(files[i].getName()));

                        int length;
                        byte[] byteArray = new byte[1024];
                        while ((length = fInStream.read(byteArray)) > 0) {
                            zOutStream.write(byteArray, 0, length);
                        }
                        zOutStream.closeEntry();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception occured" + ex);
        } catch (IOException ex) {
            System.out.println("Exception occured" + ex);
        }
    }
}
