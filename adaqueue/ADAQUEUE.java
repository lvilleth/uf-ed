import java.util.*;
import java.lang.*;

public class ADAQUEUE{

  public static void main(String[] args) throws java.lang.Exception {
    int num;
    int elem;
    String token;
    Fila fila = new Fila();

    Scanner sc = new Scanner(System.in);
    num = Integer.parseInt(sc.nextLine());

    while(num-- > 0){
      if(!sc.hasNext())
        break;
      token = sc.next();

      if(token.equals("back")){

        if(fila.vazia()){
          nojob();
        }else{
          elem = fila.back();
          job(elem);
        }

      }else if (token.equals("front")) {

        if(fila.vazia()){
          nojob();
        }else{
          elem = fila.front();
          job(elem);
        }

      }else if (token.equals("reverse")) {
        fila.reverse();
      }else if (token.equals("push_back")) {
        token = sc.next();
        fila.push_back(Integer.parseInt(token));
      }else if (token.equals("toFront")) {
        token = sc.next();
        fila.toFront(Integer.parseInt(token));
      }

    }

  }

  static void nojob(){
    System.out.println("No job for Ada?");
  }

  static void job(int elem){
    System.out.println(elem);
  }

  static class Fila{

    private class No{
      private int valor;
      private No  prox;
      private No  ant;

      public No(){
        prox = null;
      }

      public No getAnt(){
        return ant;
      }
      public void setAnt(No a){
        ant = a;
      }
      public int getValor(){
        return valor;
      }
      public void setValor(int v){
        valor = v;
      }
      public No getProx(){
        return prox;
      }
      public void setProx(No p){
        prox = p;
      }

    }

    private No inicio;
    private No fim;
    private int nElem;
    private boolean revert = false;

    public Fila(){
      nElem = 0;
      inicio = fim = null;
    }

    public boolean vazia(){
      if (nElem == 0)
        return true;
      else
        return false;
    }

    public int back(){
      int valor = fim.getValor();
      nElem--;

      if(revert){
        fim = fim.getProx();
        if(fim != null)
          fim.setAnt(null);
      }else{
        fim = fim.getAnt();
        if(fim != null)
          fim.setProx(null);
      }

      return valor;
    }

    public int front(){
      int valor = inicio.getValor();
      nElem--;

      if(revert){
        inicio = inicio.getAnt();
        if(inicio != null)
          inicio.setProx(null);
      }else{
        inicio = inicio.getProx();
        if(inicio != null)
          inicio.setAnt(null);
      }

      return valor;
    }

    public void reverse(){
      No aux = inicio;
      inicio = fim;
      fim = aux;

      revert = !revert;
    }

    public void push_back(int valor){
      No novoNo = new No();
      novoNo.setValor(valor);

      if(vazia()){
        inicio = fim = novoNo;
      }else{
        if(revert){
          novoNo.setProx(fim);
          fim.setAnt(novoNo);
        }else{
          novoNo.setAnt(fim);
          fim.setProx(novoNo);
        }
        fim = novoNo;
      }
      nElem++;
    }

    public void toFront(int valor){
      No novoNo = new No();
      novoNo.setValor(valor);

      if(vazia()){
        inicio = fim = novoNo;
      }else{
        if(revert){
          novoNo.setAnt(inicio);
          inicio.setProx(novoNo);
        }else{
          novoNo.setProx(inicio);
          inicio.setAnt(novoNo);
        }
        inicio = novoNo;
      }
      nElem++;
    }

  }


}
