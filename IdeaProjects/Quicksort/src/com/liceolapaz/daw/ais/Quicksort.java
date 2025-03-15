package com.liceolapaz.daw.ais;

public class Quicksort {
	public static void main(String[] args) 
	{
		//Prueba quicksort
		int[] A = new int[] {5,85,5,7,2,45,3,56,21};
		
		quicksort(A, 0, A.length-1);
		
		for (int i : A) {
			System.out.print(i+" ");
		}
		
	
	}
	static void swap(int[]array,int a, int b)
	{
		int aux=array[a];
		array[a] = array[b];
		array[b] = aux;
		
		
	}
	static int particion(int[]array,int left,int right) {
		
		
		int pivote =array[right];
		for (int i = left; i < right; i++) 
		{
			if (array[i] < pivote) {
				swap(array, left, i);
				left++;
				
			}
		}
		swap(array, left, right);
		
		return left;
	}
	static int otraParticion(int[]array, int left,int right)
	{
		int pivote = array[(left+right)/2];
		
		while(array[left] < pivote) {left++;}
		while(array[right] > pivote) {right--;}
		
		if(left <= right)
		{
			swap(array, left, right);
			left++;
			right--;
		}
		return left;
	}
		
	
	static void quicksort(int[]array, int left, int right ) {
		
		if (left < right) {
			
			int pivote = particion(array, left, right);
					
			quicksort(array, left, pivote-1);
			quicksort(array, pivote+1, right);
			
		}
		
	}

}
