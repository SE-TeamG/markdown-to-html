import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Node implements MDElement {
	public String total="";
    public List<Token> tlist = new ArrayList<Token>();

    public void accept(MDElementVisitor v){};
    public Node create(String s){
			total=s;
			int i = 0;
			int num = 0;
			if(s.compareTo("")==0||s.compareTo(" ")==0||s.compareTo("\n")==0)
				return null;
			else if(s!=null&&s.charAt(0)=='#'){
				for(i = 0; i < s.length(); i++){
					if(s.charAt(i) == '#')
						num++;
				}


				Header h=new Header(num);
				node_added_tokens(h,total.substring(num));

				return h;

			}
			else{

				return new QuotedBlock();

			}
		}

	public void node_added_tokens(Node n,String removed_nodeMark_string){
		n.tlist.add(new PlainText(removed_nodeMark_string));
		}

}


