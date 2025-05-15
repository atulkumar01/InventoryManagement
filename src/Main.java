
import model.Item;
import service.InventoryService;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        InventoryService service = new InventoryService();

        // Add Items
        service.addItem("Amul", "Milk", 100);
        service.addItem("Amul", "Curd", 50);
        service.addItem("Nestle", "Milk", 60);
        service.addItem("Nestle", "Curd", 90);

        // Add Inventory
        service.addInventory("Amul", "Milk", 10);
        service.addInventory("Nestle", "Milk", 5);
        service.addInventory("Nestle", "Curd", 10);
        service.addInventory("Amul", "Milk", 10);
        service.addInventory("Amul", "Curd", 5);

        // Search by brand
        System.out.println("\nSearch by brand: Nestle");
        Map<String, List<String>> brandFilter = new HashMap<>();
        brandFilter.put("brand", Arrays.asList("Nestle"));
        service.print(service.SearchItems(brandFilter));

        // Search by category
        System.out.println("\nSearch for category = Milk");
        Map<String, List<String>> categoryFilter = new HashMap<>();
        categoryFilter.put("category", Arrays.asList("Milk"));
        service.print(service.SearchItems(categoryFilter));

        // Search with sorting by Price desc
        System.out.println("\nSearch for category = Milk, Order_By = [Price, desc]");
        Map<String, List<String>> sortByPrice = new HashMap<>();
        sortByPrice.put("category", Arrays.asList("Milk"));
        sortByPrice.put("Order_By", Arrays.asList("Price", "desc"));
        service.print(service.SearchItems(sortByPrice));

        // Search by price range
        System.out.println("\nSearch for price = [70, 100]");
        Map<String, List<String>> priceFilter = new HashMap<>();
        priceFilter.put("price", Arrays.asList("70", "100"));
        service.print(service.SearchItems(priceFilter));

        // Search by category + price + sorting
        System.out.println("\nSearch for category = Milk, price = [70, 100], Order_By = [Price, desc]");
        Map<String, List<String>> complexFilter = new HashMap<>();
        complexFilter.put("category", Arrays.asList("Milk"));
        complexFilter.put("price", Arrays.asList("70", "100"));
        complexFilter.put("Order_By", Arrays.asList("Price", "desc"));
        service.print(service.SearchItems(complexFilter));

    }
}