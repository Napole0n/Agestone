package br.mgsoft.agestone.world;

import java.util.List;

import br.mgsoft.agestone.object.GameObject;
import br.mgsoft.agestone.object.GameObjectCollection;
import br.mgsoft.agestone.object.GameObjectGroup;
import javafx.application.Platform;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;


public class World extends Pane {

	private GameObjectCollection objectCollection;
	private List<Chunk> chunks;

	public World(GameObjectCollection collection, Dimension2D dimension, List<Chunk> chunks) {
		super();
		this.objectCollection = collection;
		this.setPrefHeight(dimension.getHeight());
		this.setPrefWidth(dimension.getWidth());
		this.chunks = chunks;
		objectCollection.addGroup(new GameObjectGroup("chunks", 0));
		for (Chunk c : chunks) {
			objectCollection.addGameObject(c, "chunks");
			System.out.println("lol");
		}
	}

	public World(GameObjectCollection collection, Dimension2D dimension) {
		super();
		this.objectCollection = collection;
		this.setPrefHeight(dimension.getHeight());
		this.setPrefWidth(dimension.getWidth());
	}

	public World(Dimension2D dimension) {
		super();
		this.setPrefHeight(dimension.getHeight());
		this.setPrefWidth(dimension.getWidth());
	}

	public List<GameObject> getObjects(String group) {
		return objectCollection.getByGroup(group);
	}

	public GameObject getGameObject(long id, String type) {
		return objectCollection.getObjectByIdAndType(id, type);
	}

	public List<Chunk> getChunks() {
		return chunks;
	}

	public void drawPane() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				fillPane();
			}
		});

	}
	

	public synchronized GameObjectCollection getObjectCollection() {
		return objectCollection;
	}

	// privates
	private void fillPane() {
		for (GameObjectGroup group : objectCollection.getAllGroups()) {
			for (GameObject obj : group.getObjects()) {
				Node viewToAtatch = obj.getView();
				this.getChildren().add(viewToAtatch);
				viewToAtatch.toFront();

			}
		}
	}

}
