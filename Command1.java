import java.util.Scanner;
import java.io.FileInputStream;

public class Command{
	static String mdFileName;
	static String htmlFileName;
	static String styleName;

	public static void main(String[] args){

				System.out.println("This is markdown program.");
				System.out.println("************************************");
				System.out.println("this is a execution sequence of markdown ");
								System.out.println("	# SETTING ");

				System.out.println("	# NAME ");
				System.out.println("	# INPUT ");
				System.out.println("	# STYLE ");
				System.out.println("	# TRANSLATE ");
				System.out.println("	# HELP ");

				System.out.println("************************************");






					while(true){

							System.out.println("Enter what you want to try : ");
								Scanner scan = new Scanner(System.in);
								String s = scan.nextLine();

			if(s.compareTo("HELP")==0)
				HELP();
			else if(s.compareTo("SETTING")==0)
				SETTING();
			else if(s.compareTo("NAME")==0)
			{
				System.out.println("Enter the name : ");
				Scanner scan1 = new Scanner(System.in);
				String name = scan.nextLine();
				NAME(name);
			}
			else if(s.compareTo("INPUT")==0)
			{
							System.out.println("Enter the input : ");
							Scanner scan1 = new Scanner(System.in);
							String input = scan.nextLine();
							INPUT(input);

			}
			else if(s.compareTo("STYLE")==0)
			{
							System.out.println("Enter the style : ");
							Scanner scan1 = new Scanner(System.in);
							String name = scan.nextLine();
							STYLE(style);
			}
			else if(s.compareTo("TRANSLATE")==0)
				TRANSLATE();
			else
				System.out.println("ERROR: there is no such function.");

		}
	}



	static void TRANSLATE(){

	}
	static void HELP(){
		System.out.println("Thanks for asking! \n1. INPUT <file.md> -> get your md file\n2. (option)NAME <file.html> -> set yout html name. if you don't set it, the original file name is set to be the name of html file.");
		System.out.println("3. (option)STYLE <style name> -> set your style (ex: plain, fancy, slide) if you don't set it, plain style is selected automatically.\nSETTING -> show setting including input md name, output html file name, style name. \nTRANSLATE -> translate your file by setting.");

	}
	static void INPUT(String s){
		System.out.print("INPUT");

		try{
				FileInputStream fis = new FileInputStream(s);
				int data;
				while((data=fis.read())!= -1){
					System.out.print(">"+(char)data);
				}
				System.out.println("");
				fis.close();
			}catch(Exception e){
				 e.printStackTrace();
			}

			mdFileName=s;
			htmlFileName=s.substring(0,s.indexOf('.'))+".html";
			styleName="plain";
	}
	static void NAME(String s){
		htmlFileName=s;
	}
	static void STYLE(String s){
		if(s.compareTo("plain")==0)
				styleName="plain";
		else if(s.compareTo("fancy")==0)
			styleName="fancy";
		else if(s.compareTo("slide")==0)
			styleName="slide";
		else
			System.out.println("ERROR: WRONG style name. please use 'plain' or 'fancy' or 'slide'.");

	}
	static void SETTING(){
			System.out.println("MD FILE NAME : "+mdFileName);
			System.out.println("HTML FILE NAME : "+htmlFileName);
			System.out.println("STYLE NAME : "+styleName);

	}


}