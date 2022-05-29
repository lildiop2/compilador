package compilador;

import java.util.Objects;

public class Token {
	 public final int tag; //constante que representa o token
	 public Token (int t){
	 tag = t;
	 }

	 public int getTag() {
		 return tag;
	 }
	 
	 

	 @Override
	public int hashCode() {
		return Objects.hash(tag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		return tag == other.tag;
	}

	public String toString(){
	 return "<" + this.tag+","+(char)this.tag+">";
	 }
	}
