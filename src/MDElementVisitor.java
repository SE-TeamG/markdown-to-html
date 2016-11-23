public interface MDElementVisitor {
    public abstract void visit(Document document);
    public abstract void visit(Header h);
    public abstract void visit(QuotedBlock qb);
}
