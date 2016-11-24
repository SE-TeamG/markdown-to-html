

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Token implements MDElement {
	
	public List<Token> tlist = new ArrayList<Token>();
	public List<Node> nlist = new ArrayList<Node>();
	
	String tString="";
	public Token(String s)
	{
		tString=s;
		int pos;
		String s1="";
		while(s.isEmpty()!=true){ // total 을 token들로 분리후 tlist에 add .
		//이부분은 MDParser에서 document object안에 node list에 node들을 추가하는 것을 참고하셔요

	if(s.charAt(0)=='*')
	{
		if(s.charAt(1)=='*')
		{
			pos=s.lastIndexOf('*',2)+1;
			s1=s.substring(0,pos);
			s=s.substring(pos,s.length());
			tlist.add(new Token(s1));
		}									//** aa**
		else
		{
			if(s.lastIndexOf('*',1)<0)
			{
				if(s.length()==tString.length())
				{
					nlist.add(new Node(tString));
				}
				else
				{
					plain(s,s1);
				}
			}
			else
			{
				pos =s.lastIndexOf('*',1)+1;
				s1 =s.substring(0,pos);
				s=s.substring(pos,s.length());
				tlist.add(new Token(s1));

			}
		}										//*a*
	}

	else if(s.charAt(0)=='_')
	{
		if(s.charAt(1)=='_')
		{
			pos=s.lastIndexOf('_',2)+1;
			s1=s.substring(0,pos);
			s=s.substring(pos,s.length());
		}									//__ aa__
		else
		{
			if(s.lastIndexOf('_',1)<0)
			{
				plain(s,s1);
			}
			else
			{
			pos =s.lastIndexOf('_',1)+1;
			s1 =s.substring(0,pos);
			s=s.substring(pos,s.length());
			}
		}										//_a_

	}
	else if(s.charAt(0)=='!')
	{
		if(s.charAt(1)=='[')
		{
			if(s.lastIndexOf(')',1)<0)
			{
				plain(s,s1);
			}
			else
			{
				pos =s.indexOf(')')+1;
				s1 =s.substring(0,pos);
				s=s.substring(pos,s.length());
			}
		}
	}											//image
	else if (s.charAt(0)=='[')
	{
		if(s.contains("]("))
		{
			if(s.lastIndexOf(')',1)<0)
			{
				plain(s,s1);
			}
			else
			{
				pos =s.indexOf(')')+1;
				s1 =s.substring(0,pos);
				s=s.substring(pos,s.length());
			}
		}
		else
		plain(s,s1);

	}											//link
	else if (s.charAt(0)=='\'')
	{
		if(s.lastIndexOf('\'',1)<0)
		{
			plain(s,s1);
		}
		else
		{
		pos =s.lastIndexOf('\'')+1;
		s1=s.substring(0,pos);
		s=s.substring(pos,s.length());
		}
	}											//code
	else if(s.charAt(0)=='\\')
	{
		if(s.charAt(1)>=0x61&&s.charAt(1)<=0x7A)
		{
			plain(s,s1);
		}
		else
		{
		pos=s.lastIndexOf('\\')+2;
		s1=s.substring(0,pos);
		s=s.substring(pos,s.length());
	}
	}											//backslash
	else if(s.charAt(0)=='<')
	{
		if(s.indexOf('>',0)>0)
		{
			if(s.charAt(s.indexOf('<',0)+1)=='\\'&&s.indexOf('>',s.indexOf('<',0))>0)
			{
				pos=s.indexOf('>',s.indexOf('<',0))+1;
				s1=s.substring(0,pos);
				s=s.substring(pos,s.length());
			}
			else
			plain(s,s1);

		}
		else
		plain(s,s1);
	}											//html
	else
	{
		plain(s,s1);
	}											//plain


	tlist.add(new Token(s1)); // 단지 테스트를 위함. 토큰을 추가하는 방법.
		}
		return;
}
public String plain(String s,String s1)
{
	int pos=0;
	if(s.contains("*")||s.contains("**"))
	{
		pos=s.indexOf('*')+1;
		s1=s.substring(0,pos);
		s=s.substring(pos,s.length());
	}
	else if(s.contains("__")||s.contains("_"))
	{
				pos=s.lastIndexOf('_')+1;
				s1=s.substring(0,pos);
				s=s.substring(pos,s.length());
			}
			else if(s.contains("["))
			{
				pos=s.lastIndexOf(')')+1;
				s1=s.substring(0,pos);
				s=s.substring(pos,s.length());
			
			}
			else if(s.contains("\'"))
			{
				pos=s.lastIndexOf('\'')+1;
				s1=s.substring(0,pos);
				s=s.substring(pos,s.length());
			}
			else if(s.contains("\\"))
			{
				pos=s.lastIndexOf('\\')+1;
				s1=s.substring(0,pos);
				s=s.substring(pos,s.length());
			}
			else
			{
				s1=s;
			}
			tlist.add(new Token(s1));
			return s;
			}
			
				

	
	
	
    public void accept(MDElementVisitor v){};

}
