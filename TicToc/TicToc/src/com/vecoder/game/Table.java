package com.vecoder.game;

public class Table {

	private final static String PATH_TO_IMG_X = "/resources/img/X.png";
	private final static String PATH_TO_IMG_O = "/resources/img/O.png";
	private final static String PATH_TO_IMG_EMPTY = "/resources/img/empty.png";
		
	private Image[] gameImages;

	private Image emptyImg;
	private Image XImg;
	private Image OImg;
	
	public Table() {
		emptyImg = new Image(PATH_TO_IMG_EMPTY);
		XImg = new Image(PATH_TO_IMG_X);
		OImg = new Image(PATH_TO_IMG_O);
		
		gameImages = new Image[9];
		clearTable();
	}
	
	public void clearTable() {	
		setGameImages(emptyImg);
	}
	
	public Image getElment(int index) {
		return gameImages[index];
	}	
	
	public void setElmentWithEmpty(int index) {
		gameImages[index] = getEmptyImg();
	}
	
	public void setElmentWithX(int index) {
		gameImages[index] = getXImg();
	}
	
	public void setElmentWithO(int index) {
		gameImages[index] = getOImg();
	}
	
	public Image[] getGameImages() {
		return gameImages;
	}
	
	protected void setGameImages(Image img) {
		for (int i = 0; i < gameImages.length; i++) {
			gameImages[i] = img;
		}
	}
	
	public String[] getGameImagesToArrayOfString() {
		String[] ImagesStrArr = new String[gameImages.length];
		
		for (int i = 0; i < gameImages.length; i++) {
			ImagesStrArr[i] = gameImages[i].getPathToImg();
		}
		return ImagesStrArr;
	}

	public Image getEmptyImg() {
		return emptyImg;
	}

	public void setEmptyImg(Image emptyImg) {
		this.emptyImg = emptyImg;
	}

	public Image getXImg() {
		return XImg;
	}

	public void setXImg(Image xImg) {
		XImg = xImg;
	}

	public Image getOImg() {
		return OImg;
	}

	public void setOImg(Image oImg) {
		OImg = oImg;
	}
}
