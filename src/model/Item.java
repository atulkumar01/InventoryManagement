package model;

public class Item {

    String category;
    String brand;
    int price;
    int quantity;

    public Item(String brand, String category, int price, int quantity) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }



    public String getCategory() {
          return category;
      }

      public void setCategory(String category) {
          this.category = category;
      }

      public String getBrand() {
          return brand;
      }

      public void setBrand(String brand) {
          this.brand = brand;
      }

      public int getPrice() {
          return price;
      }

      public void setPrice(int price) {
          this.price = price;
      }

      public int getQuantity() {
          return quantity;
      }

      public void setQuantity(int quantity) {
          this.quantity = quantity;
      }

      @Override
      public String toString() {
          return "Item{" +
                  "category='" + category + '\'' +
                  ", brand='" + brand + '\'' +
                  ", price=" + price +
                  ", quantity=" + quantity +
                  '}';
      }
  }
