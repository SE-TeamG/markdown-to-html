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
		for(int i=0;i<document.nlist.size();i++)
			{
				document.nlist.get(i).accept(this);
				bw.write("\n");
			}
		bw.close();
	}catch (IOException e)
        {
            System.err.println(e);
            System.exit(1);
        }
    }

	public void visit(Node n){}
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
	public void visit(QuotedBlock qb){}
	public void visit(Token t){}
	public void visit(PlainText pt){try{bw.write(pt.tString);}catch (IOException e){}}

}
