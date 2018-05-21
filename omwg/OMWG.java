import java.util.*;
import java.lang.*;

public class OMWG{

  public static void main(String[] args) throws java.lang.Exception {
    int t, linha, coluna, out;
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();

    while(t-- > 0){
      linha = sc.nextInt();
      coluna = sc.nextInt();

      out = 0;      
      out += 2*linha*coluna;
      out -= linha;
      out -= coluna;

      System.out.println(out);
    }

  }

}
