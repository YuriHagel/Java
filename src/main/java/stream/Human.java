package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Accessors(chain = true)
@Data
@AllArgsConstructor
public class Human {
  String firstName;
  String lastName;
  int age;
  public List<String> balanceSheets;

  @Accessors(chain = true)
  @Data
  @AllArgsConstructor
static class Balance {
    private Long balanceTypeId;
    private String balanceName;
    private Integer flag;
  }


  public String age() {
    return "45";
  }
}
