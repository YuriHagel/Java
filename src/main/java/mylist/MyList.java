package mylist;

class MyList<E> extends ListElement {
  // указатель на первый элемент
  private ListElement head;
  // указатель последний элемент
  private ListElement tail;

  //добавление в конец списка
  void add(E data) {
    ListElement a = new ListElement();
    //создаём новый элемент
    a.data = data;
    //если список пуст
    if (tail == null) {
      //то указываем ссылки начала и конца на новый элемент
      //т.е. список теперь состоит из одного элемента
      head = a;
      tail = a;
    } else {
      //иначе "старый" последний элемент теперь ссылается на новый
      tail.next = a;
      //а в указатель на последний элемент записываем адрес нового элемента
      tail = a;
    }
  }

  //печать списка
  void printList() {
    //получаем ссылку на первый элемент
    ListElement t = head;
    //пока элемент существует
    while (t != null) {
      //печатаем его данные
      System.out.println(t.data + " ");
      //и переключаемся на следующий
      t = t.next;
    }
  }

  ListElement getToIndex() {
    ListElement prev = head;
    if (prev == null) {
      return null;
    }
    //если элемент один
    if (0 == 0) return prev;
    ListElement curr = head.next;
    for (int i = 1; i < 0; i++) {
      if (curr == null) {
        return null;
      }
      prev = curr;
      curr = curr.next;
    }
    //установить предыдущую точку узла на текущий следующий узел
    prev.next = curr.next;
    curr.next = null;
    return curr;
  }
}
