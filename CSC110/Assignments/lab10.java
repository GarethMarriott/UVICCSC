public class lab10{


  public static void main(String[] args) {
    // int[] a = {5,10,-9,3,-29,45,0,-78};
    // int answer = 9999999;
    // int input = -35;
    // for (int i = 0; a.length > i; i++) {
    //     int dif1 = a[i] - input;
    //     dif1 = Math.abs(dif1);
    //
    //     int dif2 = answer - input;
    //     dif2 = Math.abs(dif2);
    //
    //     if (dif1 < dif2) {
    //       answer = a[i];
    //     }
    // }
    // System.out.println(answer);

    int[] array = {1,4,5,9,7,2,3,6,8};
    array = bubbleSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);

    }
  }


  public static int[] bubbleSort(int[] arr){
    for (int j = 0; j < arr.length; j++) {
      for (int i = 0; i < arr.length-j ; i++) {
        if ((i+1) < arr.length) {
          if (arr[i] > arr[i+1]) {
            int holder = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = holder;
          }
        }
      }
    }
    return arr;

  }
}
