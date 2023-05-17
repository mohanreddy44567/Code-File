package com.StringComparasion;

import java.util.HashMap;
import java.util.Scanner;

public class StringCompare {
	static Scanner s = new Scanner(System.in);
	public static boolean confirmation() {
		System.out.println("choose yes or no by clicking 1 or 0 respectively");
		int opt = s.nextInt();
		while(opt>1 || opt<0) {
			System.out.println("Oops!! Error selection");
			System.out.println();
			System.out.print("Please choose valid option: ");
			opt = s.nextInt();
		}
		if(opt==1) {
			return true;
		}
		return false;
	}
	public static String[] take_words(int n) {
		String[] words = new String[n];
		System.out.println("Give the words of your choice: ");
		for(int i=0;i<n;i++) {
			words[i] = s.next();
			
		}
		return words;
	}
	public static void take_words_count() {
		System.out.print("Hii, choose the count of words to compare: ");
		int n = s.nextInt();
		System.out.println();
		while(n<2 || n>5) {
			if(n<2) {
				System.out.println("can't cpmpare less than 2 strings!! ");
				System.out.println();
				System.out.println("do you want to abort the operation?");
				System.out.println();
				
				if(confirmation()) {
					System.out.println("The operation is aborted due to insufficent or unsupported count of words!!");
					System.out.println("would you like to compare more words?");
					return;
					
				}
				else {
					take_words_count();
					return;
				}
			}
			else if(n>5) {
				System.out.println("Limit of words exceeded,, please choose less than 6 words");
				System.out.println();
				System.out.print("Would you like to decrease the words count??");
				
				if(confirmation()) {
					take_words_count();
					return;
					
				}
				else {
					System.out.println("The operation is aborted due to exceeding the count od words limit!!");
					System.out.println("Would you like to compare more words?");
					return;
					
				}
			}
		}
		String[] words = take_words(n);
		int[][] x = compareByOrder(words);
	}
	public static int[][] compareByOrder(String[] x){
		HashMap<String, Integer> resDiff = new HashMap<>();
		int[][] res = new int[5][5];
		for(int i=0;i<x.length-1;i++) {
			int[] temp_res = new int[5];
			int k = 0;
			for(int j=i+1;j<x.length;j++) {
				System.out.print(x[i]+" - "+x[j]+" is: ");
				if(!resDiff.containsKey(x[i]+" - "+x[j])) {
					resDiff.put(x[i]+" - "+x[j], x[i].compareToIgnoreCase(x[j]));
				}
				temp_res[k] = (x[i].compareToIgnoreCase(x[j]));
				System.out.println(temp_res[k]);
				System.out.println();
				if(temp_res[k]>0) {
					System.out.println(x[i]+" > "+x[j]);
				}
				else if(temp_res[k]<0) {
					System.out.println(x[i]+" < "+x[j]);
					
				}
				else {
					System.out.println(x[i]+" = "+x[j]);
				}
				k++;
			
			}
			res[i] = temp_res;
			
		}
		System.out.println("Would you like to compare more words?");
		return res;
		
	}
	public static void main(String[] args) {
		take_words_count();
		
		while(confirmation()) {
			take_words_count();
		}
		return;
	}

}



































