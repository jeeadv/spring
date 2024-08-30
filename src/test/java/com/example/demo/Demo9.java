package com.example.demo;

/*
Simulate a card game.
Rules are -
Two player game
From a deck of 52 cards, 9 cards will be given to each player.
There will be rounds of play each round each player will draw and put one card from top of their pile to the board. The player will highest number wins.
Ties in number will result in draw of that round
Player with highest round wins will win the game.
 */

import java.util.*;

public class Demo9
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.shuffle();
        List<Card> randomCards1 = deck.getTop9Cards();
        Player p1 = new Player();
        p1.assign(randomCards1);
        Player p2 = new Player();
        List<Card> randomCards2 = deck.getTop9Cards();
        p2.assign(randomCards2);
    }

    private static class Player
    {
        Stack<Integer> stack;

        Player()
        {
            stack = new Stack<>();
        }

        public void assign(List<Card> list)
        {

        }
    }

    static class Card
    {
        int number;
        SUITE suite;

        Card(int number, SUITE suite)
        {

        }
    }

    enum SUITE
    {
        SPADE, CLUB, DIAMOND, HEART
    }
}

class Deck
{
    List<Demo9.Card> cardList;

    Deck()
    {
        for (int i = 1; i <= 13; i++)
        {
            cardList.add(new Demo9.Card(i, Demo9.SUITE.CLUB));
            cardList.add(new Demo9.Card(i, Demo9.SUITE.HEART));
            cardList.add(new Demo9.Card(i, Demo9.SUITE.DIAMOND));
            cardList.add(new Demo9.Card(i, Demo9.SUITE.SPADE));
        }

    }

    public List<Demo9.Card> getTop9Cards()
    {
        List<Demo9.Card> result = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            result.add(cardList.remove(0));
        }
        return result;
    }

    public void shuffle()
    {
        for (int i = 0; i < 100; i++)
        {
            Random random = new Random();
            int index1 = 0;
            int index2 = 0;
            swap(index1, index2);
        }
    }

    private void swap(int i, int j)
    {

    }
}
