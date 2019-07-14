package nursery;

import java.io.Serializable;
import java.util.Objects;

public class Cat implements Serializable {
  private Long key;
  private Float height;
  private Float weight;
  private Integer age;
  private String nickname;

  public Cat() {
  }

  // CONSTRUCTOR
  public Cat(Long key, Float height, Float weight, Integer age, String nickname) {
    this.key = key;
    this.height = height;
    this.weight = weight;
    this.age = age;
    this.nickname = nickname;
  }

  public Float getHeight() {
    return height;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Long getKey() {
    return key;
  }

  public void setKey(Long key) {
    this.key = key;
  }


  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.key);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Cat other = (Cat) obj;
    return Objects.equals(this.key, other.key);
  }

  @Override
  public String toString() {
    return "Номер = " + key +
            ", Кличка = " + nickname +
            ", Рост = " + height +
            ", Вес = " + weight +
            ", Возраст = " + age;
  }
}
