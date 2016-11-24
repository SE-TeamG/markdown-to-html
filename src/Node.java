package helloworld;



import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Node implements MDElement  {
	
public String total="";
public List<Token> tlist = new ArrayList<Token>();
public List<Node> nlist = new ArrayList<Node>();
public Node(String tString){tString=total;}

	public Node create(String s){

			int pos;
			String s1="";
			total=s;
	
			if(s.compareTo("")==0||s.compareTo(" ")==0||s.compareTo("\n")==0)
				return null;
			else if(s!=null&&s.charAt(0)=='#'){
				int i=0;
				while(s.charAt(i)=='#')
				{i++;}

					Header h = new Header(i-1);
					h.tlist.add(new Token(s.substring(1))); // the way to insert just 'one' token. you have to revise it to insert all tokens.

					return h;//-----?
				}
			else if(s!=null&&s.charAt(0)=='>')
			{
				return new QuotedBlock();
			}
return null;
		}


//@Override
public void accept(MDElementVisitor v) {
	// TODO Auto-generated method stub
	
}

}






