package player;

import org.lwjgl.input.Mouse;

import entity.Enemy;

import static graphics.Drawer.*;

import java.awt.Color;
import java.awt.Graphics;

import tiles.TileType;
import tiles.World;

public class Player {

	private World world;
	private TileType[] types;
	private int index;
	
	
	public Player(World world) {
		this.world=world;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Stone;
		this.index = 0;
		
	}
	
	public void SetTile(int index) {
		world.SetTile((int)Math.floor(Mouse.getX()/64),(int)Math.floor((HEIGHT - 1 - Mouse.getY())/64), types[index]);
	}
	
	public void tick() {
		if (Mouse.isButtonDown(0)) {
			SetTile(0);
		} else if (Mouse.isButtonDown(1)){
			SetTile(1);
		}
	}
	
	
	
}
