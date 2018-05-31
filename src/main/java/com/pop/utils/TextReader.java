package com.pop.utils;

import java.util.Scanner;

public class TextReader implements ReaderHelper {

	private static Scanner sc= new Scanner(System.in);
	
	public int readInt() {
		return sc.nextInt();
	}

	public String readString(){
		sc.reset();
		return sc.next();
	}
}
