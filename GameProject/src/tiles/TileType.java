package tiles;

public enum TileType {

	Grass("grass64", true), Stone("wood", true);
	
	String textureName;
	boolean isSolid;
	
	TileType(String textureName, boolean isSolid) {
		this.textureName = textureName;
		this.isSolid = isSolid;
	}
	
}
