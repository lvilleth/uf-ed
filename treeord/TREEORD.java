import java.util.*;
import java.lang.*;

class TREEORD{

  static int pre[], pos[], in[];
  static ArvBin arv;

  static boolean correct = true;

  static int preIndex = 0;
  static int inIndex = 0;
  static int posIndex = 0;

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    pre = new int[n];
    pos = new int[n];
    in  = new int[n];

    int iRaiz = 0;
    // le os nos e preenche os array preordem, posordem, inordem
    for (int i = 0; i < 3 ; i++) {
      int x;
      for (int j = 0; j < n ; j++) {
        if(!sc.hasNextInt())
          break;

        x = sc.nextInt();
        switch (i) {
          case 0:
            pre[j] = x;
            break;
          case 1:
            pos[j] = x;
            break;
          case 2:
            in[j] = x;
            if(x == pre[0])
              iRaiz = j;
        }
      }
    }

    if(pre[0] != pos[n-1]){;
      no();
      return;
    }
    if((pre.length != pos.length) || (pre.length != in.length) || (in.length != pos.length)){
      no();
      return;
    }

    arv = new ArvBin();

    No raiz = preencheNo(0, n-1);
    arv.setRaiz(raiz);

    //System.out.print("pre: ");
    arv.preOrdem();
    //System.out.print("\n in: ");
    arv.inOrdem();
    //System.out.print("\npos: ");
    arv.posOrdem();
    //System.out.println();

    if(correct)
      yes();
    else
      no();
  }

  static No preencheNo(int inicio, int fim){

    if(inicio > fim)
      return null;

    int raiz = pre[preIndex++];
    No no = new No(raiz);

    //System.out.println(""+raiz+"  "+inicio+"  "+fim);
    if(inicio == fim){
      return no;
    }

    int index = indexIn(raiz,inicio,fim);

    //preencher a esquerda
    No esq = preencheNo(inicio, index - 1);
    if(esq != null)
      no.setEsq(esq);

    //preencher a direita
    No dir = preencheNo(index + 1, fim);
    if(dir != null)
      no.setDir(dir);

    return no;
  }

  static int indexIn(int raiz, int inicio, int fim){
    for (int i = inicio; i <= fim ; i++) {
      if(in[i] == raiz)
        return i;
    }
    return -1;
  }

  static void yes(){
    System.out.println("yes");
  }
  static void no(){
    System.out.println("no");
  }

  static class No{
    private int dado;
    private No esq;
    private No dir;

    public No(){
      esq = dir = null;
    }
    public No(int d){
      this();
      dado = d;
    }

    public int getDado(){
      return dado;
    }
    public void setDado(int d){
      dado = d;
    }
    public No getEsq(){
      return esq;
    }
    public void setEsq(No n){
      esq = n;
    }
    public No getDir(){
      return dir;
    }
    public void setDir(No n){
      dir = n;
    }

  }

  static class ArvBin {
    No raiz;

    public ArvBin(){
      raiz = null;
    }

    public void setRaiz(No r){
      raiz = r;
    }

    public No busca(int valor){
      return busca(raiz,valor);
    }

    private No busca(No N, int valor){
      if(N == null)
        return null;

      if(N.getDado() == valor)
        return N;

      No aux = busca(N.getEsq(), valor);
      if (aux == null)
        aux = busca(N.getDir(), valor);

      return aux;
    }
    public void preOrdem(){
      preOrdem(raiz);
    }
    private void preOrdem(No N){
      if (N == null)
        return;

      //System.out.print(""+N.getDado());

      if(N.getEsq() != null)
        preOrdem(N.getEsq());

      if(N.getDir() != null)
        preOrdem(N.getDir());
    }

    public void inOrdem(){
      inOrdem(raiz);
    }
    private void inOrdem(No N){
      if (N == null || !correct)
        return;

      if(N.getEsq() != null)
        inOrdem(N.getEsq());

      if(N.getDado() != in[inIndex++]){
        correct = false;
        return;
      }

      //System.out.print(""+N.getDado());

      if(N.getDir() != null)
        inOrdem(N.getDir());
    }

    public void posOrdem(){
      posOrdem(raiz);
    }
    private void posOrdem(No N){
      if (N == null || !correct)
        return;

      if(N.getEsq() != null)
        posOrdem(N.getEsq());

      if(N.getDir() != null)
        posOrdem(N.getDir());

      if(N.getDado() != pos[posIndex++]){
        correct = false;
        return;
      }

      //System.out.print(""+N.getDado());
    }

  }

}
