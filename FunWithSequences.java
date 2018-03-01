import java.util.Scanner;

class FunWithSequences{

  public static void main(String[] args) {
    int n,m,valor;
    Lista<Integer> s1, s2;

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    s1 = new Lista<>(n);

    for(int i = 0; i < n; ){
      valor = sc.nextInt();
      s1.insere(++i, valor);
    }

    m = sc.nextInt();
    s2 = new Lista<>(m);
    for(int i = 0; i < m; ){
      valor = sc.nextInt();
      s2.insere(++i, valor);
    }

    for(int i = 0; i < s1.tamanho() ; i++){
      valor = s1.elemento(i + 1);
      if(s2.posicao(valor) == -1){
        System.out.print(valor);
        if(i != s1.tamanho() - 1)
          System.out.print(" ");
      }
    }
  }

  static class Lista <T>{
    private T elementos[];
    private int nElementos;

    public Lista(int tamanho){
      elementos = (T[]) new Object[tamanho];
      nElementos = 0;
    }

    public int tamanho(){
      return nElementos;
    }

    public boolean cheia(){
      if(nElementos == elementos.length)
        return true;
      else
        return false;
    }

    public boolean vazia(){
      if(nElementos == 0)
        return true;
      else
        return false;
    }

    public boolean insere(int pos, T dado){
      if(cheia() || pos > elementos.length + 1 || pos <= 0)
        return false;

      for (int i = nElementos; i >= pos ; ) {
        elementos[i] = elementos[--i];
      }

      elementos[pos - 1] = dado;
      nElementos++;

      return true;
    }

    public int posicao(T dado){
      for (int i=0; i < nElementos ;i++) {
        if(elementos[i].equals(dado))
            return i+1;
      }
      return -1;
    }

    public T elemento(int pos){
      if(vazia() || pos <= 0 || pos > nElementos)
        return null;

      return elementos[pos - 1];
    }
  }
}
