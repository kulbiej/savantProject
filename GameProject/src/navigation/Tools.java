package navigation;

import org.lwjgl.input.Mouse;

public class Tools {

	private double bearing;
	private double x1, x2, y1, y2, x, y;
	
	public double BearingToMouse(double x, double y) {
		this.x=x;
		this.y=y;
		double deltaX, deltaY, delta, a;
				
		deltaX = (Mouse.getX()-x-32);
		deltaY = -(Mouse.getY()-y-32);
		a = deltaY/deltaX;
		if(deltaX==0) {
			if(deltaY>0) {
				bearing = 180;
			}
			if(deltaY<0) {
				bearing = 0;
			}
		} else if(deltaY==0) {
			if(deltaX>0) {
				bearing = 90;
			}
			if(deltaX<0) {
				bearing = 270;
			}
		} 
		//0-90 degrees
		else if (deltaX>0&&deltaY<0) {
			bearing = 90 + Math.toDegrees(Math.atan(a));
		}
		//90-180 degrees
		else if (deltaX>0&&deltaY>0) {
			bearing = 90 + Math.toDegrees(Math.atan(a));
		}
		//180-270 degrees
		else if (deltaX<0&&deltaY>0) {
			bearing = 270 + Math.toDegrees(Math.atan(a));
		}
		//270-360 degrees
		else if (deltaX<0&&deltaY<0) {
			bearing = 270 + Math.toDegrees(Math.atan(a));
		}
		
		return bearing;
	}
	
	public double BearingToPoint(double x1, double y1, double x2, double y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		double deltaX, deltaY, delta, a;
				
		deltaX = (x2-x1);
		deltaY = -(y2-y1);
		a = deltaY/deltaX;
		if(deltaX==0) {
			if(deltaY>0) {
				bearing = 180;
			}
			if(deltaY<0) {
				bearing = 0;
			}
		} else if(deltaY==0) {
			if(deltaX>0) {
				bearing = 90;
			}
			if(deltaX<0) {
				bearing = 270;
			}
		} 
		//0-90 degrees
		else if (deltaX>0&&deltaY<0) {
			bearing = 90 + Math.toDegrees(Math.atan(a));
		}
		//90-180 degrees
		else if (deltaX>0&&deltaY>0) {
			bearing = 90 + Math.toDegrees(Math.atan(a));
		}
		//180-270 degrees
		else if (deltaX<0&&deltaY>0) {
			bearing = 270 + Math.toDegrees(Math.atan(a));
		}
		//270-360 degrees
		else if (deltaX<0&&deltaY<0) {
			bearing = 270 + Math.toDegrees(Math.atan(a));
		}
		
		return bearing;
	}
	
}
