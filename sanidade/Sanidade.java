import java.util.*;
import java.lang.*;

class Main{

  public static void main(String[] args) throws java.lang.Exception {
    long valor,anterior,proximo;
    No ptr1,ptr2,no,aux;
    LSE lista = new LSE();
    boolean sana = true;

    Scanner sc = new Scanner(System.in);
    valor    = Long.parseUnsignedLong(sc.next(), 16);
    anterior = Long.parseUnsignedLong(sc.next(), 16);
    proximo  = Long.parseUnsignedLong(sc.next(), 16);
    ptr1 = new No(valor,anterior,proximo);

    valor    = Long.parseUnsignedLong(sc.next(), 16);
    anterior = Long.parseUnsignedLong(sc.next(), 16);
    proximo  = Long.parseUnsignedLong(sc.next(), 16);
    ptr2 = new No(valor,anterior,proximo);

    lista.insere(ptr1);
    lista.insere(ptr2);

    //Preenche a lista com os nos
    while(sc.hasNext()){
      valor = Long.parseUnsignedLong(sc.next(), 16);
      anterior = Long.parseUnsignedLong(sc.next(), 16);
      proximo = Long.parseUnsignedLong(sc.next(), 16);
      no = new No(valor, anterior, proximo);

      lista.insere(no);
    }

    aux = ptr1;
    while(aux != ptr2) {
      no = aux;

      for (int i = 1; i <= lista.tamanho ; i++) {
        No n = lista.elemento(i);

        if((aux.valor == n.ant) && (aux.prox == n.valor)){
          aux = lista.remove(i);
          break;
        }
      }

      if(no.equals(aux)){
        sana = false;
        break;
      }
    }

    if(sana)
      System.out.println("sana");
    else
      System.out.println("insana");
  }

  static class No{
    long prox;
    long ant;
    long valor;

    public No(long v, long a, long p){
      valor = v;
      ant = a;
      prox = p;
    }
  }

  static class LSE{
    LNo cabeca;
    int tamanho;

    private class LNo{
      LNo prox;
      LNo ant;
      No conteudo;
    }

    //Insere na cabeca sempre
    private boolean insere(No valor){
      LNo aux = new LNo();
      aux.conteudo = valor;
      aux.prox = cabeca;
      cabeca = aux;
      tamanho++;
      return true;
    }

  	private No remove(int pos){
	     LNo atual = null, antecessor = null;
	     No dado = null;
	     int cont = 1;

	     /* Localiza o nó que será removido*/
	     atual = cabeca;
	     while((cont < pos) && (atual != null)){
	           antecessor = atual;
	           atual = atual.prox;
	           cont++;
	     }

	     if (atual == null) { /* pos. inválida */
	        return null;
	     }

	    /* retira o elemento da lista */
	    dado = atual.conteudo;
      if(antecessor != null)
        antecessor.prox = atual.prox;
	    tamanho--;

	    atual = null;
	    return dado;
    }

    public No elemento (int pos){
      LNo aux = cabeca;
      int  cont = 1;

      while(cont < pos){
        aux = aux.prox;
        cont++;
      }

      return aux.conteudo;
    }

  }
}
