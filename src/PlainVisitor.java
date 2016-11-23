import java.util.Iterator;

public class PlainVisitor implements MDElementVisitor {
    private String currentdir = "";
    public void visit(Document document) {
		//get all node from nlist in document and make it accept()
		document.nlist.get(0).accept(new PlainVisitor()); // the way to visit 'only' first node (it is example. you have to revise)

    }


    public void visit(Header h){
	try
         {
             FileWriter fw = new FileWriter("ex2.html");
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write("<h1>");
             bw.write((String)h.tlist.get(0).tString);
             bw.write("</h1>");
             
             bw.close();
         }
         catch (IOException e)
         {
             System.err.println(e);
             System.exit(1);
         }
	
	public void visit(QuotedBlock qb){}
}
