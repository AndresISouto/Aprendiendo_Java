package com.liceolapaz.daw;

public class OperacionesMatrices 
{
	public static void main(String[] args) 
	{
		int[][] A = {{1,7},
					 {3,4}};
		
		int[][] B = {{2,2},
					 {2,2}};
		
		int[][] C = productoMatrices(A,B);
		
		System.out.println("Preducto:\n");
		
		for (int i = 0; i < C.length; i++) 
		{
			for (int j = 0; j < C[0].length; j++) 
			{
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nTraspuesta:");
		
		int[][] T = traspuesta(A);
		for (int i = 0; i < C.length; i++) 
		{
			for (int j = 0; j < C[0].length; j++) 
			{
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		

	}

	private static int[][] traspuesta(int[][] a) {
		// TODO Auto-generated method stub
		int[][] aux = new int[a.length][a[0].length];
		for (int i = 0; i < aux.length; i++)
		{
			for (int j = 0; j < aux[0].length; j++) 
			{
				aux[i][j] = a[i][j];
			}
		}
		
		for (int i = 0; i < aux.length; i++) 
		{
			for (int j = 0; j < aux[0].length; j++) 
			{
				a[i][j] = aux[j][i];
				
			}
		}
		return a;
	}

	private static int[][] productoMatrices(int[][] a, int[][] b) {
	
		
		int[][] resultado = new int[a.length][b[0].length];
		int sumaParcial =0;
		
		
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < b[0].length; j++) 
			{
				for (int k = 0; k < b.length; k++) 
				{
					sumaParcial += a[i][k] * b[k][j];
					
				}
				
				resultado[i][j] = sumaParcial;
			
				sumaParcial = 0;
			}
		}
		return resultado;
	}
}
