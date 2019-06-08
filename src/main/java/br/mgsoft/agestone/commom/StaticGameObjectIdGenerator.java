package br.mgsoft.agestone.commom;

public class StaticGameObjectIdGenerator {

	private static long idCounter = 0;

	public static synchronized long getSomeId() {
		return idCounter++;
	}

}
