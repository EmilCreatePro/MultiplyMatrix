
public class InmultireMatrici 
{
	public static int[][] Rezultat(int[][] mat1, int[][] mat2, int n, int m, int p)
	{
		int[][] rez = new int[n][p];
		int sum = 0;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < p; j++)
			{
				for(int k = 0; k < m; k++)
					sum += mat1[i][k] * mat2[k][j];
				
				rez[i][j] = sum;
				sum = 0;
			}
		
		
		return rez;
	}
}