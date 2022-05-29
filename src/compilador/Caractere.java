package compilador;

public class Caractere extends Token {

	 public final int value;
	 public Caractere(int value){
	 super(Tag.CHAR);
	 this.value = value;
	 }
	@Override
	public String toString() {
		return "<" + this.tag+","+this.value+">";
	}
	 

}
