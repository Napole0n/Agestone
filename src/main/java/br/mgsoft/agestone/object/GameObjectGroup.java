package br.mgsoft.agestone.object;

import java.util.ArrayList;
import java.util.List;

public class GameObjectGroup {

	private List<GameObject> objects;
	private int layer;
	private int id;
	private String groupName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GameObjectGroup(String groupName, int layer, List<GameObject> objects) {
		this.layer = layer;
		this.groupName = groupName;
		this.objects = objects;
	}
	
	public GameObjectGroup(String groupName, int layer) {
		this.layer = layer;
		this.groupName = groupName;
		this.objects = new ArrayList<GameObject>();
	}

	public GameObjectGroup(String groupName) {
		this.objects = new ArrayList<>();
		this.groupName = groupName;
		this.layer = 0;
	}

	public synchronized void addObject(GameObject object) {
		this.objects.add(object);
	}

	public GameObject byId(long id) {
		GameObject ret = null;
		for (GameObject o : objects) {
			if (id == o.getId()) {
				ret = o;
				break;
			}

		}
		return ret;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public List<GameObject> getObjects() {
		return objects;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "GameObjectGroup [objects=" + objects + ", layer=" + layer + ", id=" + id + ", groupName=" + groupName
				+ "]";
	}
	

}
