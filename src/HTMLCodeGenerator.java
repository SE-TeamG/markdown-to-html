public class HTMLCodeGenerator{
HTMLCodeGenerator(Document d, String style, String htmlName){

		if(style.compareTo("plain")==0)

			d.accept(new PlainVisitor(htmlName));

	}
}