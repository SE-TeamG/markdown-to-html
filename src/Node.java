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
				/*while( ){ // total �� token��� �и��� tlist�� add .

					//�̺κ��� MDParser���� document object�ȿ� node list�� node���� �߰��ϴ� ���� �����ϼſ�
				}*/
				h.tlist.add(new Token(s.substring(1))); // ���� �׽�Ʈ�� ����. ��ū�� �߰��ϴ� ���.

				return h;
				}
			else{

				return new QuotedBlock(); // ���� ���� ���

			}
		}



}
