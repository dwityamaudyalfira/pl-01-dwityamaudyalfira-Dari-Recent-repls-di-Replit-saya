package com.github.affandes.kuliah.pl.pl01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tulis kode jawaban kalian disini
      Scanner input = new Scanner(System.in);
      
    Mahasiswa dwitya = new Mahasiswa();
      dwitya.nama = input.nextLine();
      dwitya.nim = input.nextLine();
      dwitya.umur = input.nextInt();

      System.out.print( dwitya.nama + " " + dwitya.nim + " (" + dwitya.umur + " tahun)" );
    }
}