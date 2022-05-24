package compilador;

public class Word extends Token {
	public String lexeme = "";
	public static final Word ne = new Word("<>", Tag.NE);
	public static final Word le = new Word("<=", Tag.LE);
	public static final Word ge = new Word(">=", Tag.GE);
	public static final Word atb = new Word(":=", Tag.ATB);

	public Word(String s, int tag) {
		super(tag);
		lexeme = s;
	}

	public String toString() {
		return "" + lexeme;
	}

	public String getLexeme() {
		// TODO Auto-generated method stub
		return lexeme;
	}
}
