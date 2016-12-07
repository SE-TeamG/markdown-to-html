import java.io.*;
//import java.lang.Class;
public class MDParser{

	public Document document;

	public Document Parser(String mdfile){
		//file reading

		try{
		           BufferedReader fis = new BufferedReader(new FileReader(mdfile));
		           document=new Document();
		           String buffer;
		           Node n = new Node();
		           Node pre = new Node();
		           while ((buffer = fis.readLine()) != null) {

					        if(buffer.compareTo("")==0)
					        	continue;

					       	if(	document.nlist.size()!=0 // Not a first node
								&&n.create(buffer).getClass().getSimpleName().compareTo(pre.getClass().getSimpleName())==0 // It's same as previous node
					       		&&n.create(buffer).getClass().getSimpleName().compareTo("Header")!=0
					       		&& n.create(buffer).getClass().getSimpleName().compareTo("HorizontalRule")!=0)	// excluding # header and </hr>
					       			{
										//try{bw.write("\n");}catch(IOException e){}

										Node nn=new Node();
										nn.create("\n"+buffer);
										String str="\n"+nn.create(buffer).getTotal();
										if(n.create(buffer).getClass().getSimpleName().compareTo("ItemList")==0||
										n.create(buffer).getClass().getSimpleName().compareTo("OrderedItemList")==0){
											new Node().node_added_tokens(document.nlist.get(document.nlist.size()-1),"</li><li>");}
										else
											new Node().node_added_tokens(document.nlist.get(document.nlist.size()-1),"</br>");
										new Node().node_added_tokens(document.nlist.get(document.nlist.size()-1),n.create(buffer).total);
									}


					        else
					        	{document.nlist.add(n.create(buffer));

					        pre=n.create(buffer);}
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