public class OrderedItemList extends Node {
	OrderedItemList(){}

	@Override
	public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}