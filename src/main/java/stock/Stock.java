package stock;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Stock implements ProductStock {
  // вместимость склада
  private final int CAPACITY=1000;
  // id продукта.
  private Map<String, Product> productMap;
  // список продуктов
  private List<Product> productList;


  //Конструктор.
  public Stock() {
    this.productMap = new HashMap<>();
    productList = new ArrayList<>();
  }

  // количество товаров
  @Override
  public int getCount() {
    return this.productList.size();
  }

  // индекс товара в списке
  @Override
  public boolean contains(Product product) {
    if(productMap.containsValue(product)){
      System.out.println("На складе нет такого товара");
    }
    return this.productMap.containsKey(product.getLabel());
  }

  // добавление товара
  @Override
  public void add(Product product) {
    if (this.productMap.size() >= CAPACITY) {
      System.out.println("На складе больше нет места!");
    } else {
      this.productMap.put(product.getLabel(), product);
      this.productList.add(product);
    }
  }

  //Изменить количество продуктов.
  @Override
  public void changeQuantity(String product, int quantity) {
    if (!this.productMap.containsKey(product)) {
      throw new IllegalArgumentException();
    }
    this.productMap.get(product).setQuantity(quantity);
  }

  // поиск товара по id
  @Override
  public Product find(int index) {
    if (index < 0 || index > this.productList.size() - 1) {
      throw new IndexOutOfBoundsException();
    }
    return this.productList.get(index);
  }

  // Найти товар по имени.
  @Override
  public Product findByLabel(String label) {
    if (!this.productMap.containsKey(label)) {
      throw new IllegalArgumentException();
    }
    return this.productMap.get(label);
  }

  // Найти первый элемент в алфавитном порядке.
  @Override
  public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
    if (count < 0 || count > this.productList.size()) {
      return new ArrayList<>();
    }

    return this.productList.stream()
            .sorted(Product::compareTo)
            .limit(count)
            .collect(Collectors.toList());
  }

  @Override
  public Iterable<Product> findAllInRange(double lo, double hi) {
    return this.productList.stream()
            .filter(a -> a.getPrice() > lo && a.getPrice() <= hi)
            .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
            .collect(Collectors.toList());
  }

  // поиск товара по цене.
  @Override
  public Iterable<Product> findAllByPrice(double price) {
    return this.productList.stream()
            .filter(a -> a.getPrice() == price)
            .collect(Collectors.toList());
  }

  //Найти самый дорогой товар.
  @Override
  public Iterable<Product> findFirstMostExpensiveProducts(int count) {
    if (count > this.productList.size()) {
      throw new IllegalArgumentException();
    }

    return this.productList.stream()
            .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
            .limit(count)
            .collect(Collectors.toList());
  }

  // Найти общеее количество продуктов.
  @Override
  public Iterable<Product> findAllByQuantity(int quantity) {
    return this.productList.stream()
            .filter(a -> a.getQuantity() == quantity)
            .collect(Collectors.toList());
  }

  @Override
  public Iterator<Product> iterator() {
    return this.productList.iterator();
  }
}
