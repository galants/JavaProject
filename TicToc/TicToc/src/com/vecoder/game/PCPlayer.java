package com.vecoder.game;

import java.util.Random;

public class PCPlayer {
	
	public int move(Table table) {
		int count = 0;
		int rndIndex = 0;
		int index = -1;
		
		Random rnd = new Random();
		
		String[] gameImages = table.getGameImagesToArrayOfString();
		String emptyImage =  table.getEmptyImg().getPathToImg();

		count = getCountEmpty(gameImages, emptyImage);
		
		if(count>0) {
			rndIndex = rnd.nextInt(count);
			count = 0;
			
			for (int i = 0; i < gameImages.length; i++) {
				if(gameImages[i].equals(emptyImage)) {			
					if(rndIndex==count){
						index = i;
						break;
					}
					count++;
				}
			}
		}
		
		return index;
	}
	
	private int getCountEmpty(String[] strArr, String empty) {
		int count = 0;
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].equals(empty)) {
				count++;
			}
		}
		
		return count;
	}
}
