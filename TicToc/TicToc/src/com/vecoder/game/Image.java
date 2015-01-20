package com.vecoder.game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Image {

	private String pathToImg;
	public Image() {
		// TODO Auto-generated constructor stub
	}
	
	public Image(String pathToImg) {
		this.pathToImg = pathToImg;
	}
	
	public String getPathToImg() {
		return pathToImg;
	}

	public void setPathToImg(String pathToImg) {
		this.pathToImg = pathToImg;
	}

}
