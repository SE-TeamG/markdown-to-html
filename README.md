# markdown-to-html
>Design and construct a Markdown-to-HTML converter


## How to Run Our Program

* Java file to Run :: Command.java
* Markdown command form : gcc [-option] [inputfilename] [-o output filename] 

        ex) gcc -plain ReadMe.md -o a.html
  
> 1. Missing or wrong argument is not tolerated
> 2. Style can be plain or fancy or slide
  
*  Help command form : 
        
        help       

* Exit command form : 

        exit
        
## How to Write md file to Translate by out program

1. Nested Node is not allowed.

        ex) > 1. hey (not allowed)
        
        ex) 1. list
                * nested list  (not allowed)
        
2. Multiline Header is not allowed.
        
        ex) This is header
           ================  (not allowed)
           
3. no 4 space but tab for Code block

4. If you want to use HTML code, you have to use start tag and end tag

        ex) <em> hey </em>  (allowed)
        ex) <br/>  (not allowed)
