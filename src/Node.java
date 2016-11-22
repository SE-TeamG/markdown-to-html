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
				/*while( ){ // total 을 token들로 분리후 tlist에 add .

					//이부분은 MDParser에서 document object안에 node list에 node들을 추가하는 것을 참고하셔요
				}*/
				h.tlist.add(new Token(s.substring(1))); // 단지 테스트를 위함. 토큰을 추가하는 방법.

				return h;
				}
			else{

				return new QuotedBlock(); // 위와 같은 방식

			}
		}



}
