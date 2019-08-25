package stock;

import lombok.Data;

@Data
public class Product implements Comparable<Product> {
  public String label;
  public double price;
  public int quantity;

  public Product(String label, double price, int quantity) {
    this.label = label;
    this.price = price;
    this.quantity = quantity;
  }

  @Override
  public int compareTo(Product o) {
    return this.getLabel().compareTo(o.getLabel());
  }
}
