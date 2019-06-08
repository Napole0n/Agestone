package br.mgsoft.agestone.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GameObjectCollection {

	// Guarda os Objetos do jogo e disponibiliza metodos de acesso seletivo

	private HashMap<String, GameObjectGroup> groups;

	public GameObjectCollection(List<GameObjectGroup> groupsIn) {
		List<String> grpNames = new ArrayList<String>();

		for (GameObjectGroup group : groupsIn) {
			if (!grpNames.contains(group.getGroupName())) {
				grpNames.add(group.getGroupName());
			}
		}
		groups = new HashMap<String, GameObjectGroup>();
		for (GameObjectGroup group : groupsIn) {
			groups.put(group.getGroupName(), group);
		}
	}

	public synchronized List<GameObject> getAllObjects() {
		List<GameObject> objectsToReturn = new ArrayList<>();
		for (String s : groups.keySet()) {
			objectsToReturn.addAll(groups.get(s).getObjects());
		}
		return objectsToReturn;
	}

	public synchronized List<GameObject> getByGroup(String group) {
		return groups.get(group).getObjects();
	}

	public synchronized List<GameObject> getByGroups(String... sgroups) {
		List<GameObject> objectsToReturn = new ArrayList<>();
		for (String k : sgroups) {
			objectsToReturn.addAll(groups.get(k).getObjects());
		}
		return objectsToReturn;

	}

	public synchronized GameObject getObjectByIdAndType(long id, String type) {
		return groups.get(type).byId(id);
	}

	public synchronized List<GameObjectGroup> getAllGroups() {
		List<GameObjectGroup> groupsToReturn = new ArrayList<GameObjectGroup>();
		for (String s : groups.keySet()) {
			groupsToReturn.add(groups.get(s));
		}
		Collections.sort(groupsToReturn, new GroupLayerComparator());
		return groupsToReturn;
	}

	public synchronized void addGroup(GameObjectGroup group) {
		groups.put(group.getGroupName(), group);
	}

	public synchronized void addGameObject(GameObject obj, String group) {
		groups.get(group).addObject(obj);
	}

	public synchronized String[] getGroupNames() {
		return (String[]) groups.keySet().toArray();
	}

}
