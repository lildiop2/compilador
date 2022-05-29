package compilador;

import java.util.*;

public class Env {
    private Hashtable table; //tabela de símbolos do ambiente
    protected Env prev; //ambiente imediatamente superior
   
    public Env(Env n){
    table = new Hashtable(); //cria a TS para o ambiente
    prev = n; //associa o ambiente atual ao anterior
    }
/*Este método insere uma entrada na TS do ambiente */
/*A chave da entrada é o Token devolvido pelo analisador léxico */
/*Id é uma classe que representa os dados a serem armazenados na TS para */
/*identificadores */
public void put(Token w, int i){
    table.put(w,i);
    }
   
   /*Este método retorna as informações (Id) referentes a determinado Token */
   /*O Token é pesquisado do ambiente atual para os anteriores */
    public int get(Token w){
    for (Env e = this; e!=null; e = e.prev){
    int found = (int) e.table.get(w);
    if (found != 0) //se Token existir em uma das TS
    return found;
    }
    return 0; //caso Token não exista em uma das TS
    }
   }