
import java.io.FileOutputStream;
import java.io.IOException;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class DeckOfCards {

	private static final String PDF_FILE = "Cards.pdf";
	private static final String TTF_FILE = "./lib/times.ttf";
	private static final int SIZE_WIGHT = 135;
	private static final int SIZE_HEIGHT = 90;
	private static final float SIZE_FLOAT = 38f;
	private static final int NUMBER_CARDS_LINE_PDF = 4;
	private static BaseFont baseFont;
	private static Card[][] cards;

	public static void main(String[] args) throws DocumentException,
			IOException {
		Deck deck = new Deck();
		cards = deck.allCards();

		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(PDF_FILE));
			
			doc.open();

			baseFont = BaseFont.createFont(TTF_FILE,
					BaseFont.IDENTITY_H, true);

			PdfPTable tableContainer = new PdfPTable(NUMBER_CARDS_LINE_PDF);
			tableContainer.getDefaultCell().setBorder(0);

			for (int i = 0; i < cards.length; i++) {
				for (int j = 0; j < cards[i].length; j++) {
					PdfPTable card = createCardPDF(i,j);
					tableContainer.addCell(card);
				}
			}
			doc.add(tableContainer);
			doc.close();
			
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static PdfPTable createCardPDF(int i, int j) {

		PdfPTable cardPDF = new PdfPTable(1);
		cardPDF.getDefaultCell().setFixedHeight(SIZE_WIGHT);
		cardPDF.setTotalWidth(SIZE_HEIGHT);
		cardPDF.setLockedWidth(true);
		cardPDF.getDefaultCell().setVerticalAlignment(
				Element.ALIGN_MIDDLE);
		cardPDF.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_CENTER);

		Card card = cards[i][j];
		Suit suit = card.getSuit();
		BaseColor baseColor = suit.getSuitColor();
		
		Font deckFont = new Font(baseFont, SIZE_FLOAT);
		deckFont.setColor(baseColor);

		String cellContent = (card.printCard());
		cardPDF.addCell(new Phrase(cellContent, deckFont));
		
		return cardPDF;
	}
}

class Suit {

	private char suit;
	private BaseColor suitColor;

	public Suit() {
	}

	public Suit(char suit, BaseColor suitColor) {
		setSuit(suit);
		setSuitColor(suitColor);
	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}

	public BaseColor getSuitColor() {
		return suitColor;
	}

	public void setSuitColor(BaseColor suitColor) {
		this.suitColor = suitColor;
	}

}

class Card {
	String cardName;
	Suit suit;

	public Card() {
	}

	public Card(String cardName, Suit suit) {
		this.cardName = cardName;
		this.suit = suit;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public String printCard() {

		String str = getCardName() + " " + suit.getSuit();

		return str;

	}
}

class Deck {
	String[] cards = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
			"Q", "K" };
	Suit[] suits = { new Suit('\u2665', BaseColor.RED),
			new Suit('\u2663', BaseColor.BLACK),
			new Suit('\u2666', BaseColor.RED),
			new Suit('\u2660', BaseColor.BLACK) };

	private Card getCard(int cardId, int suitID) {
		String strCard = cards[cardId];
		Suit suit = suits[suitID];

		Card card = new Card(strCard, suit);

		return card;
	}

	public Card[][] allCards() {
		Card[][] allCards = new Card[cards.length][suits.length];

		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				allCards[i][j] = getCard(i, j);
			}
		}

		return allCards;
	}
}