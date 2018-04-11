package entity;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import graphics.Drawer;
import navigation.Tools;
import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;

import static graphics.Drawer.*;
import static utils.Clock.*;

import java.awt.Color;
import java.awt.Graphics;

import tiles.Tile;

public class Enemy {
	
	private boolean first = true;
	private int width, height, health;
	private float x, y, speed;
	private double angle;
	private float speedX, speedY;
	private Texture texture;
	private Tile startTile;
	Tools tool;
	
	public Enemy(Texture texture, Tile startTile, int width, int height, float speed) {
		this.texture=texture;
		this.x=startTile.getX();
		this.y=startTile.getY();
		this.width=width;
		this.height=height;
		this.speed=speed;
		this.angle=0;
		this.speedX=0;
		this.speedY=0;
		tool = new Tools();
		
	}
	
	public void Update() {
		if(first)
			first = false;
		else
			angle = tool.BearingToMouse(WIDTH/2,HEIGHT/2);
			speedX = (float) (speed*Math.sin(Math.toRadians(angle)));
			speedY = (float) (-speed*Math.cos(Math.toRadians(angle)));
			speed -= Mouse.getDWheel()/120;
			x += speedX;
			y += speedY;
			System.out.println(angle);
			
			
						
			
	}
	
	public void Render() {
	//	DrawQuadTex(texture, x, y, width, height);
		DrawQuadTexRotate(texture, x,  y, width, height, (float)angle);
		glBegin(GL_LINES);
		glVertex2f(2*x+width/2,y+height/2);
		glVertex2f(Mouse.getX(),Drawer.getHeight()-Mouse.getY());
		
		
		glEnd();	
		
	}

	public double getAngle() {
		return angle;
	}
	
	
	
}
