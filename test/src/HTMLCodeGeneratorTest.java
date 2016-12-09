import org.junit.Test ;
import static org.junit.Assert.* ;

import java.io.*;

public class HTMLCodeGeneratorTest
{
	@Test
	public void testHTMLCodeGenerator() {

		Document d= new Document();
		d.nlist.add(new Node().create("#headline"));

		String s="";
		//HTMLCodeGenerator h = new HTMLCodeGenerator(d,"plain","ex.html") ;


	}
	@Test
		public void testNode() {
			Node n = new Node();

			assertTrue("Node failed",n.create("# this is header <b> wow </b> #").getClass().getSimpleName().compareTo("Header")==0) ;

			assertTrue("Node failed",n.create("* * *").getClass().getSimpleName().compareTo("HorizontalRule")==0) ;

			assertTrue("Node failed",n.create("> _wow_ what a __sad__").getClass().getSimpleName().compareTo("QuotedBlock")==0) ;

			assertTrue("Node failed",n.create("+ list").getClass().getSimpleName().compareTo("ItemList")==0) ;

			assertTrue("Node failed",n.create("1. list").getClass().getSimpleName().compareTo("OrderedItemList")==0) ;

			assertTrue("Node failed",n.create("this is <b> plain </b> * what*").getClass().getSimpleName().compareTo("Node")==0) ;

			assertTrue("Node failed",n.create("\t*code* block ").getClass().getSimpleName().compareTo("CodeBlock")==0) ;
	}

	@Test
	public void testCommand() {

		Command c = new Command();
		try{
			FileWriter fw = new FileWriter("ex.md");
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("1. list\n2. list ");
			bw.close();

			}catch(IOException e){}
		c.getFunction("gcc -plain ex.md -o ex.html");
		try{

		BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
             assertTrue(fis.readLine()=="<ol><li> list</li><li> list </li></ol>");




			}catch(IOException e){}



	}
	@Test
		public void testMDParser() {
		try{
			MDParser mp = new MDParser();
			FileWriter fw = new FileWriter("ex2.md");
			BufferedWriter bw=new BufferedWriter(fw);
     		bw.write("1. list\n2. list > hehe > ![]()");
     		bw.close();

			assertTrue(mp.Parser("ex2.md").nlist.get(0).getClass().getSimpleName().compareTo("OrderedItemList")==0);




		}catch(IOException e){}
	}

	public static void main(String [] args) {

		HTMLCodeGeneratorTest s = new HTMLCodeGeneratorTest() ;
	}
}
