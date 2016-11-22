public class QuotedBlock extends Node {

    QuotedBlock(){

		}
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}
