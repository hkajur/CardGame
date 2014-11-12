/*
 * Card Class
 *
 * Create an Card class which has the card color
 * and the enums for cardValue and cardType
 * 
 * Once the color, cardValue and cardType are set,
 * they cannot be changed
 *
 */

class Card implements Comparable<Card>{
    
    private String color;
    private CardType cardType;   
    private CardValue cardValue;
    
    // Adding a empty constructor if needed to extend this class
   
    public Card(){}

    public Card(String color, 
           CardType cardType, 
           CardValue cardValue){
        
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
            case HEARTS:    temp = "Hearts";    break;
            case DIAMONDS:  temp = "Diamonds";  break;
            case SPADES:    temp = "Spades";    break;
            case CLUBS:     temp = "Clubs";     break;
            default:        temp = "";          break;
        }

        return temp;
    }
    
    public int getCardValueNum(){
        
        int temp = 0;

        switch(cardValue){
            case ACE:   temp = 1;   break;
            case TWO:   temp = 2;   break;
            case THREE: temp = 3;   break;
            case FOUR:  temp = 4;   break;
            case FIVE:  temp = 5;   break;
            case SIX:   temp = 6;   break;
            case SEVEN: temp = 7;   break;
            case EIGHT: temp = 8;   break;
            case NINE:  temp = 9;   break;
            case TEN:   temp = 10;  break;
            case JOKER: temp = 11;  break;
            case QUEEN: temp = 12;  break;
            case KING:  temp = 13;  break;
            default:    temp = 0;   break;
       }

       return temp;
    }

    public String getCardValue(){
        
        String temp = "";

        switch(cardValue){
            case ACE:   temp = "Ace";   break;
            case TWO:   temp = "2";     break;
            case THREE: temp = "3";     break;
            case FOUR:  temp = "4";     break;
            case FIVE:  temp = "5";     break;
            case SIX:   temp = "6";     break;
            case SEVEN: temp = "7";     break;
            case EIGHT: temp = "8";     break;
            case NINE:  temp = "9";     break;
            case TEN:   temp = "10";    break;
            case JOKER: temp = "Joker"; break;
            case QUEEN: temp = "Queen"; break;
            case KING:  temp = "King";  break;
            default:    temp = "";      break;
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
