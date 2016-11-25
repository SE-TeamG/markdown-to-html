import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Document implements MDElement {
    public List<Node> nlist = new ArrayList<Node>();

	Document(){
		}
	public void accept(MDElementVisitor v){
		v.visit(this);
		};


}
