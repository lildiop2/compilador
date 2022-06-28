package parser; 
import java.io.IOException;

import lexer.Lexer;
import lexer.Tag;
import lexer.Token;
public class Parser{

private Lexer lex;  //analisador 1éxico para este analisador sintático
private Token look; // lookahead tagen
Env top = null; //tabela de símbolos corrente ou do topo
int used = 0; 	// memória usada para declarações

public Parser (Lexer l) throws IOException { lex = l; move ();}
void move () throws IOException{ look = lex.scan (); }
void error (String s) {throw new Error ( "near line "+lex.line+ ": "+s);}
void match (int t) throws IOException {
if (look.tag == t ) move(); else error ( "syntax error ");

}
public void program() throws IOException {
	move(); //lê primeiro token
	match(Tag.RTN); 
	body();
	
	
}
private void body() throws IOException {
	match('[');
	decl_list();
	match(Tag.BEG);
	stmt_list();
	match(Tag.END);
	
}
private void stmt_list() throws IOException {
	
	switch (look.tag) {
	case Tag.ID: 
		match(Tag.ID);stmt(); match('{'); stmt();match('}');
		break;
		
	case Tag.RPT:
		match(Tag.RPT);stmt(); match('{'); stmt();match('}');
		break;
		
	case Tag.WHILE:
		match(Tag.WHILE);stmt(); match('{'); stmt();match('}');
		break;
		
	case Tag.READ:
		match(Tag.READ);stmt(); match('{'); stmt();match('}');
		break;
		
	case Tag.WRITE:
		match(Tag.WRITE);stmt(); match('{'); stmt();match('}');
		break;
	case Tag.IF:
		match(Tag.IF);stmt(); match('{'); stmt();match('}');
		break;

	default:
		
		break;
	}
	
}
private void stmt() {
	// TODO Auto-generated method stub
	
}
private void decl_list() throws IOException {
	match(Tag.DCL);
	dcl();
	match(';');
	match('{');
	dcl();
	match(';');
	match('}');
	
}
private void dcl() {
	// TODO Auto-generated method stub
	
}
}