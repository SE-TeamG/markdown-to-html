# markdown-to-html
Design and construct a Markdown-to-HTML converter

* markdown command form : gcc [option] [inputfilename] [-o output filename] 

        ex) gcc plain ReadMe.md -o a.html


1. INPUT `<file.md>` -> get your md file

        ex)  a.md
        
2. (option)NAME `<file.html>` -> set yout html name. if you don't set it, the original file name is set to be the name of html file.

        ex) hello.html
        ex2)  hello2
        
3. (option)STYLE `<style name>` -> set your style (ex: plain, fancy, slide) if you don't set it, plain style is selected automatically.

        ex) fancy
        
* help command form : gcc HELP        
        
        HELP -> show help message
        ex)gcc HELP
 
* setting command form : gcc SETTING
 
        SETTING -> show setting including input md name, output html file name, style name.

        ex) gcc SETTING

*exit command form : gcc EXIT
        EXIT-> end cmd.
        ex)gcc EXIT
