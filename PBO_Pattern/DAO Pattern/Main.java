import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDao;
import  dao.memory.ProductDaoInMemory;
import model.Product;

public class Main {
    private final ProductDao productDao = new ProductDaoInMemory();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.startMenuLoop();
        app.scanner.close();
    }

    public void startMenuLoop(){
        boolean running = true;
        while (running) {
            System.out.println(" === DAO PATTERN MENU === ");
            System.out.println("1. tampilkan semua Products");
            System.out.println("2. tambah Product");
            System.out.println("3. keluar");
            System.out.print("Pilih opsi:  ");

            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1: 
                    displayAllProducts();
                    break;
                    case 2:
                    addNewProduct();
                    break;
                    case 3:
                    running = false;
                    break;
                    default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            }catch(Exception e){
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    
    }

    private void displayAllProducts(){
        ArrayList<Product> products = productDao.findAll();
        System.out.println("=== Daftar Products ===");
        for (Product product : products) {
            System.out.println(product);
                }
    }

    private void addNewProduct(){
        System.out.println("Nama Product: ");
        String name = scanner.nextLine();
        System.out.println("Harga Product: ");
        long price = Long.parseLong(scanner.nextLine());
        if (price<=0) {
            System.out.println("Harga harus lebih dari 0.");
            return;
        }

        int newId = productDao.findAll().size() + 1;
        Product newProduct = new Product(newId, name, price);
        productDao.save(newProduct);
        System.out.println("Product berhasil ditambahkan.");
    }
}