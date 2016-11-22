import java.util.Iterator;

public class Token implements MDElement {
	String tString="";
	Token(String s){tString=s;}
    public void accept(MDElementVisitor v){};

}
