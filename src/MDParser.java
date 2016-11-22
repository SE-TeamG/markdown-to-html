import java.io.*;

public class MDParser{

	public Document document;

	public Document Parser(String mdfile){
		//file reading

		try{
		           BufferedReader fis = new BufferedReader(new FileReader(mdfile));
		           document=new Document();
		           String buffer;
		           while ((buffer = fis.readLine()) != null) {
					        System.out.println(buffer);
					        if(buffer.compareTo("")==0)
					        	continue;
					        Node n = new Node();
					        document.nlist.add(n.create(buffer));
    				}

		            fis.close();
		            System.out.println( "translated succesfully.");
		            return document;
		         }catch(Exception e){

		             System.out.println("ERROR: There is no such file.");
		             return null;

		         }

		}
}