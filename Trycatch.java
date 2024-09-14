/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trycatch;

import java.util.Scanner;

/**
 *
 * @author Careen Emilza
 */
public class Trycatch {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Masukkan id pelanggan: ");
            int contoh = sc.nextInt();
        }catch (Exception e){
            System.out.println("Id pelanggan hanya berupa angka.");
        }
    }
    
}
