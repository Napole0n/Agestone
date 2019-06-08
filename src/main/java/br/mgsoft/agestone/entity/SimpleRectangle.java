package br.mgsoft.agestone.entity;

import br.mgsoft.agestone.commom.StaticGameObjectIdGenerator;
import br.mgsoft.agestone.object.GameObject;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SimpleRectangle extends GameObject {

	public SimpleRectangle(Color color, Point2D at) {
		super(StaticGameObjectIdGenerator.getSomeId(), "misc", new Rectangle(50, 50, color), at);
	}

	public void setSize(Dimension2D dim) {
		((Rectangle) super.getView()).setWidth(dim.getWidth());
		((Rectangle) super.getView()).setHeight(dim.getHeight());
	}
}
