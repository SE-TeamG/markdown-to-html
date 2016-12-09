import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class PlainVisitor implements MDElementVisitor {
    public String htmlFileName="";
     FileWriter fw;
     BufferedWriter bw;
    PlainVisitor(String name){htmlFileName=name;}
    public void visit(Document document) {
		try{
		fw = new FileWriter(htmlFileName);
         bw = new BufferedWriter(fw);
		bw.write("<html>\n");
		for(int i=0;i<document.nlist.size();i++)
			{

				document.nlist.get(i).accept(this);
				bw.write("\n");
			}
			bw.write("</html>");
		bw.close();
	}catch (IOException e)
        {
            System.err.println(e);
            System.exit(1);
        }
    }
	public void visit(){}
	public void visit(Node n){
		try
		        {
					bw.write("<p>");
					for(int i=0;i<n.tlist.size();i++){
						n.tlist.get(i).accept(this);
						}
					bw.write("</p>");
         }catch(IOException e){}
		}
    public void visit(Header h){
    	try
        {
			bw.write("<h"+h.size+">");
			for(int i=0;i<h.tlist.size();i++)
				h.tlist.get(i).accept(this);
			bw.write("</h"+h.size+">");
         }
        catch (IOException e)
        {
            System.err.println(e);
            System.exit(1);
        }
	}
	public void visit(QuotedBlock qb){
		try{
			bw.write("<blockquote cite=\"http://www.worldwildlife.org/who/index.html\">");
			for(int i=0;i<qb.tlist.size();i++){
				qb.tlist.get(i).accept(this);
				/*if(qb.tlist.size()!=1&&i!=qb.tlist.size()-1)
					bw.write("</br>");*/}
			bw.write("</blockquote>");
			}catch(IOException e){}

		}
	public void visit(HorizontalRule hr){

		try{
			bw.write("<hr/>");
			}
		catch(IOException e){
			}
		}
	public void visit(ItemList il){

			try{

						bw.write("<ul>");
						bw.write("<li>");
					for(int i=0;i<il.tlist.size();i++)
					{
						if(!il.tlist.get(i).tString.matches("\\s+")&&!il.tlist.get(i).tString.matches("\\s?</br>\\s?")){

						il.tlist.get(i).accept(this);

						}
					}
						bw.write("</li>");
						bw.write("</ul>");

			   }
			catch (IOException e)
			{
			    System.err.println(e);
			     System.exit(1);
	        }

	}
	public void visit(OrderedItemList il){

				try{


							bw.write("<ol>");
							bw.write("<li>");

						for(int i=0;i<il.tlist.size();i++)
						{
							if(!il.tlist.get(i).tString.matches("\\s+")
							&&
							!il.tlist.get(i).tString.matches("\\s?</br>\\s?")){

							il.tlist.get(i).accept(this);

							}
						}
							bw.write("</li>");
							bw.write("</ol>");

				   }
				catch (IOException e)
				{
				    System.err.println(e);
				     System.exit(1);
		        }

	}
	public void visit(CodeBlock cb){
			try{
			bw.write("<pre><code>" );
						for(int i=0;i<cb.tlist.size();i++){
							cb.tlist.get(i).accept(this);
							if(cb.tlist.size()!=1&&i!=cb.tlist.size()-1)
								bw.write("\n");}
			bw.write("</code></pre>");
		}catch(IOException e){}
		}

	public void visit(Token t){}
	public void visit(PlainText pt){try{bw.write(pt.tString);}catch (IOException e){}}
	public void visit(HTMLCode hc){try{bw.write(hc.tString);}catch (IOException e){}}

	// 1:link 2:image 3:bold 4:italic 5:inline
	public void visit(StyleText st){
		try{

		switch(st.type){
			case 0:break;
			case 1://bw.write(">>> "+st.tString);break;
			bw.write("<a href=\""+st.tString.substring(st.tString.indexOf("(")+1,st.tString.indexOf(")"))+"\">"+st.tString.substring(st.tString.indexOf("[")+1,st.tString.indexOf("]"))+"</a>");break;
			case 2:bw.write("<img src=\""+st.tString.substring(st.tString.indexOf("(")+1,st.tString.indexOf(")"))+"\" alt=\""+st.tString.substring(st.tString.indexOf("[")+1,st.tString.indexOf("]"))+"\"/>");break;
			case 3:bw.write("<b>"+st.tString+"</b>");break;
			case 4:bw.write("<i>"+st.tString+"</i>");break;
			case 5:bw.write("<code>"+st.tString+"</code>");break;

			}
		}catch(IOException e){}
		}

}
