import java.util.List;
import java.util.Scanner;

import model.Product;
import service.ProductServiceDefault;

public class Main {
    
    private final ProductServiceDefault productService = new ProductServiceDefault();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.startMenuLoop();
        app.scanner.close();
    }

    public void startMenuLoop(){
        boolean running = true;
        while (running){
            System.out.println("\n === Service Layer Pattern ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Lihat Semua Produk");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1 :
                        displayAllProducts();
                        break;
                    case 2 : 
                        addNewProduct();
                        break;
                    case 3 : 
                        running = false;
                        break;
                    default : 
                        System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            } catch ( NumberFormatException e){
                System.out.println("Input tidak valid. Silakan masukkan angka.");
            }
        }
    }

    private void displayAllProducts(){
        List<Product> products = productService.getAllProducts();
        System.out.println("\n--- Daftar Produk ---");
        for (Product product : products){
            System.out.println(product.getId() + " - " + product.getName() +  " Rp. " + product.getPrice());
        }
    }

    private void addNewProduct(){
        System.out.println("Masukkan Nama Produk: ");
        String name = scanner.nextLine();
        System.out.println("Masukkan Harga Produk: ");
        String priceString = scanner.nextLine();

        try {
            long price =  Long.parseLong(priceString);
            productService.addProduct(name, price);
            System.out.println("Produk berhasil ditambahkan.");
        }catch (NumberFormatException e){
            System.out.println("Harga tidak valid. Silakan masukkan angka.");
        } catch (IllegalArgumentException e){
            System.out.println( "Error: "+ e.getMessage());
        }
    }
}