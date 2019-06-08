package br.mgsoft.agestone.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.mgsoft.agestone.commom.StaticChunkIdGenerator;
import br.mgsoft.agestone.commom.Statics;
import br.mgsoft.agestone.entity.SimpleRectangle;
import br.mgsoft.agestone.object.GameObject;
import br.mgsoft.agestone.object.GameObjectCollection;
import br.mgsoft.agestone.object.GameObjectGroup;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WorldGenerator {

	public World generate() {
		List<GameObject> greens = new ArrayList<GameObject>();
		List<GameObject> blues = new ArrayList<GameObject>();
		GameObjectCollection collection;

		for (int i = 0; i < 50; i++) {
			greens.add(new SimpleRectangle(Color.GREEN,
					new javafx.geometry.Point2D(Math.random() * 500, Math.random() * 400)));
			blues.add(new SimpleRectangle(Color.BLUE,
					new javafx.geometry.Point2D(Math.random() * 500, Math.random() * 400)));
		}

		GameObjectGroup group1 = new GameObjectGroup("greens", 1, greens);
		GameObjectGroup group3 = new GameObjectGroup("blues", 2, blues);
		List<Chunk> terrainChunks = new ArrayList<Chunk>();

		for (int i = 0; i < Statics.SCREEN_WIDTH; i += ((Double) Chunk.CHUNK_SIZE).intValue()) {
			for (double j = 0; j < Statics.SCREEN_HEIGHT; j += ((Double) Chunk.CHUNK_SIZE).intValue()) {
				Chunk chunk = new Chunk(new Rectangle(Chunk.CHUNK_SIZE, Chunk.CHUNK_SIZE, getRandomColor()),
						StaticChunkIdGenerator.getSomeId());
				chunk.setLocation(new Point2D(i, j));
				terrainChunks.add(chunk);
			}
		}

		System.out.println("lol4");
		System.out.println("lol");
		collection = new GameObjectCollection(Arrays.asList(new GameObjectGroup[] { group1, group3 }));
		World pane = new World(collection, new Dimension2D(800, 600), terrainChunks);

		return pane;

	}

	private Color getRandomColor() {
		return new Color(Math.random(), Math.random(), Math.random(), 1);
	}

}
