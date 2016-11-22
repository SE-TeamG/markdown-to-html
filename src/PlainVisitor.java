import java.util.Iterator;

public class PlainVisitor implements MDElementVisitor {
    private String currentdir = "";
    public void visit(Document document) {
		//document list ���� nlist���� node������ visit -> while���� .accept() �� ����.
System.out.print("\n\n\n TRANSLATED->\n");
		document.nlist.get(0).accept(new PlainVisitor()); // ù��° ��Ʈ�� visit �ϴ� ���(����)

    }


    public void visit(Header h){
		//outputfile�� <headline> ���
		System.out.print("<h1>"); // file�� ��� ������ ���Ƿ� ����Ʈ �ϵ��� �ص�.
		//token�� 'visit'�Ͽ� ���빰 ���
		System.out.print((String)h.tlist.get(0).tString); // ������ �ϳ��� ��������� ��� Ƽ����Ʈ�� ���� '��Ŀ� ���߾� ����ؾ���.
		//outputfile�� </headline> ���
		System.out.print("</h1>");
	}
	public void visit(Node n){
		System.out.println("why??");

		}
}
