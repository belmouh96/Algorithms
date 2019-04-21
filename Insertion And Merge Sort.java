//Ismail Belmouh

import java.util.*;

public class Sort {
	
	
	public static int[] insertion_sort (int[] array) {
		/*
		 * fill in your program
		 */
       int n = array.length;
       for( int i=1; i<n; ++i)
       {
         int key = array[i];
         int j = i-1;
         
         while(j >= 0 && array[j]>key)
         {
            array[j+1] = array[j];
            j = j-1;
         }
         array[j+1] = key;
       }
       return array;


	}
	
	public static int[] merge_sort (int[] array, int p, int r) {
		/*
		 * fill in your program
		 */
		int q;
		
		if (p < r)
		{
			q = (p + r) / 2;
			Sort.merge_sort(array, p, q);
			Sort.merge_sort(array, q+1, r);
			Sort.merge(array, p, q, r);
		}
		return array;

	}
	
	public static int[] merge (int[] array, int p, int q, int r) {
		/*
		 * fill in your program
		 */
		int n1, n2, k, i, j;
		int[] L, R;
		
		n1 = q - p +1;
		n2 = r - q;
		
		L = new int[n1 +1];
		R = new int[n2+1];
		
		for(i = 0; i < n1; i++)
		{
			L[i] = array[p+i];
		}
		for(j = 0; j < n2; j++)
		{
			R[j] = array[q+1+j];
		}
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		k = p;
		i = 0;
		j = 0;
		
		for(; k <= r; k++)
		{
			if(L[i] <= R[j])
			{
				array[k] = L[i];
				i++;
			}
			else{
				array[k] = R[j];
			}
			
		}
		
		return array;

	}
	
	/*
	 * n: the size of the output array
	 * k: the maximum value in the array
	 */
	public static int[] generate_random_array (int n, int k) {
		List<Integer> list;
		int[] array;
		Random rnd;
		
		rnd = new Random(System.currentTimeMillis());
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(rnd.nextInt(k+1)));
		
		Collections.shuffle(list, rnd);
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * n: the size of the output array
	 */
	public static int[] generate_random_array (int n) {
		List<Integer> list;
		int[] array;
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(i));
		
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * Input: an integer array
	 * Output: true if the array is acsendingly sorted, otherwise return false
	 */
	public static boolean check_sorted (int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i])
				return false;
		}
		return true;
	}
	
	public static void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 100;
		
		System.out.println("Insertion sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort.insertion_sort(array);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Insertion sort ends ------------------");

		
		System.out.println("Merge sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort.merge_sort(array, 0, n-1);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Merge sort ends ------------------");
	}

}
