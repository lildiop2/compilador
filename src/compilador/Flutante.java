package compilador;

public class Flutante extends Token{
	
	 public final float value;
	 public Flutante(float  value){
	 super(Tag.FLOAT);
	 this.value = value;
	 }
	 public String toString(){
	 return "" + value;
	 }
	}


