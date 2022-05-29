package compilador;

public class Caractere extends Token{
	
	 public final int value;
	 public Caractere(int value){
	 super(Tag.CHAR);
	 this.value = value;
	 
	 }
	 public String toString(){
		return "<" + tag+","+(char)this.value+">";
	 }

}
