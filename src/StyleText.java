public class StyleText extends Token {
StyleText(String s){this.tString=s;}
	@Override
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}
