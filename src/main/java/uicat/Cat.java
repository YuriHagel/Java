package uicat;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class Cat.
 */
@Data
public class Cat implements Serializable {
  private Long key;
  private Float height;
  private Float weight;
  private Integer age;
  private String nickname;

  public Cat() {
  }

  public Cat(Long key, Float height, Float weight, Integer age, String nickname) {
    this.key = key;
    this.height = height;
    this.weight = weight;
    this.age = age;
    this.nickname = nickname;
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
}
