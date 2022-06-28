package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;

import lexer.Lexer;
import parser.Parser;

public class Main {

	public static void main(String[] args) throws IOException {
		Lexer lex=new Lexer(null);
		Parser parse =new Parser(lex);
		parse.program();
		

	}

}
