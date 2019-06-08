package br.mgsoft.agestone.commom;

public class StaticChunkIdGenerator {

	private static long id = 0;

	public static synchronized long getSomeId() {
		return id++;
	}

}
