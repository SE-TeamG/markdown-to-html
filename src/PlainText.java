public class PlainText extends Token {

    PlainText(String s){super.tString=s;}
	@Override
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}
