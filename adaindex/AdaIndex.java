import java.util.Scanner;

class AdaIndex{

  public static void main(String[] args) {
    int n,q,contador;
    int qtds[];
    String prefixo;
    String queries[];
    LSE<String> lista = new LSE<>();

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    q = sc.nextInt();
    qtds = new int[q];
    queries = new String[q];

    for (int i=0; i < n; i++) {
      lista.insere(1, sc.next());
    }

    for (int i=0; i < q; i++) {
      queries[i] = sc.next();
    }

    for(int j=0; j < n; j++){
      for (int i=0; i < q; i++) {
        prefixo = queries[i];
        if(lista.valor(1).startsWith(prefixo))
          qtds[i]++;
      }
      lista.remove(1);
    }

    for (int x : qtds ) {
      System.out.println(x);
    }
  }

  static class No <T> {
    private T valor;
    private No<T> proximo;

    public No(){
      proximo = null;
    }

    public void setProx(No<T> n){
      proximo = n;
    }
    public No<T> getProx(){
      return proximo;
    }
    public void setValor(T v){
      valor = v;
    }
    public T getValor(){
      return valor;
    }
  }

  //Lista simplesmente Encadeada
  static class LSE <T>{
    private No<T> cabeca;
    private int tamanho;

    public LSE(){
      cabeca = null;
      tamanho = 0;
    }

    public int getTamanho(){
      return tamanho;
    }

    public void insere(int pos, T valor){
      if(pos == 1)
        insereInicio(valor);
      else if (pos == tamanho + 1)
        insereFim(valor);
      else
        insereMeio(pos,valor);
    }

    private boolean insereInicio(T valor){
      No<T> aux = new No<T>();
      aux.setValor(valor);
      aux.setProx(cabeca);
      cabeca = aux;
      tamanho++;
      return true;
    }

    private boolean insereMeio(int pos, T valor){
      int cont = 1;
      No<T> novoNo;
      No<T> aux = cabeca;

      while (cont++ < pos-1 && aux != null) {
        aux = aux.getProx();
      }

      if(aux == null)
        return false;

      novoNo = new No<T>();
      novoNo.setValor(valor);
      novoNo.setProx(aux.getProx());
      aux.setProx(novoNo);
      tamanho++;
      return true;
    }

    private boolean insereFim(T valor){
      int cont = 1;
      No<T> novoNo;
      No<T> aux = cabeca;

      while(aux.getProx() != null){
        aux = aux.getProx();
      }
      novoNo = new No<T>();
      novoNo.setValor(valor);
      novoNo.setProx(null);
      aux.setProx(novoNo);
      tamanho++;

      return true;
    }

    private int posicao(T valor){
      int pos = 1;
      No<T> aux = cabeca;

      while(aux != null){
        if(aux.getValor() == valor)
          return pos;
        aux = aux.getProx();
        pos++;
      }

      return -1;
    }

    private T valor(int pos){
      int cont = 1;
      No<T> aux = cabeca;

      while((cont < pos) && (aux != null)){
        aux = aux.getProx();
        cont++;
      }
      if(aux == null)
        return null;

      return aux.getValor();
    }

    private boolean remove(int pos){
      if(pos == 1)
        cabeca = cabeca.getProx();
      return true;
    }
  }

}
