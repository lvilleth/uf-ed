import java.util.*;
import java.lang.*;

public class HASHIT{

  public static void main(String[] args) throws java.lang.Exception {
    int t,n;
    String line,op,key;
    String[] token;
    TabelaHash tabela;
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    while(t-- > 0){
      n = sc.nextInt();

      tabela = new TabelaHash();

      while(n-- > 0){
        line = sc.next();
        token = line.split(":");

        if(token[0].equals("ADD")){
          if(token.length == 2)
            tabela.insert(token[1]);
        }else{
          if(token.length == 2)
            tabela.delete(token[1]);
        }

      }

      tabela.print();
    }

  }

  static class TabelaHash{
    String array[];
    String vazio = "vazio";
    List<Integer> elementos;

    public TabelaHash(){
      array = new String[36000];
      elementos = new ArrayList<>(10);
    }

    public void print(){
      System.out.println(elementos.size());

      Collections.sort(elementos);

      for (Integer index : elementos ) {
        System.out.println(index+":"+array[index]);
      }

    }

    // Hash(key)=h(key) mod 101, where
    // h(key)=19 *(ASCII(a1)*1+...+ASCII(an)*n).
    public int hash(String key){
      int h = 0;

      for (int i = 0; i < key.length(); i++) {
        h += key.charAt(i)*(i + 1);
      }

      h *= 19;
      return h % 101;
    }

    public int find(String key){
      int index = hash(key);

      if(array[index] == null)
        return -1;

      if(array[index].equals(key))
        return index;
      else{//espalhamento
        //Hash(key)+j2+23*j) mod 101
        int newIndex;
        for (int i = 1; i < 20 ; i++) {
          newIndex = (index + i*i + 23*i) % 101;

          if(array[newIndex] == null)
            return -1;

          if(array[newIndex].equals(key))
            return newIndex;
        }
      }

      return -1;
    }

    public void insert(String key){
      int index = find(key);
      if(index == -1){
        index = hash(key);
        // checar se espaco eh vazio
        if((array[index] == null) || array[index] == vazio){
          array[index] = key;
          elementos.add(index);
        }else{ // espalhamento
          int newIndex;
          for (int i = 1; i < 20 ; i++) {
            newIndex = (index + i*i + 23*i) % 101;

            if((array[newIndex] == null) || (array[newIndex] == vazio)){
              array[newIndex] = key;
              elementos.add(newIndex);
              break;
            }
          }

        }
      }

    }

    public void delete(String key){
      int index = find(key);

      if( index == -1){
        return;
      }

      if(array[index].equals(key)){
        array[index] = vazio;
        elementos.remove(Integer.valueOf(index));
      }

    }

  }

}
