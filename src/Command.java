import java.util.Scanner;
import java.io.FileInputStream;
public class Command{


	public static void main(String[] args){
		getFunction("gcc -plain ex.md -o ex2.html");

		while(true){
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			getFunction(s);

		}
	}

	static void getFunction(String s){


		if(s.compareTo("help")==0)
						HELP();
		else if(s.compareTo("exit")==0)
						System.exit(0);
		else if(s.length()>2&&s.substring(0,3).compareTo("gcc")==0)
		{
			String[] gcc_array=s.split(" ");
			//gcc -style <input.md> -o <output.html>

			//argument number check
			if(gcc_array.length!=5){
				System.out.println("ERROR: there is something missed argument. you should follow the next line's form.\ngcc -[style_name] [input.md] -o [output.html]");
				return;}
			//argument formation check
			if(gcc_array[1].charAt(0)!='-'||gcc_array[2].contains(".")==false||gcc_array[3].compareTo("-o")!=0||gcc_array[4].contains(".")==false)
			{
				System.out.println("ERROR: there is something wrong argument. you should follow the next line's form.\ngcc -[style_name] [input.md] -o [output.html]");
				return;
			}
			//input&output name check
			if(gcc_array[2].substring(gcc_array[2].indexOf(".")+1).compareTo("md")!=0)
			{
				System.out.println("ERROR: input file must be md file");
				return;
			}


			if(gcc_array[4].substring(gcc_array[4].indexOf(".")+1).compareTo("html")!=0)
			{
					System.out.println("ERROR: output file must be html file");
					return;
			}
			//style name check
			if(gcc_array[1].substring(1).compareTo("plain")!=0&&gcc_array[1].substring(1).compareTo("fancy")!=0&&gcc_array[1].substring(1).compareTo("slide")!=0)
						{
								System.out.println("ERROR: you wrote wrong style name");
								return;
						}


			MDParser mp = new MDParser();

			HTMLCodeGenerator cg=new HTMLCodeGenerator(mp.Parser(gcc_array[2]),gcc_array[1].substring(1),gcc_array[4]);


		}
		else
				System.out.println("ERROR: there is no such function.");
	}


	static void HELP(){
		System.out.println("Thanks for asking! you should follow next formation. missing argument is not acceptible. style can be 'plain', 'fancy', 'slide' only.\ngcc -[style_name] [input.md] -o [output.html]\n\t\tex) gcc -plain in.md -o out.html");

	}





}
