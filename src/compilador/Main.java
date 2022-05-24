package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		
		String path="/home/lildop2/eclipse-workspace/compilador/src/compilador/teste5.txt";
		try {
			Lexer lex = new Lexer(path);
			Token tok=lex.scan();
			while ( !tok.toString().equals("65535")) {
				System.out.println(tok);
				tok=lex.scan();
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
