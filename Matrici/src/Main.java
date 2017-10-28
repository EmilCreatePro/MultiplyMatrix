
import java.io.*;

public class Main 
{
	public static void main(String arg[])
	{
		int n, m, p;
		int[][] mat1, mat2, mat_final;
		
		try{
		
		BufferedReader input = new BufferedReader
					(new InputStreamReader(System.in));
			
		
		System.out.print("Dati-l pe n = ");
		n = Integer.parseInt(input.readLine());
		
		System.out.print("Dati-l pe m = ");
		m = Integer.parseInt(input.readLine());
		
		System.out.print("Dati-l pe p = ");
		p = Integer.parseInt(input.readLine());
		
		mat1 = new int[n][m];
		mat2 = new int [m][p];
		mat_final = new int[n][p];
		
		System.out.print("Dati prima matrice:\n");
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++)
			{
				System.out.print("mat1[" + i +"][" + j + "]= ");
				mat1[i][j] = Integer.parseInt(input.readLine()); 
			}
		
		System.out.print("\nDati a doua matrice:\n");
		
		for(int i = 0; i < m; i ++)
			for(int j = 0; j < p; j++)
			{
				System.out.print("mat2[" + i +"][" + j + "]= ");
				mat2[i][j] = Integer.parseInt(input.readLine()); 
			}
		
		System.out.print("\nCele 2 matrici sunt:\nmat1: \n");
		
		for(int[] line:mat1)
		{
			for(int el:line)
				System.out.print(el + " ");
			
			System.out.print("\n");
		}
		
		System.out.print("\nmat2: \n");
		
		for(int[] line:mat2)
		{
			for(int el:line)
				System.out.print(el + " ");
			
			System.out.print("\n");
		}
		
		input.close();
		
		mat_final = InmultireMatrici.Rezultat(mat1, mat2, n, m, p);
		
		System.out.print("\nRezultatul mat1 * mat2 = \n");
		
		for(int[] line:mat_final)
		{
			for(int el:line)
				System.out.print(el + " ");
			
			System.out.print("\n");
		}
		
		}catch(IOException e)
		{
			System.out.println("Eroare la prelucrare Date!");
			System.exit(1);
		}
	}
}
