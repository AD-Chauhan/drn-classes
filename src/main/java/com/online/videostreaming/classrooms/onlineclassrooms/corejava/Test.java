package com.online.videostreaming.classrooms.onlineclassrooms.corejava;

public class Test {

	public static void main(String[] args) {
		Immutable im =new Immutable();
		System.out.print(im.toString());
		im.getDate().setTime(1L);
		System.out.print(im.toString());
	}
	
}
