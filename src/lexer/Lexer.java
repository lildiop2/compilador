package lexer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Lexer {
	public static int line = 1; // contador de linhas
	private char ch = ' '; // caractere lido do arquivo
	private FileReader file;
	private Hashtable<String, Word> words = new Hashtable<String, Word>();

	/* Método para inserir palavras reservadas na HashTable */
	private void reserve(Word w) {
		words.put(w.getLexeme(), w); // lexema é a chave para entrada na
		// HashTable
	}

	/* Método construtor */
	public Lexer(String fileName) throws FileNotFoundException {
		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
			throw e;
		}
		// Insere palavras reservadas na HashTable
		reserve(new Word("routine", Tag.RTN));
		reserve(new Word("begin", Tag.BEG));
		reserve(new Word("end", Tag.END));
		reserve(new Word("declare", Tag.DCL));
		reserve(new Word("int", Tag.INT));
		reserve(new Word("float", Tag.FLOAT));
		reserve(new Word("char", Tag.CHAR));
		reserve(new Word("if", Tag.IF));
		reserve(new Word("then", Tag.THEN));
		reserve(new Word("else", Tag.ELSE));
		reserve(new Word("repeat", Tag.RPT));
		reserve(new Word("until", Tag.UNTL));
		reserve(new Word("while", Tag.WHILE));
		reserve(new Word("do", Tag.DO));
		reserve(new Word("read", Tag.READ));
		reserve(new Word("write", Tag.WRITE));
		reserve(new Word("not", Tag.NOT));
		reserve(new Word("or", Tag.OR));
		reserve(new Word("and", Tag.AND));
		// ...
	}

	/* Lê o próximo caractere do arquivo */
	private void readch() throws IOException {
		ch = (char) file.read();
	}

	/* Lê o próximo caractere do arquivo e verifica se é igual a c */
	private boolean readch(char c) throws IOException {
		readch();
		if (ch != c)
			return false;
		ch = ' ';
		return true;
	}

	public Token scan() throws IOException {
		// Desconsidera delimitadores na entrada
		for (;; readch()) {
			if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b')
				continue;
			else if (ch == '\n')
				line++;// conta linhas

			else
				break;
		}
		switch (ch) {
		// Operadores
		case '=':
			readch();
			return new Token('=');

		case '<':
			if (readch('='))
				return Word.le;
			else if (readch('>'))
				return Word.ne;
			else
				return new Token('<');
		case '>':
			if (readch('='))
				return Word.ge;
			else
				return new Token('>');
		case ':':
			if (readch('='))
				return Word.atb;
			else
				return new Token(':');
		case '"':
			readch();
			StringBuffer sb = new StringBuffer();
			while (ch!='"') {
				sb.append(ch);
				
				readch();
				if(ch==65535) throw new Error("Erro ao identificar literal na linha "+line);
				
				
			}
			readch();
			
			return new Word(sb.toString(), Tag.LTR);
		case 39:
			int c=0;
			readch();
			if(ch!=39) {
				c = ch;
			}
			if (readch((char) 39))
				return new Caractere(c);
			
		case '%':
			readch();
			while (ch!='%') {
				
				readch();
				if(ch==65535) throw new Error("Erro ao identificar comentario na linha "+line);
				
			}
			readch();
			
			break;

		}

		// Números
		if (Character.isDigit(ch)) {
			int value = 0;
			do {
				value = 10 * value + Character.digit(ch, 10);
				readch();
			} while (Character.isDigit(ch));

			if (ch != '.')
				return new Inteiro(value);

			float f = value;
			float d = 10;
			while (true) {
				readch();
				if (!Character.isDigit(ch))
					break;
				f += Character.digit(ch, 10) / d;
				d *= 10;
			}
			return new Flutante(f);
		}

		// Identificadores
		if (Character.isLetter(ch)) {
			StringBuffer sb = new StringBuffer();
			do {
				sb.append(ch);
				readch();
			} while (Character.isLetterOrDigit(ch));
			String s = sb.toString();
			Word w = (Word) words.get(s);
			if (w != null)
				return w; // palavra já existe na HashTable
			w = new Word(s, Tag.ID);
			words.put(s, w);
			return w;
		}

		// Caracteres não especificados
		Token t = new Token(ch);
		ch = ' ';
		return t;
	}
}