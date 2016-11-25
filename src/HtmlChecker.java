import org.w3c.tidy.Tidy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.w3c.dom.Document;

public class HtmlChecker{
	HtmlChecker(String htmlfilename){
		 try{
			System.out.print(htmlfilename);
			FileInputStream FIS=new FileInputStream(htmlfilename);
			FileOutputStream FOS=new FileOutputStream("revised_"+htmlfilename);
			Tidy tidy = new Tidy();
			Document D=tidy.parseDOM(FIS,FOS);
			tidy.parse(FIS,System.out);
			 }
			 catch (java.io.FileNotFoundException e)
			 {System.out.println(e.getMessage());}
		 }
}
