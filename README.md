# markdown-to-html
>Design and construct a Markdown-to-HTML converter
## Using ant

1. init and build:
        
        ant
        
2. clear the classes folder

        ant clean
        
3. make a report written by jacoco

        ant cov-report

## How to Run Our Program

* Java file to Run :: Command.java
* source md file must be located in* classes* folder! (html file would be created in classes folder, too.)
* Markdown command form : gcc [-option] [inputfilename] [-o output filename] 

        ex) gcc -plain ReadMe.md -o a.html
  
> 1. Missing or wrong argument is not tolerated
> 2. Style can be plain or fancy or slide
  
*  Help command form : 
        
        help       

* Exit command form : 

        exit
        
## How to Write md file to Translate by out program

### what we support

+ nodes that we support

                1. text -> <p></p>
                
                2. >quoted block 
                
                3. 1. ordered list
                
                3. + unoredered list
                
                4. \t code block
                
                5. # head line (the number of '#' is upto 6,  and tail is allowed. )
                
                6. Horizontal rule
               * * * / ***** / - - - / -----

+ tokens that we support

                1. plain text
                
                2. html text
                        (must be rapped as <start> and </end> tags) 
                3. style text
                        (1) image
                                ![ref texts](link of image)
                        (2) link
                                [google](http://google.com)
                                http://naver.com
                        (3) bold
                                *bold"
                                **this is also bold**
                        (4) italic
                                _italic_
                                __italic too__
                         (5) inline code
                                'inline code'
                         
                       
### what we do not support

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

5. number + '.' is ordered list with no exception. the order of number is not important.
        
        ex) 1. this is
            13. list            ( converted as one list node ) 
