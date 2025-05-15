package service;

import model.Item;

import java.util.*;
import java.util.stream.Collectors;

/*
Add Item (brand, category, price)
Add inventory (brand, category, quantity)
SearchItems(“category”=[“categoryValue”]) / SearchItems(“brand”=[“brandValue”]) / SearchItems(“price”=[fromPrice, toPrice])
SearchItems(“category”=[“categoryValue”], Order_By=[Price, asc]) / SearchItems(“category”=[“categoryValue”], Order_By=[ItemQty, desc])
*/

public class InventoryService {

    private Map<String, Item> inventory;

    public InventoryService()
    {
        inventory = new HashMap<>();
    }

    public void addItem(String brand, String category, int price)
    {
        String key = brand.toLowerCase() + "-" + category.toLowerCase();

        if (!inventory.containsKey(key)) {
            inventory.put(key, new Item(brand, category, price, 0));
            System.out.println("Item added successfully: " + brand + ", " + category+", "+ price);
        } else {
            System.out.println("Item already exists in inventory.");
        }

    }

    public void addInventory(String brand, String category, int quantity)
    {
        String key = brand.toLowerCase() + "-" + category.toLowerCase();

        if (inventory.containsKey(key)) {
            Item item = inventory.get(key);

            int CurrentQuantity = item.getQuantity();

            item.setQuantity(CurrentQuantity + quantity);

            System.out.println("Inventory updated: " + brand +"- "+category+","+ quantity + " added.");
        }
        else {
            System.out.println("Item not found in inventory.");
        }

    }

    public List<Item> SearchItems(Map<String, List<String>> filters)
    {
        String category = filters.containsKey("category") ? filters.get("category").get(0) : null;

        String brand = filters.containsKey("brand") ? filters.get("brand").get(0) : null;

        Integer fromPrice = null, toPrice = null;

        if (filters.containsKey("price")) {
            List<String> priceRange = filters.get("price");
             fromPrice = Integer.parseInt(priceRange.get(0));
             toPrice = Integer.parseInt(priceRange.get(1));
        }

        String sortBy = null, sortOrder = null;
        if (filters.containsKey("Order_By") && filters.get("Order_By").size() == 2) {
            sortBy = filters.get("Order_By").get(0);   // e.g., "Price"
            sortOrder = filters.get("Order_By").get(1); // e.g., "asc"
        }

        return applySearchFilters(category, brand, fromPrice, toPrice, sortBy, sortOrder);

    }

    private List<Item> applySearchFilters(String category, String brand, Integer fromPrice, Integer toPrice, String sortBy, String sortOrder)
    {
        List<Item> items = new ArrayList<>(inventory.values());

        if (category != null) {
            items = items.stream()
                    .filter(item -> item.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }

        if (brand != null) {
            items = items.stream()
                    .filter(item -> item.getBrand().equalsIgnoreCase(brand))
                    .collect(Collectors.toList());
        }

        if (fromPrice != null && toPrice != null) {
            items = items.stream()
                    .filter(item -> item.getPrice() >= fromPrice && item.getPrice() <= toPrice)
                    .collect(Collectors.toList());
        }

        if (sortBy != null && sortOrder != null) {
            Comparator<Item> comparator = null;

            if (sortBy.equalsIgnoreCase("Price")) {
                comparator = Comparator.comparing(Item::getPrice);
            } else if (sortBy.equalsIgnoreCase("ItemQty")) {
                comparator = Comparator.comparing(Item::getQuantity);
            }

            if (comparator != null) {
                if (sortOrder.equalsIgnoreCase("desc")) {
                    comparator = comparator.reversed();
                }
                items = items.stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());
            }
        }



        return items;
    }

    public void print(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.getBrand() + ", " + item.getCategory() + ", Qty: " + item.getQuantity() + ", Price: " + item.getPrice());
        }
    }






}
