import java.io.*;
import java.util.*;

public class CardTest {

    public static List<Card> cardDeck;

    // Generate a random number specified from the given min, max

    public static int generateRandomNum(int min, int max){
    
        int range = (max - min) + 1;
        int temp = (int)(Math.random() * range) + min;
        
        return temp;
    }

    // Get a random card from the deck as well as remove 
    // card because that card is not in the deck anymore

    public static Card getRandomCard(){
       
        int max = cardDeck.size() - 1;
        int num = generateRandomNum(0, max);
    
        Card card = (Card) cardDeck.remove(num);
        
        return card;
    }

    public static void createDeck(){

        cardDeck = new ArrayList<Card>();

        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Red", CardType.HEARTS, cardValue));
        
        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Red", CardType.DIAMONDS, cardValue));

        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Black", CardType.SPADES, cardValue));
        
        for(CardValue cardValue: CardValue.values())
            cardDeck.add(new Card("Black", CardType.CLUBS, cardValue));

    }

    public static void drawCards(int num){
            
        for(int i = 0; i < num; i++){ 
        
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

        }
    }

    public static void printDeck(){
        for(Card card: cardDeck)
            System.out.println(card);
    }

    public static void main(String[] args){
        createDeck(); 
        drawCards(2);
        //printDeck();
    }
}
