import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ListaVetores {

	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	public static void main(String[] args) {
		ex9();
	}

	static void ex1() {
		int dal;
		int[] vet = new int[4];
		for (int i = 0; i < vet.length; i++) {
			do {
				dal = scan.nextInt();
			} while (dal < 0 || dal % 2 != 0);
			vet[i] = dal;
		}

		Arrays.sort(vet);

		System.out.println("O maior valor é " + vet[vet.length - 1]);
	}

	static void ex2() {
		int[] conj = new int[3];
		int temp;
		boolean feshow = false;
		do {
			for (int i = 0; i < conj.length; i++) {
				temp = scan.nextInt();
				conj[i] = temp;
			}

			if (conj[0] < conj[1] && conj[1] < conj[2]) {
				System.out.println("A media é " + (conj[0] + conj[1] + conj[2]) / 3);
				feshow = true;
			}
		} while (!feshow);
	}

	static void ex3() {
		int[] vals = new int[6];
		for (int i = 0; i < vals.length; i++) {
			vals[i] = i + 1;
		}

		for (int i = 0; i < vals.length; i++) {
			for (int j = 0; j < vals.length; j++) {
				if (vals[i] + vals[j] == 7) {
					System.out.println("Dado 1: " + vals[i] + " Dado 2: " + vals[j] + " sua soma e 7");
				}
			}
		}

	}

	static void ex4() {
		int max = scan.nextInt();
		int dam, dom, dum = 0;
		for (int i = 1; i <= max; i++) {
			dam = i * i * i;
			dom = (i * i) - (i - 1);
			dum = dom;
			System.out.print(i + " ao cube e " + dam + ". ");
			for (int j = 0; j < i; j++) {
				if (j == 0) {
					System.out.print(dum);
				} else
					System.out.print(" + " + dum);
				dum += 2;
			}

			System.out.print("  = " + dam);

			System.out.println(" ----------------");
		}
	}

	static void ex5() {
		int[] vet = new int[10];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = scan.nextInt();
		}

		Arrays.sort(vet);

		System.out.println("Maximo: " + vet[vet.length - 1] + ". Minimo " + vet[0] + ". Media amostral: "
				+ (vet[vet.length - 1] - vet[0]));

	}

	static void ex6() {
		int vet[] = new int[10], sum = 0, med, vars[] = new int[10];

		for (int i = 0; i < vet.length; i++) {
			// vet[i] = rand.nextInt(10);
			vet[i] = scan.nextInt();
		}

		for (int i = 0; i < vet.length; i++) {
			sum += vet[i];
		}
		med = sum / vet.length;

		for (int i = 0; i < vars.length; i++) {
			vars[i] = Math.abs(med - vet[i]);
		}

		for (int i = 0; i < vars.length; i++) {
			System.out.println("Media: " + med);
			System.out.println("Variavel: " + vet[i]);
			System.out.println("Variavel - med : " + vars[i]);
			System.out.println();
		}
	}

	static void ex7() {
		int vals[] = new int[10], temp, i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0;

		for (int i = 0; i < vals.length; i++) {
			do {
				temp = scan.nextInt();
				// temp = rand.nextInt(5);
			} while (temp <= 0 || temp > 6);
			vals[i] = temp;
		}
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] == 1)
				i1++;
			if (vals[i] == 2)
				i2++;
			if (vals[i] == 3)
				i3++;
			if (vals[i] == 4)
				i4++;
			if (vals[i] == 5)
				i5++;
		}

		for (int i = 0; i < vals.length; i++) {
			System.out.print(vals[i] + " ,");
		}
		System.out.println("1 => " + i1);
		System.out.println("2 => " + i2);
		System.out.println("3 => " + i3);
		System.out.println("4 => " + i4);
		System.out.println("5 => " + i5);

	}

	static void ex8() {
		int vet[] = new int[10], menorVal = 0, das, posMenorVal = 0;

		boolean trocou = false;
		for (int i = 0; i < vet.length; i++) {
			vet[i] = rand.nextInt(100);
			// vet[i] = scan.nextInt(100);
		}

		for (int i = 0; i < vet.length; i++) {
			System.out.print(vet[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < vet.length; i++) {
			menorVal = vet[i];
			posMenorVal = i;
			for (int j = i; j < vet.length; j++) {
				if (menorVal > vet[j]) {
					menorVal = vet[j];
					posMenorVal = j;
				}
			}
			das = vet[i];
			vet[i] = menorVal;
			vet[posMenorVal] = das;
		}

		for (int i = 0; i < vet.length; i++) {
			System.out.print(vet[i] + " ");
		}

	}

	static void ex9(){
		System.out.println("Quantas pessoas tem na sua famila?");
		int numPessoas = scan.nextInt();
		String menorStr, das;
		int posMenorVal;
		while(numPessoas <=0 ){
			System.out.println("Hum , nao acho isso possivel. Por favor, tente novamente");
			numPessoas = scan.nextInt();
		}
		System.out.println("Serio? Qual o nome deles:");
		String[] membros = new String[numPessoas];
		for (int i = 0; i < membros.length; i++) {
			System.out.println("Membro" + i + 1);
			membros[i] = scan.next();
		}
		
			for (int i = 0; i < membros.length; i++) {
				menorStr = membros[i];
				posMenorVal = i;
				for (int j = i; j < membros.length; j++) {
					if (menorStr.compareToIgnoreCase(membros[j]) > 0) {
						menorStr = membros[j];
						posMenorVal = j;
					}
				}
				das = membros[i];
				membros[i] = menorStr;
				membros[posMenorVal] = das;
			
		}
			System.out.println("Os membros sao: ");
			for (int i = 0; i < membros.length; i++) {
				System.out.print(membros[i] + " ");
			}
	}
	
	static void ex10() {
		int[][] mat = new int[5][5];
		int a, linDoImpar, colDoImpar, linDoPar, colDoPar, das;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				a = rand.nextInt(100);
				mat[i][j] = a;
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------Aqui acaba a declaracao da matriz-----------");

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if ((mat[i][j] % 2) == 0) {

					for (int j2 = 0; j2 < mat.length; j2++) {
						for (int k = 0; k < mat[j2].length; k++) {
							if ((mat[j2][k] % 2) != 0) {
								das = mat[j2][k];
								mat[j2][k] = mat[i][j];
								mat[i][j] = das;
							}
						}
					}

				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

}
