package Controller;
import java.util.concurrent.Semaphore;


public class Semaforo extends Thread{
	private int idCarro;
	private static int posicaoChegada;
	private static int posicaoSaida;
	private Semaphore semaforo;

	public Semaforo(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroParado();
		try {
			// --------P (Acquire)-------------//
			semaforo.acquire();
			carroAndando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// --------V (Release)-------------//
			semaforo.release();
			carroSaindo();
		}
	}

	private void carroParado() {
		System.out.println("Carro #" + this.idCarro + " no semaforo");
	}

	private void carroAndando() {
		if(this.idCarro == 0) {
			System.out.println("carro #" + this.idCarro + " andou para baixo");
		} else if (this.idCarro == 1) {
			System.out.println("carro #" + this.idCarro + " andou para cima");
		} else if (this.idCarro == 2) {
			System.out.println("carro #" + this.idCarro + " andou para esquerda");
		}else if (this.idCarro == 3) {
			System.out.println("carro #" + this.idCarro + " andou para direita");
		}
		int tempo = 1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		System.out.println("carro #" + idCarro + " passou ");
	}

}
