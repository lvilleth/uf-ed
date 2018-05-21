import java.util.*;
import java.lang.*;

public class BST{

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t, n;

    ABP arv = new ABP();

    t = sc.nextInt();
    while(t-- > 0){
      n = sc.nextInt();

      arv.insere(n);
      System.out.println(arv.cont);
    }

  }

  static class ABP {
    No raiz;
    int cont = 0;

    private class No {
      No esq;
      No dir;
      int dado;

      private No(){
        esq = dir = null;
        dado = -1;
      }
    }

    private void insere(int valor){
      No novo = new No();
      novo.dado = valor;

      if(raiz == null){
        raiz = novo;
        return;
      }

      No aux = raiz;
      No p = aux;
      while(aux != null){
        p = aux;
        cont++;
        if(valor < aux.dado)
          aux = aux.esq;
        else
          aux = aux.dir;
      }

      if(valor < p.dado)
        p.esq = novo;
      else
        p.dir = novo;
    }

  }

}
