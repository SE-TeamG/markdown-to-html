public class ItemList extends Node {
	ItemList(){}

	@Override
	public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}