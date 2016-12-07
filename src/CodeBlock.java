public class CodeBlock extends Node {
	CodeBlock(){}

	@Override
	public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}