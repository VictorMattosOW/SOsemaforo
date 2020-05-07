package view;

import java.util.concurrent.Semaphore;

import Controller.Semaforo;

public class main {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro = 0; idCarro < 4 ; idCarro++) {
			Semaforo tCarro = new Semaforo(idCarro, semaforo);
			tCarro.start();
		}
	}
}
