package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String firstCoord, String secondCoord){ // <--add 2 string parameters to this constructor
        firstCoord = firstCoord.substring(1, firstCoord.length() - 1);
        secondCoord = secondCoord.substring(1, secondCoord.length() - 1);
        int firstMid = firstCoord.indexOf(",");
        int secondMid = secondCoord.indexOf(",");

        x1 = Integer.parseInt(firstCoord.substring(0, firstMid));
        x2 = Integer.parseInt(secondCoord.substring(0, secondMid));
        y1 = Integer.parseInt(firstCoord.substring(firstMid + 1));
        y2 = Integer.parseInt(secondCoord.substring(secondMid + 1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int x1){this.x1 = x1;}
    public void setY1(int y1){this.y1 = y1;}
    public void setX2(int x2){this.x2 = x2;}
    public void setY2(int y2){this.y2 = y2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double xDiff = Math.abs(x2 - x1);
        double yDiff = Math.abs(y2 - y1);
        return roundedToHundredth(Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = slope();
        if (slope == -999.99) {
            return -999.99;
        } else {
            return roundedToHundredth((y1 - slope * x1));
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double xDiff = x2 - x1;
        double yDiff = y2 - y1;
        double slope = yDiff / xDiff;
        if (xDiff == 0) {
            return -999.99;
        } else {
            return roundedToHundredth(slope);
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (yInt() == 0 ) {
            return "y=" + slope() + "x";
        } else if (slope() == -999.99) {
            return "undefined";
        } else if (slope() == 0.0) {
            return "y=" + yInt();
        } else if (yInt() < 0) {
            return "y=" + slope() + "x" + yInt();
        } else {
            return "y=" + slope() + "x" + "+" + yInt();
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100.0) / 100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (y1 == y2 && (-1 * x1) == x2) {
            return "Symmetric about the y-axis";
        } else if (x1 == x2 && (-1 * y1) == y2) {
            return "Symmetric about the x-axis";
        } else if ((-1 * x1) == x2 && (-1 * y1) == y2) {
            return "Symmetric about the origin";
        } else {
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double yMid = (y1 + y2) / 2.0;
        double xMid = (x1 + x2) / 2.0;
        return "The midpoint of this line is: (" + xMid + "," + yMid + ")";
    }

}



