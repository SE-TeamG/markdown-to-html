public class Header extends Node {
	public int size = 1; // number of '#'
    Header(int n){
		if(n<7)size=n;
		else size=6;

	}

	@Override
    public void accept(MDElementVisitor v) {
        v.visit(this);
    }
}
