import java.util.Iterator;

public class PlainVisitor implements MDElementVisitor {
    private String currentdir = "";
    public void visit(Document document) {
		//document list 내에 nlist에서 node꺼내서 visit -> while문과 .accept() 가 사용됨.
System.out.print("\n\n\n TRANSLATED->\n");
		document.nlist.get(0).accept(new PlainVisitor()); // 첫번째 노트를 visit 하는 방법(예제)

    }


    public void visit(Header h){
		//outputfile에 <headline> 출력
		System.out.print("<h1>"); // file에 써야 하지만 임의로 프린트 하도록 해둠.
		//token에 'visit'하여 내용물 출력
		System.out.print((String)h.tlist.get(0).tString); // 지금은 하나만 출력했지만 사실 티리스트들 전부 '양식에 맞추어 출력해야함.
		//outputfile에 </headline> 출력
		System.out.print("</h1>");
	}
	public void visit(Node n){
		System.out.println("why??");

		}
}
