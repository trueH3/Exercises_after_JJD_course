package com.mycompany.ex5;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author szymon
 */
public class ZipDirTest {
    
    @Test
    public void zippedFileShouldBeSmallerAndHasNoFolderInside() throws IOException {
        
        //Given
        String inputPath = "./src/test/java/com/mycompany/ex5/testFolder";
        String outputPath = "./src/test/java/com/mycompany/ex5/testFolder.zip";
        //When
        ZipDir.main(new String []{inputPath, outputPath});
        //Then
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        assertTrue(inputFile.length()>outputFile.length());
        
        try(ZipFile zippedFile = new ZipFile(outputFile)){
            assertFalse(zippedFile.stream().anyMatch(a -> a.isDirectory()));
        }
        outputFile.deleteOnExit();
    }
}