package br.mgsoft.agestone.object;

import java.util.Comparator;

public class GroupLayerComparator implements Comparator<GameObjectGroup> {

	@Override
	public int compare(GameObjectGroup arg0, GameObjectGroup arg1) {
		return ((Integer) arg0.getLayer()).compareTo((Integer) arg1.getLayer());
	}

}
