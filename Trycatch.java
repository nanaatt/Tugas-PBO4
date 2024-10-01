/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trycatch;


/**
 *
 * @author Careen Emilza
 */
public class Trycatch {
    public static void main(String[] args) {
        int pembilang = 10;
        int penyebut = 0;

        try {
            int hasil = pembilang / penyebut;
            System.out.println("Hasil bagi: " + hasil);
        } catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Pembagian dengan nol tidak diperbolehkan.");
        }
    }
}
