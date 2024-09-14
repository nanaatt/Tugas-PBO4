/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package throwss;

/**
 *
 * @author Careen Emilza
 */
public class Throws {
    
    public static int[] createArray(int size) throws NegativeArraySizeException {
        if (size < 0) {
            throw new NegativeArraySizeException("Ukuran array tidak bisa negatif: " + size);
        }
        return new int[size];
    }
    
    public static void main(String[] args){
        createArray(-8);
    }
}
