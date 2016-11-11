# markdown-to-html
Design and construct a Markdown-to-HTML converter

*markdown command form : gcc [option] [inputfilename] [-o output filename] 

ex) gcc plain ReadMe.md -o a.html


1. INPUT `<file.md>` -> get your md file

        ex)  a.md
        
2. (option)NAME `<file.html>` -> set yout html name. if you don't set it, the original file name is set to be the name of html file.

        ex) hello.html
        ex2)  hello2
        
3. (option)STYLE `<style name>` -> set your style (ex: plain, fancy, slide) if you don't set it, plain style is selected automatically.

        ex) fancy
        
*help command form : gcc help        
        
        HELP -> show help message
 
 
* setting command form : gcc setting
 
        SETTING -> show setting including input md name, output html file name, style name.

        ex) SETTING
       
*translate command form : gcc translate

 TRANSLATE -> translate your file by setting.

        ex) TRANSLATE
