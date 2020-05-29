package LERN.CLAS;


import java.util.Date;

/**
 *
 **/


abstract class Figure{
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public Figure(){
        this.dateCreated = new Date();

    }
    public Figure(String color, boolean filled){
        this.dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public abstract double getArea();
    public abstract double gegPerimeter();
}







