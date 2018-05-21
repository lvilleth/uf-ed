import java.util.*;
import java.lang.*;

public class NICEBTREE{

  static char[] char_order;
  static int idx = 0;

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t;
    int h;
    String str_order;

    t = sc.nextInt();

    while(t-- > 0){
      str_order = sc.next();
      char_order = str_order.toCharArray();
      h = altura(char_order[0]);
      idx = 0;
      System.out.println(Math.max(0,h));
    }

  }

  static int altura(char c){
    if(c == 'l')
      return 0;
    else{
      int he = 0;
      int hd = 0;
      ++idx;
      if(idx < char_order.length){
        he = altura(char_order[idx]);
        ++idx;
        if(idx < char_order.length)
          hd = altura(char_order[idx]);
      }
      return 1+Math.max(he,hd);
    }
  }

}
