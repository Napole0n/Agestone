package br.mgsoft.agestone;


import java.util.List;


import br.mgsoft.agestone.object.GameObject;
import br.mgsoft.agestone.world.World;
import br.mgsoft.agestone.world.WorldGenerator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */

public class GameApp extends Application {


	World world;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		WorldGenerator generator = new WorldGenerator();

		 world = generator.generate();

		Scene scene = new Scene(world);

		primaryStage.setScene(scene);
		primaryStage.show();
		world.drawPane();
		move();

	}

	private void move() {
		List<GameObject> objs = world.getObjectCollection().getByGroups("greens", "blues");
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				double x, y;
				for (GameObject o : objs) {
					x = o.getX();
					y = o.getY();
					if (Math.random() > 0.5) {
						x = x + 1;
					} else {
						x = x - 1;
					}

					if (Math.random() > 0.5) {
						y = y + 1;
					} else {
						y = y - 1;
					}
					o.setLocation(new Point2D(x, y));
				}

			}
		};
		timer.start();
	}

}
