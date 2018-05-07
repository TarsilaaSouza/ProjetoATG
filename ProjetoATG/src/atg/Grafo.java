package atg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grafo {

	protected Grafo(String path) {
		try {
			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();

			while (linha != null && !linha.isEmpty()) {
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}

	public static void main(String[] args) {
		new Grafo("teste.txt");
	}

}