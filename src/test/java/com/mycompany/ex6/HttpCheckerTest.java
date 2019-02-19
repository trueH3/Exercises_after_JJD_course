package com.mycompany.ex6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 *
 * @author szymon
 */
public class HttpCheckerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldPrintRequestedData() throws Exception {
        //When
        HttpChecker.main(new String[]{"http://example.com/"});
        //Then
        assertEquals("Allowed http methods: OPTIONS, GET, HEAD, POST\nContent length = 1270\n", outContent.toString());
    }

    @Test
    public void shouldExitTheSystem() throws Exception {
        exit.expectSystemExitWithStatus(1);
        HttpChecker.main(new String[]{"http://hrrhrhrh.com/"});
    }
}
