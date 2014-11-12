import java.io.*;
import java.util.*;

enum CardValue {
        ACE, 
        TWO, 
        THREE, 
        FOUR, 
        FIVE, 
        SIX, 
        SEVEN, 
        EIGHT, 
        NINE, 
        TEN, 
        JOKER, 
        QUEEN, 
        KING
}

enum CardType {
        HEARTS, 
        DIAMONDS, 
        SPADES, 
        CLUBS
}

class CardTypeException extends Exception {
   
    public CardTypeException(){
        System.err.println("Exception: Invalid Card type");
    }
}

class CardValueException extends Exception {
   
    public CardValueException(){
        System.err.println("Exception: Invalid Card type");
    }
}

class Card implements Comparable<Card>{
    
    private String color;
    private CardType cardType;   
    private CardValue cardValue;

    public Card(){}

    public Card(String color, CardType cardType, CardValue cardValue){
        setColor(color);
        setCardType(cardType);
        setCardValue(cardValue);
    }

    private void setColor(String color){
        this.color = color;
    }
    
    private void setCardType(CardType cardType){
        this.cardType = cardType;
    }
    
    private void setCardValue(CardValue cardValue){
        this.cardValue = cardValue;
    }

    public String getColor(){
        return color;
    }

    public String getCardType(){
        
        String temp = "";

        switch(cardType){
            case HEARTS:
                temp = "Hearts";
                break;
            case DIAMONDS:
                temp = "Diamonds";
                break;
            case SPADES:
                temp = "Spades";
                break;
            case CLUBS:
                temp = "Clubs";
                break;
            default:
                temp = "";
                break;
        }

        return temp;
    }
    
    public int getCardValueNum(){
        
        int temp = 0;

        switch(cardValue){
            case ACE:
                temp = 1;
                break;
            case TWO:
                temp = 2;
                break;
            case THREE:
                temp = 3;
                break;
            case FOUR:
                temp = 4;
                break;
            case FIVE:
                temp = 5;
                break;
            case SIX:
                temp = 6;
                break;
            case SEVEN:
                temp = 7;
                break;
            case EIGHT:
                temp = 8;
                break;
            case NINE:
                temp = 9;
                break;
            case TEN:
                temp = 10;
                break;
            case JOKER:
                temp = 11;
                break;
            case QUEEN:
                temp = 12;
                break;
            case KING:
                temp = 13;
                break;
            default:
                temp = 0;
                break;
       }

       return temp;
    }

    public String getCardValue(){
        
        String temp = "";

        switch(cardValue){
            case ACE:
                temp = "1";
                break;
            case TWO:
                temp = "2";
                break;
            case THREE:
                temp = "3";
                break;
            case FOUR:
                temp = "4";
                break;
            case FIVE:
                temp = "5";
                break;
            case SIX:
                temp = "6";
                break;
            case SEVEN:
                temp = "7";
                break;
            case EIGHT:
                temp = "8";
                break;
            case NINE:
                temp = "9";
                break;
            case TEN:
                temp = "10";
                break;
            case JOKER:
                temp = "Joker";
                break;
            case QUEEN:
                temp = "Queen";
                break;
            case KING:
                temp = "King";
                break;
            default:
                temp = "";
                break;
       }

       return temp;
    }

    public int compareTo(Card card){
        
        int cardValue = this.getCardValueNum();
        int otherCardValue = card.getCardValueNum();

        if(cardValue > otherCardValue)
            return 1;
        else if(cardValue < otherCardValue)
            return -1;
        else
            return 0;
    }
    
    public String toString(){
        return getCardValue() + " of " + getColor() + " " + getCardType();
    }
}

public class CardTest {

    public static List<Card> cardDeck;

    public static int generateRandomNum(int min, int max){
        int range = (max - min) + 1;
        int temp = (int)(Math.random() * range) + min;
        
        return temp;
    }

    public static Card getRandomCard(){
        
        int num = generateRandomNum(0, cardDeck.size()-1);
    
        Card card = (Card) cardDeck.remove(num);
        
        return card;
    }

    public static void main(String[] args){

        cardDeck = new ArrayList<Card>();

        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Red", CardType.HEARTS, cardValue));
        
        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Red", CardType.DIAMONDS, cardValue));

        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Black", CardType.SPADES, cardValue));
        
        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Black", CardType.CLUBS, cardValue));
   

        int i = 0;
        
        do {
            
            Card userCard = getRandomCard();
            Card computerCard = getRandomCard();

            int val = userCard.compareTo(computerCard);

            System.out.println("User Card: " + userCard);
            System.out.println("Computer Card: " + computerCard);
       
            if(val == 1)
                System.out.println("User Won");
            else if(val == -1)
                System.out.println("Computer Won");
            else 
                System.out.println("No one won");

            i++;

        } while(i < 6);

        //for(Card card : cardDeck)
       //     System.out.println(card);
    }
}
