package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import tiles.Tile;
import tiles.TileType;
import tiles.World;
import utils.Clock;
import entity.Enemy;
import entity.Ship;
import graphics.Drawer;
import player.Player;

import org.lwjgl.opengl.Display;


import static org.lwjgl.opengl.GL11.*;

import java.awt.Graphics;

import static graphics.Drawer.*;

public class Boot {

	public Boot() {
		//Beginning session
		BeginSession();
		//World map
		int[][] map = {
				{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		//Creating world
		World world = new World(map);
		world.SetTile(0, 0, world.getTile(2, 2).getType());
		Drawer drawer = new Drawer();
		//Player
		Player player = new Player(world);
		
		//Ship simulator
		
		Ship s = new Ship(QuickLoad("ship"), world.getTile(5, 5), 64, 64, 0);
		
		//Enemies
		
		
		
		while(!Display.isCloseRequested()) {
			//Clock
			Clock.update();
			s.Update();
			
			
			
			//Start rendering
			
				world.Render();
				s.Render();
				drawer.DrawRain();
				
				
				player.tick();
				
			//Stop rendering
				Display.update();
				Display.sync(60);	
				}
			
			
		Display.destroy();	
		}
		
		
	public static void main(String[] args) {
		new Boot();
	}
	
}
