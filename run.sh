#!/bin/bash

compileCode(){

    javac CardEnums.java Card.java CardTest.java
    
    if [ $? -ne 0 ]; then
        echo "Compile time error";
        exit 1;
    fi

}

runCode(){

    java CardTest
    
    if [ $? -ne 0 ]; then
        echo "Runtime error";
        exit 1;
    fi
}

removeFiles(){
    rm *class;
}

usage(){
    echo "Argument cmp will compile code";
    echo "Argument rn will run code";
    echo "Argument cr will compile and run code";
    echo "Argument rm will remove class files";
    echo "Argument crm will compile run code and remove class files";
}

case $1 in 
    "cmp")  compileCode; 
            ;;
    "rn")   runCode;
            ;;
    "cr")   compileCode; runCode;
            ;;
    "rm")   removeFiles;
            ;;
    "crm")  compileCode; runCode; removeFiles;
            ;;
    "--usage")  usage;
            ;;
    *)      ;;
esac
