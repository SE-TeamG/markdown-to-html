import java.util.ArrayList;
import java.util.List;

public class Header {

	public List<Token> tlist = new ArrayList<Token>();

	public Header(int i){
		
		int num=i; 				//font size
			
	}
//	@Override
    public void accept (MDElementVisitor v) {
        v.visit(this);
    }

}
