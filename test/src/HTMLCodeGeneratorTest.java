import org.junit.Test ;
import static org.junit.Assert.* ;

import java.io.*;

public class HTMLCodeGeneratorTest
{
	
	@Test
		public void testNode() {
			Node n = new Node();

			assertTrue("Node failed",n.create("# this is header <b> wow </b> #").getClass().getSimpleName().compareTo("Header")==0) ;

			assertTrue("Node failed",n.create("####### this is header2 <b> wow </b> #").getClass().getSimpleName().compareTo("Header")==0) ;


			assertTrue("Node failed",n.create("* * *").getClass().getSimpleName().compareTo("HorizontalRule")==0) ;

			assertTrue("Node failed",n.create("> _wow_ what a __sad__").getClass().getSimpleName().compareTo("QuotedBlock")==0) ;

			assertTrue("Node failed",n.create("+ list").getClass().getSimpleName().compareTo("ItemList")==0) ;

			assertTrue("Node failed",n.create("1. list").getClass().getSimpleName().compareTo("OrderedItemList")==0) ;

			assertTrue("Node failed",n.create("this is <b> plain </b> * what*").getClass().getSimpleName().compareTo("Node")==0) ;

			assertTrue("Node failed",n.create("\t*code* block ").getClass().getSimpleName().compareTo("CodeBlock")==0) ;

			assertTrue("Node failed",n.create("# this is header <b> wow </b> #").getClass().getSimpleName().compareTo("Header")==0) ;

	}

	@Test
	public void testCommand() {

		Command c = new Command();
		try{
			FileWriter fw = new FileWriter("ex.md");
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("1.list\n2.list");
			bw.close();

			}catch(IOException e){}
		c.getFunction("gcc -plain ex.md -o ex.html");
		try{

		BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
		fis.readLine();
		String s=fis.readLine();

             assertTrue("error TT "+s,s.compareTo("<ol><li>list</li><li>list</li></ol>")==0);
             fis.close();
			}catch(IOException e){}
	}
	@Test
		public void testCommand2() {

			Command c = new Command();
			try{
				FileWriter fw = new FileWriter("ex.md");
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write("**this is** [image](noImageNow.png)");
				bw.close();

				}catch(IOException e){}
			c.getFunction("gcc -plain ex.md -o ex.html");
			try{

			BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
			fis.readLine();
			String s=fis.readLine();

	             assertTrue("error TT "+s,s.compareTo("<p><b>this is</b> <a href=\"noImageNow.png\">image</a></p>")==0);
	             fis.close();
				}catch(IOException e){}
	}
	@Test
			public void testCommand3() {

				Command c = new Command();
				try{
					FileWriter fw = new FileWriter("ex.md");
					BufferedWriter bw=new BufferedWriter(fw);
					bw.write("#this is header\n###headerrrr");
					bw.close();

					}catch(IOException e){}
				c.getFunction("gcc -plain ex.md -o ex.html");
				try{

				BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
				fis.readLine();
				String s=fis.readLine();

		             assertTrue("error TT "+s,s.compareTo("<h1>this is header</h1>")==0);
		             fis.close();
					}catch(IOException e){}
	}
@Test
			public void testCommand4() {

				Command c = new Command();
				try{
					FileWriter fw = new FileWriter("ex.md");
					BufferedWriter bw=new BufferedWriter(fw);
					bw.write(">quoted\n>block");
					bw.close();

					}catch(IOException e){}
				c.getFunction("gcc -plain ex.md -o ex.html");
				try{

				BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
				fis.readLine();
				String s=fis.readLine();

		             assertTrue("error TT "+s,s.compareTo("<blockquote cite=\"http://www.worldwildlife.org/who/index.html\">quoted</br>block</blockquote>")==0);
		             fis.close();
					}catch(IOException e){}
	}
	@Test
				public void testCommand5() {

					Command c = new Command();
					try{
						FileWriter fw = new FileWriter("ex.md");
						BufferedWriter bw=new BufferedWriter(fw);
						bw.write("* * *");
						bw.close();

						}catch(IOException e){}
					c.getFunction("gcc -plain ex.md -o ex.html");
					try{

					BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
					fis.readLine();
					String s=fis.readLine();

			             assertTrue("error TT "+s,s.compareTo("<hr/>")==0);
			             fis.close();
						}catch(IOException e){}
	}
	@Test
				public void testCommand6() {

					Command c = new Command();
					try{
						FileWriter fw = new FileWriter("ex.md");
						BufferedWriter bw=new BufferedWriter(fw);
						bw.write("+list\n+list2");
						bw.close();

						}catch(IOException e){}
					c.getFunction("gcc -plain ex.md -o ex.html");
					try{

					BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
					fis.readLine();
					String s=fis.readLine();

			             assertTrue("error TT "+s,s.compareTo("<ul><li>list</li><li>list2</li></ul>")==0);
			             fis.close();
						}catch(IOException e){}
	}
	@Test
					public void testCommand7() {

						Command c = new Command();
						try{
							FileWriter fw = new FileWriter("ex.md");
							BufferedWriter bw=new BufferedWriter(fw);
							bw.write("\tcodeblock\n\thehe");
							bw.close();

							}catch(IOException e){}
						c.getFunction("gcc -plain ex.md -o ex.html");
						try{

						BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
						fis.readLine();
						String s=fis.readLine();

				             assertTrue("error TT "+s,s.compareTo("<pre><code>codeblock")==0);
				             s=fis.readLine();
				             assertTrue("error TT "+s,s.compareTo("</br>")==0);
				             s=fis.readLine();
				             assertTrue("error TT "+s,s.compareTo("hehe</code></pre>")==0);
				             fis.close();
							}catch(IOException e){}
	}
	@Test
						public void testCommand8() {

							Command c = new Command();
							try{
								FileWriter fw = new FileWriter("ex.md");
								BufferedWriter bw=new BufferedWriter(fw);
								bw.write("<em>dom</em> ![image](not.png) _hehe_**what**'printf();'");
								bw.close();

								}catch(IOException e){}
							c.getFunction("gcc -plain ex.md -o ex.html");
							try{

							BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
							fis.readLine();
							String s=fis.readLine();

					             assertTrue("error TT "+s,s.compareTo("<p><em>dom</em> <img src=\"not.png\" alt=\"image\"/> <i>hehe</i><b>what</b><code>printf();</code></p>")==0);
					             s=fis.readLine();

								}catch(IOException e){}
	}
@Test
						public void testCommand9() {

							Command c = new Command();
							try{
								FileWriter fw = new FileWriter("ex.md");
								BufferedWriter bw=new BufferedWriter(fw);
								bw.write("http://www.naver.com");
								bw.close();

								}catch(IOException e){}
							c.getFunction("gcc -plain ex.md -o ex.html");
							try{

							BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
							fis.readLine();
							String s=fis.readLine();

					             assertTrue("error TT "+s,s.compareTo("<p><a href=\"http://www.naver.com\">http://www.naver.com</a></p>")==0);


								}catch(IOException e){}
	}
	@Test
	public void testHTMLCodeGenerator() {

		Document d= new Document();
		d.nlist.add(new Node().create("#headline"));

		String s="";
		//HTMLCodeGenerator h = new HTMLCodeGenerator(d,"plain","ex.html") ;


	}
@Test
						public void testCommand10() {

							Command c = new Command();
							try{
								FileWriter fw = new FileWriter("ex.md");
								BufferedWriter bw=new BufferedWriter(fw);
								bw.write("[L](http://www.google.com) wow");
								bw.close();

								}catch(IOException e){}
							c.getFunction("gcc -plain ex.md -o ex.html");
							try{

							BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
							fis.readLine();
							String s=fis.readLine();

					             assertTrue("error TT "+s,s.compareTo("<p><a href=\"http://www.google.com\">L</a> wow</p>")==0);

								}catch(IOException e){}
	}
@Test
						public void testCommand11() {

							Command c = new Command();
							try{
								FileWriter fw = new FileWriter("ex.md");
								BufferedWriter bw=new BufferedWriter(fw);
								bw.write("***");
								bw.close();

								}catch(IOException e){}
							c.getFunction("gcc -plain ex.md -o ex.html");
							try{

							BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
							fis.readLine();
							String s=fis.readLine();

					             assertTrue("error TT "+s,s.compareTo("<hr/>")==0);

								}catch(IOException e){}
	}
	@Test
							public void testCommand12() {

								Command c = new Command();
								try{
									FileWriter fw = new FileWriter("ex.md");
									BufferedWriter bw=new BufferedWriter(fw);
									bw.write("***\n***");
									bw.close();

									}catch(IOException e){}
								c.getFunction("gcc -plain ex.md -o ex.html");
								try{

								BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
								fis.readLine();
								String s=fis.readLine();

						             assertTrue("error TT "+s,s.compareTo("<hr/>")==0);
						             s=fis.readLine();

						             assertTrue("error TT "+s,s.compareTo("<hr/>")==0);

									}catch(IOException e){}
		}
@Test
							public void testCommand13() {

								Command c = new Command();
								try{
									FileWriter fw = new FileWriter("ex.md");
									BufferedWriter bw=new BufferedWriter(fw);
									bw.write("");
									bw.close();

									}catch(IOException e){}
								c.getFunction("gcc -plain ex.md -o ex.html");
								try{

								BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
								fis.readLine();
								String s=fis.readLine();

						             assertTrue("error TT "+s,s.compareTo("</html>")==0);

									}catch(IOException e){}
		}

@Test
							public void testCommand14() {

								Command c = new Command();
								try{
									FileWriter fw = new FileWriter("ex.md");
									BufferedWriter bw=new BufferedWriter(fw);
									bw.write("*\n*</br>");
									bw.close();

									}catch(IOException e){}
								c.getFunction("gcc -plain ex.md -o ex.html");
								try{

								BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
								fis.readLine();
								String s=fis.readLine();

						             assertTrue("error TT "+s,s.compareTo("<ul><li></li><li></li></ul>")==0);

									}catch(IOException e){}
		}

		@Test
									public void testCommand15() {

										Command c = new Command();
										try{
											FileWriter fw = new FileWriter("ex.md");
											BufferedWriter bw=new BufferedWriter(fw);

											bw.close();

											}catch(IOException e){}
										c.getFunction("gcc -plain ex.md -o ex.html");
										try{

										BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
										fis.readLine();
										String s=fis.readLine();

								             assertTrue("error TT "+s,s.compareTo("</html>")==0);

											}catch(IOException e){}
		}
@Test
									public void testCommand16() {

										Command c = new Command();
										try{
											FileWriter fw = new FileWriter("ex.md");
											BufferedWriter bw=new BufferedWriter(fw);
											bw.write("'love' hey **do**");
											bw.close();

											}catch(IOException e){}
										c.getFunction("gcc -plain ex.md -o ex.html");
										try{

										BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
										fis.readLine();
										String s=fis.readLine();

								             assertTrue("error TT "+s,s.compareTo("<p><code>love</code> hey <b>do</b></p>")==0);

											}catch(IOException e){}
		}
			@Test
											public void testNode2() {

												assertTrue(new Node().findLastIndex("*love* hey *done*","*")==5);
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

@Test
									public void testCommand17() {

										Command c = new Command();
										try{
											FileWriter fw = new FileWriter("ex.md");
											BufferedWriter bw=new BufferedWriter(fw);
											bw.write("la 'love' hey **do**");
											bw.close();

											}catch(IOException e){}
										c.getFunction("gcc -plain ex.md -o ex.html");
										try{

										BufferedReader fis = new BufferedReader(new FileReader("ex.html"));
										fis.readLine();
										String s=fis.readLine();

								             assertTrue("error TT "+s,s.compareTo("<p>la <code>love</code> hey <b>do</b></p>")==0);

											}catch(IOException e){}
		}

	public static void main(String [] args) {

		HTMLCodeGeneratorTest s = new HTMLCodeGeneratorTest() ;
	}
}
