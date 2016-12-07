import java.util.Iterator;

public class Token implements MDElement {
	String tString="";
	int type=0;
	public void setStyle(int i){type=i;}
	Token(String s){tString=s;}
	Token(){}
	ItemList nestedList=null;
    public void accept(MDElementVisitor v){};

}
