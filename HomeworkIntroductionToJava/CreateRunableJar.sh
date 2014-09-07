#!/bin/bash

jar cvfme $1.jar Mainfest.txt $1 lib -C ./bin .
javac -cp ./lib/*.jar src/DeckOfCards.java
