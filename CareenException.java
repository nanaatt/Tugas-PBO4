/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Careen Emilza
 */
public class CareenException extends ArithmeticException {

    public CareenException(String s) {
        super(s);
    }
    public static void Trycatch(){
        int pembilang = 10;
        int penyebut = 0;

        try {
            int hasil = pembilang / penyebut;
            System.out.println("Hasil bagi: " + hasil);
        } catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Pembagian dengan nol tidak diperbolehkan.");
        }
    }
    public static void main(String args[]) {
       CareenException.Trycatch();
    }
}
