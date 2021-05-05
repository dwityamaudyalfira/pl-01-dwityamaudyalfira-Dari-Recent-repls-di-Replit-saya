package com.github.affandes.kuliah.pl.pl01;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void cekClassMain() {
        try {
            // Cek Class
            Class.forName("com.github.affandes.kuliah.pl.pl01.Main");
            assertTrue(true, "Class Main sudah dibuat");

        } catch (ClassNotFoundException e) {
            fail("Class Main sudah dibuat");
        }
    }

    @Test
    public void cekRunMain() {

        // Hijack input/output stream
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        // Prepare input/output
        String[] i = {"Hacker", "626447", "21"};
        ByteArrayInputStream currentIn = new ByteArrayInputStream(String.join(System.getProperty("line.separator"), Arrays.asList(i)).getBytes());
        ByteArrayOutputStream currentOut = new ByteArrayOutputStream();
        System.setIn(currentIn);
        System.setOut(new PrintStream(currentOut));

        // Execute
        Main.main(null);

        // Get Output
        String[] r = currentOut.toString().split(System.getProperty("line.separator"));

        // Reset input/output stream
        System.setIn(originalIn);
        System.setOut(originalOut);

        // Test
        String[] e = {"Hacker 626447 (21 tahun)"};
        assertArrayEquals(e, r, "Output tidak sesuai.");
    }


}
