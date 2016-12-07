public class ListToken extends Token {

    ListToken(String s){super.tString=s;}
	@Override
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}