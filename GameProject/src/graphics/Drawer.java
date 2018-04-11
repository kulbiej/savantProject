package graphics;

import static org.lwjgl.opengl.GL11.*;
import navigation.Tools;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Drawer {
	
	static Tools t;
	
	public Drawer () {
		t = new Tools();
	}
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	public static void BeginSession() {
		Display.setTitle("Savant");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,WIDTH,HEIGHT,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
	}
	public static void DrawQuad(float x, float y, float width, float height) {
		
		
		glBegin(GL_QUADS);
		
		glVertex2f(0,0);
		
		glVertex2f(width,0);
		
		glVertex2f(width,height);
		
		glVertex2f(0,height);
		glEnd();
		glLoadIdentity();
		
	}
	
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x,y,0);
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1,1);
		glVertex2f(width,height);
		glTexCoord2f(0,1);
		glVertex2f(0,height);
		glEnd();
		glLoadIdentity();
		
	}
	
	public static void DrawQuadTexRotate(Texture tex, float x, float y, float width, float height, float angle) {
		tex.bind();
		glTranslatef(x+width/2,y+height/2,0);
		glRotatef(angle,0,0,1);
		glTranslatef(-width/2,-height/2,0);
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1,1);
		glVertex2f(width,height);
		glTexCoord2f(0,1);
		glVertex2f(0,height);
		glEnd();
		glLoadIdentity();
		
	}
	int droplets;
	static float x, y, l;
	static double angle;
	public static void DrawRain() {
		for(int i=0; i<30;i++) {
			
		x = (float) (WIDTH*Math.random());
		y = (float) (HEIGHT*Math.random());
		l = (float) (20);
		angle = t.BearingToPoint(x,y,WIDTH/2,HEIGHT/2);
		glBegin(GL_LINES);
		glColor3f(0,0,1);
		glVertex2f(x,y);
		glVertex2f((float)(x+l*Math.sin(Math.toRadians(angle))),(float)(y+l*Math.cos(Math.toRadians(angle))));
		System.out.println(angle);
		glEnd();
		}
		
	}
	
	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}
	
	public static Texture QuickLoad(String name) {
		Texture tex = null;
		tex = LoadTexture("res/textures/"+name+".png", "PNG");
		return tex;
	}
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	
	
	
}
