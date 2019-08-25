package stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  private static final String[] productNames = new String[]{
          "Mandarin", "Lemon", "Orange",
          "Apple", "Pear", "Mango",
          "Potatoes", "Carrot", "Cabbage",
          "Onion", "Garlic", "Selery",
          "Meat", "Milk", "Aggs"
  };
  private static final String STOCK_NAME = "WALMART";

  public static void main(String[] args) {
    // создаём склад
    Stock stock = new Stock();
    List<Product> products = createProducts(4);
    products.forEach(stock::add);
    printStock(stock);

    System.out.println("Cортировка товаров по цене и количество товаров");
    products.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
    System.out.println(products);

    System.out.println("Cортировка товаров по имени");
    stock.findAllInRange(2, 4);
    Collections.sort(products);
    products.toArray(new Product[0]);
    stock.findFirstByAlphabeticalOrder(1);
    System.out.println(products);
  }

  //Создать продукт.
  private static List<Product> createProducts(int count) {
    List<Product> products = new ArrayList<>();

    for (int i = 1; i <= count; i++) {
      Product product = new Product(productNames[(int) (Math.random() * productNames.length)], 11.2 * i, 2 * i);
      products.add(product);
    }
    return products;
  }

  private static void printStock(Stock stock) {
    StringBuilder s = new StringBuilder("***\n" + STOCK_NAME + " (Товаров: " + stock.getCount() + "):");
    for (Product p : stock) {
      s.append("\n\t").append(stock.getCount()).append(". ").append(p.toString()).append(";");
    }
    System.out.println(s);
  }

}



