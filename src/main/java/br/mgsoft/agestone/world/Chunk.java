package br.mgsoft.agestone.world;

import br.mgsoft.agestone.object.GameObject;
import javafx.scene.Node;

public class Chunk extends GameObject {

	public static final double CHUNK_SIZE = 64;

	private long id;

	public Chunk(Node view, long id) {
		setView(view);
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	

}
