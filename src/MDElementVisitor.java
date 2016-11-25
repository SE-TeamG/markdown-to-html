public interface MDElementVisitor {

    public abstract void visit(Document document);
    public abstract void visit(Node node);
    public abstract void visit(Header h);
    public abstract void visit(QuotedBlock qb);
    public abstract void visit(Token t);
	public abstract void visit(PlainText pt);

}
