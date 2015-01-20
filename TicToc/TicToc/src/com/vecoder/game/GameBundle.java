package com.vecoder.game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "game")
@SessionScoped
public class GameBundle {
	private static final int[][] WIN_COMBINATIONS = new int[][] { { 0, 1, 2 },
			{ 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
			{ 0, 4, 8 }, { 6, 4, 2 } };

	Table table;
	Message message;
	boolean isFinish;
	boolean isEndGame;
	PCPlayer pcPlayer;

	public GameBundle() {
		isFinish = false;
		table = new Table();
		message = new Message();
		pcPlayer = new PCPlayer();
	}

	public void clickActionEvent(ActionEvent ae) {
		int field = Integer.parseInt(ae.getComponent().getId().split("_")[1]);
		boolean isHasX = table.getElment(field).getPathToImg().equals(table.getXImg().getPathToImg());
		
		if(!(isFinish || isHasX)) {
			table.setElmentWithX(field);

			if (isWin(table.getXImg().getPathToImg())) {
				message.setMessage(IMessage.WIN_MESSAGE);
				isFinish = true;
			}
			
			if(!isFinish){
				int index = pcPlayer.move(table);
				if(index<0){
					isEndGame = true;
					message.setMessage(IMessage.END_MESSAGE);
				}
				else {
					table.setElmentWithO(index);
				}				
			}

			if (isWin(table.getOImg().getPathToImg())) {
				message.setMessage(IMessage.LOSE_MESSAGE);
				isFinish = true;
			}
		}
	}

	private boolean isWin(String symbol) {
		boolean isHasWin = false;

		for (int i = 0; i < WIN_COMBINATIONS.length; i++) {
			int indexFirst = WIN_COMBINATIONS[i][0];
			int indexSecond = WIN_COMBINATIONS[i][1];
			int indexThird = WIN_COMBINATIONS[i][2];

			isHasWin = isLine(indexFirst, indexSecond, indexThird, symbol);

			if (isHasWin)
				break;
		}
		return isHasWin;
	}

	private boolean isLine(int indexFirst, int indexSecond, int indexThird,
			String symbol) {
		String[] gameTableArr = table.getGameImagesToArrayOfString();

		boolean isHasLine = gameTableArr[indexFirst].equals(symbol)
				&& gameTableArr[indexSecond].equals(symbol)
				&& gameTableArr[indexThird].equals(symbol);

		return isHasLine;
	}

	public String[] getImages() {
		return table.getGameImagesToArrayOfString();
	}

	public String getMessage() {
		return message.getMessage();
	}

	public void clear() {
		table.clearTable();
		message.setMessage(IMessage.EMPTY_MESSAGE);
		isFinish = false;
	}
}
