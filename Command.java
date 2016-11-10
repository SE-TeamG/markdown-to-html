import java.util.Scanner;
import java.io.FileInputStream;
public class Command{
	static String mdFileName;
	static String htmlFileName;
	static String styleName;

	public static void main(String[] args){
		while(true){
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			getFunction(s);


		}
	}

	static void getFunction(String s){
		if(s.compareTo("HELP")==0)
						HELP();
					else if(s.compareTo("SETTING")==0)
						SETTING();
					else if(s.length()>3&&s.substring(0,4).compareTo("NAME")==0&&s.charAt(4)==' ')
						NAME(s.substring(5));
					else if(s.length()>4&&s.substring(0,5).compareTo("INPUT")==0&&s.charAt(5)==' ')
						INPUT(s.substring(6));
					else if(s.length()>4&&s.substring(0,5).compareTo("STYLE")==0&&s.charAt(5)==' ')
						STYLE(s.substring(6));
					else if(s.length()>8&&s.substring(0,9).compareTo("TRANSLATE")==0)
						TRANSLATE();
					else
				System.out.println("ERROR: there is no such function.");
	}

	static void TRANSLATE(){
		if(mdFileName==null)
			System.out.println("you should give an input file first.");
	}
	static void HELP(){
		System.out.println("Thanks for asking! \n1. INPUT <file.md> -> get your md file\n2. (option)NAME <file.html> -> set yout html name. if you don't set it, the original file name is set to be the name of html file.");
		System.out.println("3. (option)STYLE <style name> -> set your style (ex: plain, fancy, slide) if you don't set it, plain style is selected automatically.\n4. SETTING -> show setting including input md name, output html file name, style name. \n5. TRANSLATE -> translate your file by setting.");

	}
	static void INPUT(String s){
		boolean dataIn = true;
		try{
				FileInputStream fis = new FileInputStream(s);
				int data;
				/*while((data=fis.read())!= -1){
					System.out.print(">"+(char)data);
				}*/
				System.out.println("");
				fis.close();
			}catch(Exception e){

				 System.out.println("ERROR: There is no such file.");
				 dataIn=false;
			}
			if(dataIn==true){
			mdFileName=s;
			htmlFileName=s.substring(0,s.indexOf('.'))+".html";
			styleName="plain";
		}
	}
	static void NAME(String s){
		if(mdFileName==null)
					System.out.println("ERROR: you should give an input file first.");
		else{

			if(s.contains(".")==true)
			{
				if(s.substring(s.indexOf(".")+1).compareTo("html")!=0)
					System.out.println("ERROR: you should use <name.html> format");
				else
					htmlFileName=s;
			}
			else
				htmlFileName=s+".html";

		}
	}
	static void STYLE(String s){
		if(mdFileName==null)
					System.out.println("ERROR: you should give an input file first.");
			else{
		if(s.compareTo("plain")==0)
				styleName="plain";
		else if(s.compareTo("fancy")==0)
			styleName="fancy";
		else if(s.compareTo("slide")==0)
			styleName="slide";
		else
			System.out.println("ERROR: WRONG style name. please use 'plain' or 'fancy' or 'slide'.");
	}
	}
	static void SETTING(){
		if(mdFileName==null)
			System.out.println("ERROR: you should give an input file first.");
			else{
			System.out.println("MD FILE NAME : "+mdFileName);
			System.out.println("HTML FILE NAME : "+htmlFileName);
			System.out.println("STYLE NAME : "+styleName);}

	}

}
