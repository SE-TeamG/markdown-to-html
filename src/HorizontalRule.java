public class HorizontalRule extends Node {
	
    HorizontalRule(){}

	@Override
	public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}