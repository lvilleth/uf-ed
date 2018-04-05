import java.util.*;
import java.lang.*;

public class ONP{

  public static void main(String[] args) throws java.lang.Exception {
    int num;
    String linha;
    StringBuilder output = new StringBuilder();
    Pilha  valores, sinais;
    char c;
    valores = new Pilha(400);
    sinais = new Pilha(400);

    Scanner sc = new Scanner(System.in);
    linha = sc.nextLine();
    num = Integer.parseInt(linha);

    while(num-- > 0){
      linha = sc.nextLine();

      for (int i=0; i < linha.length(); i++) {
        c = linha.charAt(i);

        if( c == '(')
          continue;

        if(c == ')'){
          valores.push(sinais.pop());
          continue;
        }

        if(isSinal(c)){
          sinais.push(c);
        }else{
          valores.push(c);
        }

      }

      while(!valores.vazia()){
        c = valores.pop();
        output.append(c);
      }
      System.out.println(output.reverse());
      output = new StringBuilder();
    }


  }

  public static boolean isSinal(char c){
    switch (c) {
      case '+':
      case '-':
      case '*':
      case '/':
      case '^':
        return true;
    }
    return false;
  }

  static class Pilha{

    private char dados[];
    private int topo;

    public Pilha(int tam){
      dados = new char[tam];
      topo  = -1;
    }

    public int tamanho(){
      return topo+1;
    }

    public char topo(){
      return dados[topo];
    }

    public boolean push(char c){
      dados[++topo] = c;
      return true;
    }

    public char pop(){
      char c = dados[topo--];
      return c;
    }

    public boolean vazia(){
      if(topo == -1)
        return true;
      else
        return false;
    }
  }

}
