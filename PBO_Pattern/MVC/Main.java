import java.util.Scanner;
import controller.ProductController;
import view.ProductConsoleView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductConsoleView view = new ProductConsoleView(scanner);
        ProductController controller = new ProductController(view);

        while (true) {
            System.out.println("\n--- Menu Utama (MVC Only) ---");
            System.out.println("1. Tampilkan Produk");
            System.out.println("2. Tambah Produk");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");

            try{
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 3) break;
                controller.handleMenuChoice(choice);
            }catch (NumberFormatException e) {
                view.displayError("Input tidak valid. Masukkan angka.");
            }
        }
        scanner.close();
    }
}