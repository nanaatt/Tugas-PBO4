/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Careen Emilza
 */
public class Utama {

   Connection cn;
    Statement stm;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/pbo";
    String user = "postgres";
    String password = "189066";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(koneksi, user, password);
            cn.setAutoCommit(false);

            String sql = "INSERT INTO Pelanggan VALUES(?,?,?,?)";
            pstmt = cn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN ID PELANGGAN ");
                System.out.print("ID Pelanggan : ");
                int id_pelanggan = Integer.parseInt(input.readLine().trim());
                System.out.print("Nama : ");
                String nama_pelanggan = input.readLine().trim();
                System.out.print("Email : ");
                String email = input.readLine().trim();
                System.out.print("Alamat : ");
                String alamat = input.readLine().trim();

                pstmt.setInt(1, id_pelanggan);
                pstmt.setString(2, nama_pelanggan);
                pstmt.setString(3, email);
                pstmt.setString(4, alamat);

                pstmt.executeUpdate();

                System.out.print("Apakah anda ingin menambahkan data? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true;
                }
            }

            cn.commit();
            pstmt.close();
            cn.close();
            System.out.println("succes");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    public void tampil() {
        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM Pelanggan";
            cn = DriverManager.getConnection(koneksi, user, password);
            stm = cn.createStatement();

            while (!cn.isClosed()) {
                ResultSet rs;
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(String.valueOf(rs.getObject(1)) + " | " + String.valueOf(rs.getObject(2)) + " | "
                            + "" + String.valueOf(rs.getObject(3)) + " | " + String.valueOf(rs.getObject(4)));
                }
                cn.close();
            }

            stm.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapus() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(koneksi, user, password);

            // Prompt the user for the dogtag of the record they want to delete
            System.out.print("Masukkan ID Pelanggan yang akan dihapus : ");
            String dogtagToDelete = input.readLine().trim();

            // Delete the record from the database
            String deleteSql = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";
            pstmt = cn.prepareStatement(deleteSql);
            pstmt.setLong(1, Long.parseLong(dogtagToDelete));
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("ID Pelanggan " + dogtagToDelete + " Penghapusan berhasil!");
            } else {
                System.out.println("ID Pelanggan" + dogtagToDelete + " tidak ada.");
            }

            pstmt.close();
            cn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE Pelanggan SET nama_pelanggan = ?, email =?, alamat =? WHERE id_pelanggan = ?";
            cn = DriverManager.getConnection(koneksi, user, password);
            pstmt = cn.prepareStatement(sql);

            System.out.print("Masukkan ID Pelanggan yang akan diupdate: ");
            int id_pelanggan_baru = Integer.parseInt(input.readLine().trim());
            System.out.print("Nama Pelanggan baru: ");
            String nama_pelanggan_baru = input.readLine().trim();
            System.out.print("Email baru: ");
            String email_baru = input.readLine().trim();
            System.out.print("Alamat baru: ");
            String alamat_baru = input.readLine().trim();

            pstmt.setString(1, nama_pelanggan_baru);
            pstmt.setString(2, email_baru);
            pstmt.setString(3, alamat_baru);
            pstmt.setInt(4, id_pelanggan_baru);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

            pstmt.close();
            cn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void menu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Input Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Update Data");
        System.out.println("0. exit");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    tambah();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    hapus();
                    break;
                case 4:
                    update();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new Utama().menu();
    }
}
