import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Node implements MDElement {
	public String total="";
    public List<Token> tlist = new ArrayList<Token>();

    public void accept(MDElementVisitor v){};
    public Node create(String s){
			total=s;
			if(s.compareTo("")==0||s.compareTo(" ")==0||s.compareTo("\n")==0)
				return null;
			else if(s!=null&&s.charAt(0)=='#'){
				Header h = new Header(1);
				/*while( ){ // 
				you have to parse total to several tokens and add them to tlist.
				the way it work is similar with the way add node in nlist which is excuted in node MDParser class.
				you can refer to MDParser class.
				}*/
				h.tlist.add(new Token(s.substring(1))); // the way to insert just 'one' token. you have to revise it to insert all tokens.

				return h;
				}
			else{

				return new QuotedBlock(); // you have to revise it like above.

			}
		}



}
