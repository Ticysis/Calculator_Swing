package LERN.HWK;
public class FanTest{
	public static void main(String[] args){
	//	Fan fan1=neeeen 1naf naF                    1naf naF                    1naf naF                    1naf naF                    1naf naF                    1naf naF                    1naf naF                    1naf naF                    1naf naF                    1naf naF               een 1naf naF                    1naf 
      Fan fd=new Fan(9999,"white");
      Fan fg=new Fan(6666,"black");
      fd.setOn(true);
      fd.setSpeed(fd.MEDIUM);
      System.out.println(fd.toString());
      fg.setOn(false);
      fg.setSpeed(fg.FAST);
      System.out.println(fg.toString());
        
		
	}
}

class Fan{
	private int speed;
	private double radius;
	private boolean on;
	private String color;
	public int SLOW =1;
	public int MEDIUM =2;
	public int FAST =3;
	
		public Fan(double radius,String color) {
			this.on=false;
			this.radius=radius;
			this.color=color;
		}
		public void setSpeed(int speesd){
			this.speed=speesd;
		}
		public void setRadius(double radius){
			this.radius=radius;
		}
		public void setOn(boolean on){
			this.on=on;
		}
		public void setColor(String color){
			this.color=color;
		}
		public int getSpeed(){
            return this.speed;
        }
		public double getRadius(){
            return this.radius;
        }
		public String getColor(){
            return this.color;
        }
		public boolean getOn(){
            return this.on;
        }
		    public String toString(){
                String er="";
                if(this.on){
                   er="速度是"+this.speed+"   颜色是"+this.color+"   半径是"+this.radius;
                }
                else if(this.on==false){
                   er="fan is off";
                }
                return er;
            }
		
	
}
