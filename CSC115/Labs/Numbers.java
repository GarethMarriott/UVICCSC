


public class Numbers{

private int count = 0;
//private int size = 0;
private int[] storage;

public Numbers(){

    storage = new int[2];
    //size = 2;

}

public void add(int num){

  storage[count] = num;
  count = count + 1;
  if (count == storage.length) {
    doublearray();
  }

}

public void doublearray(){
  int[] temp = new int[count*2];
  for (int i = 0; i < storage.length; i++) {
    temp[i] = storage[i];
  }
  storage = new int[count*2];
  storage = temp;
}

public void remove(int num){
  // for (int i = 0; i < storage.length; i++) {
  //   if (num == storage[i]) {
  //     storage[i]=0;
  //   }
  // }


  int index = checkIndex(num);
  if (index == -1) {
    System.out.println("number not found");
  }else{
    int[] temp = new int[storage.length];
    int j = 0;
    for (int i = 0; i < count; i++) {
      if (i != index) {
        temp[j] = storage[i];
        j++;
      }
    }
    storage = temp;
    count--;
  }

}

private int checkIndex(int num){
  for (int i = 0; i < count; i++) {
    if (storage[i] == num) {
      return i;
    }
  }
  return -1;
}



public String toString(){
  String out = "";
  for (int i = 0; i < storage.length; i++)
  {
    if (storage[i] != 0)
    {
      out = out + storage[i];
      if (count > i+1)
      {
      out = out + ",";
      }
    }
  }
  return out;
}



  public static void main(String[] args) {

    Numbers a1 = new Numbers();

    a1.add(4);
    a1.add(5);
    a1.add(87);
    a1.remove(5);
    System.out.println(a1.toString());


  }
}
