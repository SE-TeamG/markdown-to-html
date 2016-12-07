import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Node implements MDElement {
	public String total="love";
	public String getTotal(){return total;}
    public List<Token> tlist = new ArrayList<Token>();
    public void accept(MDElementVisitor v){v.visit(this);};
    public Node create(String s){
			total=s;
			int i = 0;
			int num = 0;

			//Empty returned
			if(s.compareTo("")==0||s.compareTo(" ")==0||s.compareTo("\n")==0)
				return null;
			//Horizontal Rule
			if(s!=null&&s.length()>=5&&(s.substring(0,5).compareTo("* * *")==0 ||s.substring(0,5).compareTo("*****")==0
			||s.substring(0,5).compareTo("- - -")==0 || s.substring(0,5).compareTo("-----")==0))
			{
				return new HorizontalRule();
			}
			else if(s!=null&&s.length()>=3&&(
			 s.substring(0,3).compareTo("***")==0)){

				return new HorizontalRule();

			}
			//Headline
			else if(s!=null&&s.charAt(0)=='#'){

				for(i = 0; i < s.length(); i++){

					if(s.charAt(i) != '#')
						break;
						num++;
				}
				Header h=new Header(num);

				node_added_tokens(h,headerTail(s.substring(num)));
				h.total=s.substring(num);
				return h;
			}
			//QuotedBlock
			else if(s!=null&&s.charAt(0)=='>'){

				QuotedBlock qb=new QuotedBlock();
				qb.total=s.substring(1);
				node_added_tokens(qb,qb.total);
				return qb;
			}

			//Unordered List
			else if(s!=null&&(s.charAt(0)=='*'&&checkList(s)||s.charAt(0)=='+'||s.charAt(0)=='-')){
					ItemList il = new ItemList();
					il.total=s.substring(1);
					node_added_tokens(il,il.total);
					//il.tlist.add(new ListToken(il.total));

					return il;
				}
			//Ordered List
			else if(s!=null && s.matches("[0-9]+[.].*")){


					OrderedItemList oil = new OrderedItemList();
					oil.total=s.substring(s.indexOf(".")+1);
					//oil.tlist.add(new ListToken(oil.total));
					node_added_tokens(oil,oil.total);
					return oil;

			}
			//code block
			else if(s!=null&&(s.length()>3&&s.substring(0,4).compareTo("    ")==0||s.charAt(0)=='\t'))
			{
				CodeBlock cb=new CodeBlock();
				cb.total=s.substring(1);
				node_added_tokens(cb,cb.total);
				return cb;
			}
			//otherwise it is <p>
			else{

				Node n=new Node();
				n.total=s;
				node_added_tokens(n,s);
				return n;
			}

		}
	public int findLastIndex(String str, String token){ // second token's end position 	**	**
		String t=str.substring(str.indexOf(token)+token.length()); // remove first token 	 ^here
		return str.length()-t.length()+t.indexOf(token)+token.length()-1;
		}
	public void node_added_tokens(Node n,String s){

	//final token
	  	if(s.matches("!\\[.*\\]\\(.*\\)")) // image ![]()
				{
					StyleText st=new StyleText(s);
					st.setStyle(2);
					n.tlist.add(st);
		}
	  	else if(s.matches("\\[.*\\]\\(.*\\)")) // link    [] http...
	  	{
			StyleText st=new StyleText(s);
			st.setStyle(1);
			n.tlist.add(st);
		}
	  	else if(s.matches("http://.*"))
	  	{
			StyleText st=new StyleText("["+s+"]("+s+")");
	  		st.setStyle(1);
			n.tlist.add(st);
		}

		else if(s.matches("[*][*].*[*][*]")) //bold  * *
			  	{
					StyleText st=new StyleText(s.substring(2,s.length()-2));
					st.setStyle(3);
			  		n.tlist.add(st);
		}
	  	else if(s.matches("[*].*[*]")) //bold  * *
	  	{
			StyleText st=new StyleText(s.substring(1,s.length()-1));
			st.setStyle(3);
			n.tlist.add(st);
		}


	  	else if(s.matches("[_][_].*[_][_]")) //italic
			  	{

					StyleText st=new StyleText(s.substring(2,s.length()-2));
					st.setStyle(4);
			  		n.tlist.add(st);
		}
	  	else if(s.matches("[_].*[_]")) //italic
	  	{
			StyleText st=new StyleText(s.substring(1,s.length()-1));
			st.setStyle(4);
	  		n.tlist.add(st);
		}


	  	else if(s.matches("'.*'")) //inline code
	  	{
			StyleText st=new StyleText(s.substring(1,s.length()-1));
			st.setStyle(5);
	  		n.tlist.add(st);
		}

	  	else if(s.matches("<.*>.*</.*>")) //HTML  <  >...>
	        n.tlist.add(new HTMLCode(s));

	//special+something


		else if(s.matches("\\s*!\\[.*\\]\\(.*\\).+")) // image []()
		     	{
					node_added_tokens(n,s.substring(0,s.indexOf(")")+1));
			  		node_added_tokens(n,s.substring(s.indexOf(")")+1,s.length()));
		}

	  	else if(s.matches("\\s*\\[.*\\]\\(.*\\).+")) // link    []() http...
		{
			node_added_tokens(n,s.substring(0,s.indexOf(")")+1));
	  		node_added_tokens(n,s.substring(s.indexOf(")")+1,s.length()));
		}
		else if(s.matches("http://.*\\s+.*")) // whole link
			 	{node_added_tokens(n,s.substring(0,s.indexOf(" ")));
			  	node_added_tokens(n,s.substring(s.indexOf(" ")+1,s.length()));}

		else if(s.matches("\\s*[*][*].*[*][*].+"))
				{
					node_added_tokens(n,s.substring(0,findLastIndex(s,"**")+1));
			  		node_added_tokens(n,s.substring(findLastIndex(s,"**")+1,s.length()));
		}
		else if(s.matches("\\s*[*].*[*].+")) //bold  * *
		{
			node_added_tokens(n,s.substring(0,findLastIndex(s,"*")+1));
	  		node_added_tokens(n,s.substring(findLastIndex(s,"*")+1,s.length()));
		}


		else if(s.matches("\\s*[_][_].*[_][_].+"))
						{
							node_added_tokens(n,s.substring(0,findLastIndex(s,"__")+1));
					  		node_added_tokens(n,s.substring(findLastIndex(s,"__")+1,s.length()));
		}
	  	else if(s.matches("\\s*[_].*[_].+")) //italic _ _
				{
					node_added_tokens(n,s.substring(0,findLastIndex(s,"_")+1));
			  		node_added_tokens(n,s.substring(findLastIndex(s,"_")+1,s.length()));
				}


		else if(s.matches("\\s*'.*'.+")) // inline code   ' '
						{
							node_added_tokens(n,s.substring(0,findLastIndex(s,"'")+1));
					  		node_added_tokens(n,s.substring(findLastIndex(s,"'")+1,s.length()));
						}



		else if(s.matches("\\s*<.*>.*</.*>.+"))//HTML  <  >...>
						{
							node_added_tokens(n,s.substring(0,findLastIndex(s,">")+1));
					  		node_added_tokens(n,s.substring(findLastIndex(s,">")+1,s.length()));
						}

	    else{ //plain + something



			if(s.matches(".+\\s*!\\[.*\\]\\(.*\\).*")) // image []()
						{
							node_added_tokens(n,s.substring(0,s.indexOf("!")));
							node_added_tokens(n,s.substring(s.indexOf("!"),s.length()));
			}
			else if(s.matches(".+\\s*\\[.*\\]\\(.*\\).*")) // link    [] http...
			{
				node_added_tokens(n,s.substring(0,s.indexOf("[")));
				node_added_tokens(n,s.substring(s.indexOf("["),s.length()));
			}
			else if(s.matches(".+http://.*\\s.*")) // whole link
						{
							node_added_tokens(n,s.substring(0,s.indexOf("h")));
							node_added_tokens(n,s.substring(s.indexOf("h"),s.length()));
			}
			else if(s.matches(".+\\s*[*][*].*[*][*].*"))
						{
							node_added_tokens(n,s.substring(0,s.indexOf("**")));
							node_added_tokens(n,s.substring(s.indexOf("**"),s.length()));
			}
			else if(s.matches(".+\\s*[*].*[*].*")) //bold  * *
			{
				node_added_tokens(n,s.substring(0,s.indexOf("*")));
				node_added_tokens(n,s.substring(s.indexOf("*"),s.length()));
			}

			else if(s.matches(".+\\s*[_][_].*[_][_].*"))
								{
									node_added_tokens(n,s.substring(0,s.indexOf("__")));
									node_added_tokens(n,s.substring(s.indexOf("__"),s.length()));
			}

			else if(s.matches(".+\\s*[_].*[_].*")) //italic _ _
					{
						node_added_tokens(n,s.substring(0,s.indexOf("_")));
						node_added_tokens(n,s.substring(s.indexOf("_"),s.length()));
					}

			else if(s.matches(".+\\s*'.*'.*")) // inline code   ' '
							{
								node_added_tokens(n,s.substring(0,s.indexOf("'")));
								node_added_tokens(n,s.substring(s.indexOf("'"),s.length()));
							}
			else if(s.matches(".+\\s*<.*>.*</.*>.*"))//HTML  <  >...>
							{
								node_added_tokens(n,s.substring(0,s.indexOf("<")));
								node_added_tokens(n,s.substring(s.indexOf("<"),s.length()));
							}
			else //plain
					n.tlist.add(new PlainText(s));

		}
	}
	boolean checkList(String s){ // this is for differentiation of *list and *emphasize*
			if(s.matches("[*].*[*].*"))
				return false;
			return true;
	}

	public String headerTail(String s){
		if(s.charAt(s.length()-1)=='#'){
				s=headerTail(s.substring(0,s.length()-1));
		}
			return s;
	}


}


