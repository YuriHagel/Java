package uicat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CatTableModel extends AbstractTableModel {
  private List<Cat> listCat;
  private final String[] columnNames = {"Кличка", "Рост", "Вес", "Возраст"};

  public CatTableModel() {
    //this.listCat = new ArrayList<>();
  }

  public void setList(List<Cat> listCat) {
    this.listCat = listCat;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }

  @Override
  public int getRowCount() {
    return listCat.size();
  }

  @Override
  public int getColumnCount() {
    return 4;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Cat si = listCat.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return si.getNickname();
      case 1:
        return si.getHeight();
      case 2:
        return si.getWeight();
      case 3:
        return si.getAge();
      case 4:
        return si.getKey();
    }
    return null;
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return String.class;
      case 1:
        return Float.class;
      case 2:
        return Float.class;
      case 3:
        return Integer.class;
    }
    return null;
  }

  @Override
  public boolean isCellEditable(int row, int column) {
    return true;
  }
}
