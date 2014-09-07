@echo off
IF not "%1"== "/?" (
	java -jar DeckOfCards.jar
) ELSE (
	java -jar %1.jar
)