package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionLearn {

  public  void  run() {
      var a = 12;
      List<Integer> numb =  Arrays.asList(1, 2, 3, 4, 5);
      Stream<Integer> stream = numb.stream();
      List<Integer> lstNumb = stream.filter(x-> x%2 != 0).toList();
      lstNumb.forEach(x -> System.out.println(x.toString()));
  }

  public  int Sum(int a,int b) {
      return a+b;
  }


}
