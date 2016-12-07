public interface MDElementVisitor {

	public abstract void visit();

    public abstract void visit(Document document);
    public abstract void visit(Node node);
    public abstract void visit(Header h);
    public abstract void visit(QuotedBlock qb);
    public abstract void visit(ItemList il);
    public abstract void visit(OrderedItemList il);
    public abstract void visit(HorizontalRule hr);
    public abstract void visit(CodeBlock cb);

    public abstract void visit(Token t);
	public abstract void visit(PlainText pt);
	public abstract void visit(ListToken lt);
	public abstract void visit(StyleText st);
	public abstract void visit(HTMLCode hc);

}
