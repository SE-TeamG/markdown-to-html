import java.util.Iterator;

public class PlainVisitor implements MDElementVisitor {
    private String currentdir = "";
    public void visit(Document document) {
		//get all node from nlist in document and make it accept()
System.out.print("\n\n\n TRANSLATED->\n");
		document.nlist.get(0).accept(new PlainVisitor()); // the way to visit 'only' first node (it is example. you have to revise)

    }


    public void visit(Header h){
		//print <headline>. you have to revise it to print on new file.
		System.out.print("<h1>"); 
	    
		//token visit
		System.out.print((String)h.tlist.get(0).tString); //you have to revise it to visit 'all' tokens.
		//print </headline>
		System.out.print("</h1>");
	}
	public void visit(Node n){
		System.out.println("why??");

		}
	
	public void visit(QuotedBlock qb){}
}
