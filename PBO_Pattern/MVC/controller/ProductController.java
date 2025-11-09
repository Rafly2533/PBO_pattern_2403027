package controller;
import model.Product;
import view.ProductConsoleView;
import java.util.ArrayList;

public class ProductController {
    private final ArrayList<Product> model = new ArrayList<>();
    private final ProductConsoleView view;

    public ProductController(ProductConsoleView view) {
        this.view = view;
        model.add(new Product(1, "Acer", 95000));
    }

    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                displayProductsAction();
                break;
            case 2:
                addProductAction();
                break;
            case 3:
                view.displayMessage("Keluar dari aplikasi.");
                break;
            default:
                view.displayError("Pilihan tidak valid.");
        }
    }

    private void displayProductsAction() {
        view.displayAllProducts(model);
    }

    private void addProductAction() {
        String name = view.getProductNameFromUser();
        String priceStr = view.getProductPriceFromUser();
        try {
            long price = Long.parseLong(priceStr);
            if (price <= 0) {
                throw new IllegalArgumentException("Harga harus angka positif lebih dari 0");
            }
            int newId = model.size() + 1;
            model.add(new Product(newId, name, price));
            view.displayMessage("Produk berhasil ditambahkan.");
        } catch (IllegalArgumentException e) {
            view.displayError("Input tidak valid: " + e.getMessage());
    }
}
}