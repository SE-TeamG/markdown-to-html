public class Header extends Node {
	public int size = 1; // number of '#'
    Header(int n){
		size=n;
	}

	@Override
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}
