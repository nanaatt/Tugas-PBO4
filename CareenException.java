/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Careen Emilza
 */
public class CareenException extends Exception {

    public CareenException(String s) {
        super(s);
    }

    public static void main(String args[]) {
        try {
            throw new CareenException("Salah ya");
        } catch (CareenException ex) {
            System.out.println("Tidak bisa " + String.valueOf(ex));

        }
    }
}
