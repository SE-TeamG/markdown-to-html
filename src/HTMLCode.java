public class HTMLCode extends Token {
HTMLCode(String s){this.tString=s;}
	@Override
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}
