package compilador;

public class Word extends Token{
	 private String lexeme = "";
	//  public static final Word and = new Word ("and", Tag.AND);
	//  public static final Word or = new Word ("or", Tag.OR);
	//  public static final Word eq = new Word ("=", Tag.EQ);
	 public static final Word ne = new Word ("<>", Tag.NE);
	 public static final Word le = new Word ("<=", Tag.LE);
	 public static final Word ge = new Word (">=", Tag.GE);
	 public Word (String s, int tag){
	 super (tag);
	 lexeme = s;
	 }
	 public String toString(){
	 return "" + lexeme;
	 }
	public String getLexeme() {
		// TODO Auto-generated method stub
		return lexeme;
	}
	}
