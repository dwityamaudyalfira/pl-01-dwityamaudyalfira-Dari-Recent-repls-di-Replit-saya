package com.github.affandes.kuliah.pl.pl01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class MahasiswaTest {

    @Test
    public void cekClassMahasiswa() {
        try {
            // Cek Class
            Class.forName("com.github.affandes.kuliah.pl.pl01.Mahasiswa");
            assertTrue(true, "Class Mahasiswa belum dibuat");
            // Cek Object
            Class dClass = Class.forName("com.github.affandes.kuliah.pl.pl01.Mahasiswa");
            Object dObj = dClass.getDeclaredConstructor().newInstance();
            assertTrue(true, "Constructor default tidak bisa diakses");
            // Cek Field
            Field nama = dObj.getClass().getDeclaredField("nama");
            Field nim = dObj.getClass().getDeclaredField("nim");
            Field umur = dObj.getClass().getDeclaredField("umur");
            assertEquals("java.lang.String", nama.getType().getName(), "Tipe data nama tidak sesuai");
            assertEquals("java.lang.String", nim.getType().getName(), "Tipe data nim tidak sesuai");
            assertEquals("int", umur.getType().getName(), "Tipe data umur tidak sesuai");

            nama.set(dObj, "Hacker");
            nim.set(dObj, "291929");
            umur.set(dObj, 18);

            assertEquals("Hacker", nama.get(dObj), "Field nama tidak dapat diakses");
            assertEquals("291929", nim.get(dObj), "Field nim tidak dapat diakses");
            assertEquals(18, umur.get(dObj), "Field umur tidak dapat diakses");

        } catch (IllegalAccessException | InstantiationException e) {
            fail("Class Mahasiswa tidak bisa diakses");
        } catch (ClassNotFoundException e) {
            fail("Class Mahasiswa tidak ada");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Class Mahasiswa tidak lengkap");
        } catch (InvocationTargetException e) {
            fail("Method pada class Mahasiswa tidak benar");
        }
    }

}
