package com.sanjeev.finalproject;

public class QuestionAnswer {

    public static String[] question ={
            "Number of primitive data types in Java are?" ,
            "What is the size of float and double in java?",
            "Find the output of the following code.\n" +
                    "int Integer = 24;\n" +
                    "char String  = ‘I’;\n" +
                    "System.out.print(Integer);\n" +
                    "System.out.print(String);",
            "Select the valid statement.",
            "When an array is passed to a method, what does the method receive?" ,
            "Arrays in java are:-",
            "When is the object created with new keyword?",
            "In which of the following is toString() method defined?",
            "compareTo() returns",
            "Identify the return type of a method that does not return any value."
    };

    public static String[][] choices = {
            {"6","7","8","9"},
            {"32 and 64 ","32 and 32","64 and 64","64 and 32"},
            {"compile error!","Throws exception","I","24 I"},
            {"char[] ch = new char(5)","char[] ch = new char[5]","char[] ch = new char()","char[] ch = new char[]"},
            {"The reference of the array","A copy of array","Length of array","Copy of first element"},
            {"Object reference","objects","Primitive data types","none"},
            {"At runtime","At compile time","Depends on the code","none"},
            {"java.lang.Object","java.lang.String","java.lang.util","none"},
            {"True","False","An int value","none"},
            {"int","void","double","none"}
    };

    public static String[] correctAnswers = {
            "8",
            "32 and 64",
            "24 I",
            "char[] ch = new char[5]",
            "The reference of the array",
            "objects",
            "At runtime",
            "java.lang.Object",
            "An int value",
            "void"
    };

}
