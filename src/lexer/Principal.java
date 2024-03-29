package lexer;

import java.util.Hashtable;

public class Principal {

	public static void main(String[] args) {
		
		
		//String path="C:\\Users\\Abdul Kevin Alexis\\Documents\\compilador\\src\\compilador\\teste2.txt";
		if(args.length==0) {
			System.err.println("Usage: java -jar analisadorLexico [arquivo.txt]");
			System.exit(0);
		}
		String path=args[0];
		try {
			Lexer lex = new Lexer(path);
			Hashtable<Token, Integer> ts= new Hashtable<Token, Integer>();
			int i=1;
			Token tok=lex.scan();
			while ( !tok.equals(new Token(65535))) {
				System.out.println(tok);
				tok=lex.scan();
				
				ts.put(tok, i);
				i++;
				
			}
			
			System.out.println("Tabela de Simbolo\n==========================");
			System.out.println("id \t:\t Token");
			 ts.forEach((k, v) -> System.out.println(v + "\t:\t" + k));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
