package ru.guimi;

import java.lang.reflect.Array;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int arr[][] = new int[11][11];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				arr[i][j]=(int) (Math.random()*111);
				System.out.println("arr["+i+"]["+j+"]="+arr[i][j]);
			}
		}
	}
}
