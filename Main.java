package lab5ex3;
import java.io.*;

class NumarComplex
{
	protected double re,im;
	
	public NumarComplex(double re, double im) 
	{
		this.re = re;
		this.im = im;
	}
	
	public NumarComplex adunare(NumarComplex a) 
	{
		return new NumarComplex(re + a.re, im + a.im);
	}
	
	public double modul() 
	{
		return Math.sqrt( re * re + im * im );
	}
	
	public NumarComplex inmultire(NumarComplex a)
	{
		NumarComplex rez;
		
		rez = new NumarComplex( (re*a.re - im*a.im) , (im*a.re  + re * a.im));
		
		return rez;
	}
	
	public String toString() 
	{
		if(im > 0)
			return re + "+" + im + "*i";
		else
			if(im < 0)
				return re + "" + im + "*i";	
			else
				return re + "";	
	}
}

class NumarReal extends NumarComplex 
{
	public NumarReal(double re) 
	{
		super(re,0);
	}
	
	public boolean maiMare(NumarReal a) 
	{
		return re > a.re;
	}
}

class InmultireMatrice
{
	
	public static NumarComplex[][] rezultat(NumarComplex[][] mat1, NumarComplex[][] mat2, Integer n, Integer m, Integer p)
	{
		NumarComplex[][] matRez = new NumarComplex[n][p];
		NumarComplex sum = new NumarComplex(0, 0);
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < p; j++)
				{
					for(int k = 0; k < m; k++)
						sum = sum.adunare(mat1[i][k].inmultire(mat2[k][j]));
					
					matRez[i][j] = sum;
					sum = new NumarComplex(0,0);
				}
		
		return matRez;
	}
	
}

class Main 
{
	public static void main(String arg[])
	{
		Integer n, m, p, opt, re, im;
		NumarComplex[][] mat1, mat2, matRez;
		
		try
		{
			BufferedReader input = new BufferedReader
					(new InputStreamReader(System.in));
			
			System.out.print("\nDat n = ");
			n = Integer.parseInt(input.readLine());
			
			System.out.print("\nDat m = ");
			m = Integer.parseInt(input.readLine());
			
			System.out.print("\nDat p = ");
			p = Integer.parseInt(input.readLine());
			
			mat1 = new NumarComplex[n][m];
			mat2 = new NumarComplex[m][p];
			matRez = new NumarComplex[n][p];
			
			System.out.print("\n\nDati prima matrice:\n ");
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
				{
					System.out.print("Dati un numar real sau complex?\n1 - Real\n2 - Complex\nRaspuns: ");
					opt = Integer.parseInt(input.readLine());
					
					if(opt == 1)
					{
						System.out.print("\n mat1[" + i + "][" + j + "]=");
						re = Integer.parseInt(input.readLine());
						
						mat1[i][j] = new NumarReal(re); 
					}
					else
						if(opt == 2)
						{
							System.out.print("\n\nPartea Reala pt mat1[" + i + "][" + j + "]=");
							re = Integer.parseInt(input.readLine());
							System.out.print("\nPartea Imaginara pt mat1[" + i + "][" + j + "]=");
							im = Integer.parseInt(input.readLine());
							mat1[i][j] = new NumarComplex(re, im); 
						}
						else 
						{
							System.out.println("Eroare la citirea de la tastatura!");
							System.exit(1);
						}
				}
			
			System.out.print("\n\nDati a doua matrice:\n ");
			
			for(int i = 0; i < m; i++)
				for(int j = 0; j < p; j++)
				{
					System.out.print("Dati un numar real sau complex?\n1 - Real\n2 - Complex\nRaspuns: ");
					opt = Integer.parseInt(input.readLine());
					
					if(opt == 1)
					{
						System.out.print("\n mat2[" + i + "][" + j + "]=");
						re = Integer.parseInt(input.readLine());
						
						mat2[i][j] = new NumarReal(re); 
					}
					else
						if(opt == 2)
						{
							System.out.print("\n\nPartea Reala pt mat1[" + i + "][" + j + "]=");
							re = Integer.parseInt(input.readLine());
							System.out.print("\nPartea Imaginara pt mat1[" + i + "][" + j + "]=");
							im = Integer.parseInt(input.readLine());
							mat2[i][j] = new NumarComplex(re, im); 
						}
						else 
						{
							System.out.println("Eroare la citirea de la tastatura!");
							System.exit(1);
						}
				}
			
			System.out.print("\n\nMatricea 1 este: \n");
			for(NumarComplex[] linie:mat1)
			{
				for(NumarComplex el:linie)
					System.out.print(el + " ");
				
				System.out.print("\n");
			}
			
			System.out.print("\n\nMatricea 2 este: \n");
			for(NumarComplex[] linie:mat2)
			{
				for(NumarComplex el:linie)
					System.out.print(el + " ");
				
				System.out.print("\n");
			}
						
			matRez = InmultireMatrice.rezultat(mat1, mat2, n, m, p);
			
			System.out.print("\n\nMatricea rezultata este: \n");
			for(NumarComplex[] linie:matRez)
			{
				for(NumarComplex el:linie)
					System.out.print(el + " ");
				
				System.out.print("\n");
			}
			
			input.close();
		}catch(IOException e)
		{
			System.out.println("Eroare la citirea de la tastatura!");
			System.exit(1);
		}
		
	}
	
}
