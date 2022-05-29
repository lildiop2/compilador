package compilador;

public class Inteiro extends Token{
	 public final int value;
	 public Inteiro(int value){
	 super(Tag.INT);
	 this.value = value;
	 
	 }
	 public String toString(){
		return "<" + this.tag+","+this.value+">";
	 }

}
