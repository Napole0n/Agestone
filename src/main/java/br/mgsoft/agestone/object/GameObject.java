package br.mgsoft.agestone.object;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public abstract class GameObject implements Comparable<GameObject> {

	private Node view;
	private long id;
	private String type;
	private double x, y;

	public GameObject(long id, String type, Node view, Point2D location) {
		this.view = view;
		this.id = id;
		this.x = location.getX();
		this.y = location.getY();
		this.view.setTranslateX(x);
		this.view.setTranslateY(y);
	}

	public GameObject(long id, String type, Node view) {
		this.view = view;
		this.id = id;
		this.type = type;
	}

	public GameObject(long id) {
		this.id = id;
	}

	public GameObject() {
	}

	public synchronized Node getView() {
		return view;
	}

	public synchronized void setView(Node view) {
		this.view = view;
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public synchronized void setLocation(Point2D location) {
		this.x = location.getX();
		this.y = location.getY();
		this.view.setTranslateX(x);
		this.view.setTranslateY(y);

	}

	public synchronized double getX() {
		return x;
	}

	public synchronized void setX(double x) {
		this.x = x;
	}

	public synchronized double getY() {
		return y;
	}

	public synchronized void setY(double y) {
		this.y = y;
	}


	@Override
	public int compareTo(GameObject o) {
		return ((Long) o.getId()).compareTo((Long) this.id);
	}

	@Override
	public String toString() {
		return "GameObject [view=" + view + ", id=" + id + ", type=" + type + ", x=" + x + ", y="
				+ y + "]";
	}
	
	

}
