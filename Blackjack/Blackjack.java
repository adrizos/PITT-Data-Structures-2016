/**
 * Alex Drizos
 * CS 0445
 * Assignment 1
 */

//imports

public class Blackjack {


    public static void main (String[] args){
        /** variables **/
        int numTies=0, numCards=Integer.parseInt(args[1])*52, numRounds=Integer.parseInt(args[0]), playerWins=0, dealerWins=0;
        boolean blackJack, tied, playerWon, dealerWon,dealerAce,playerAce;
        final int maximumHand = 22; //maximum number of cards a player could have in a hand


        /** create shoe object with user specified numCards **/
        RandIndexQueue<Card> shoe = new RandIndexQueue<Card>(numCards);

        for (int i = 0; i<Integer.parseInt(args[1]);i++) {
            //add clubs cards
            Card c = new Card(Card.Suits.Clubs, Card.Ranks.Two);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Three);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Four);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Five);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Six);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Seven);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Eight);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Nine);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Ten);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Jack);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Queen);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.King);
            shoe.addItem(c);
            c = new Card(Card.Suits.Clubs, Card.Ranks.Ace);
            shoe.addItem(c);
            //add diamond cards
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Two);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Three);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Four);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Five);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Six);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Seven);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Eight);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Nine);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Ten);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Jack);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Queen);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.King);
            shoe.addItem(c);
            c = new Card(Card.Suits.Diamonds, Card.Ranks.Ace);
            shoe.addItem(c);
            //adding hearts cards
            c = new Card(Card.Suits.Hearts, Card.Ranks.Two);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Three);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Four);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Five);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Six);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Seven);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Eight);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Nine);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Ten);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Jack);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Queen);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.King);
            shoe.addItem(c);
            c = new Card(Card.Suits.Hearts, Card.Ranks.Ace);
            shoe.addItem(c);
            //add spades cards
            c = new Card(Card.Suits.Spades, Card.Ranks.Two);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Three);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Four);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Five);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Six);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Seven);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Eight);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Nine);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Ten);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Jack);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Queen);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.King);
            shoe.addItem(c);
            c = new Card(Card.Suits.Spades, Card.Ranks.Ace);
            shoe.addItem(c);
        } // end of create deck(s) loop

        /** shuffle the deck(s) **/
        shoe.shuffle();

        /** create discard pile **/
        RandIndexQueue<Card> discardPile = new RandIndexQueue<Card>(numCards);

        /**round(s) begin(s)**/
        for (int i= 0; i<numRounds; i++)
        {

            System.out.println("Shoe size: "+shoe.size());
            System.out.println("pile size: "+discardPile.size());

            /** check shoe size for reshuffle **/
            if (shoe.size() <= (.25 * numCards))
            {
                for (int b = 0; b < discardPile.size(); b++) {
                    shoe.addItem(discardPile.removeItem());
                }
                //shuffle cards
                if (numRounds > 10)
                    System.out.printf("Reshuffling the shoe in round: %d\n", i);
                shoe.shuffle();
            } //end of check shoe size

            //trace output for rounds over 10
            if (numRounds <=10)
                System.out.println("\nRound " + i + " beginning");

            //set/reset values
            blackJack = false;
            tied = false;
            playerWon=false;
            dealerWon=false;
            dealerAce=false;
            playerAce=false;

            //create player hand object
            RandIndexQueue<Card> playerHand = new RandIndexQueue<Card>(maximumHand);
            //create dealer hand object
            RandIndexQueue<Card> dealerHand = new RandIndexQueue<Card>(maximumHand);


            /** deal two cards to each player (alternating deal) **/
            playerHand.addItem(shoe.removeItem());
            dealerHand.addItem(shoe.removeItem());
            playerHand.addItem(shoe.removeItem());
            dealerHand.addItem(shoe.removeItem());

            //variables for hand totals
            int playerHandTotalValue=0, dealerHandTotalValue=0;

            //change these to methods?
            /** tally player hand value **/
            playerHandTotalValue =0; //reset before adding full hand up
            for (int t = 0; t <playerHand.size(); t++)
            {
                Card tempCard = playerHand.get(t);
                playerHandTotalValue+=tempCard.value();
                if (tempCard.value()==1) //check for ace
                    playerAce=true;
            } // end of tally player cards loop

            /** tally dealer hand value **/
            dealerHandTotalValue = 0; // reset before tallying full hand
            for (int t = 0; t <dealerHand.size(); t++)
            {
                Card tempCard = dealerHand.get(t);
                dealerHandTotalValue+=tempCard.value();
                if (tempCard.value()==1) //check for ace
                    dealerAce=true;
            } // end of tally dealer cards loop


            /** compare hands **/

            //account for player ace as 11
            if (playerHandTotalValue <12 && playerAce)
            {
                playerHandTotalValue+=10;
            }

            //account for dealer ace as 11
            if (dealerHandTotalValue <12 && dealerAce)
            {
                dealerHandTotalValue+=10;
            }

            //trace output for dealer/player hands for rounds over 10
            if (numRounds <=10)
            {
                System.out.printf("Player: %s : %d\n", playerHand.toString(),playerHandTotalValue);
                System.out.printf("Dealer: %s: %d\n", dealerHand.toString(), dealerHandTotalValue);
            }

            /** check for blackjacks **/

            //did both get blackjack
            if (checkForBlackJackD(dealerHandTotalValue) == true && checkForBlackJackP(playerHandTotalValue)==true)
            {
                blackJack = true;
                if (numRounds <=10)
                    System.out.println("Result: Dealer/Player Both Blackjack - Tie!");
                numTies+=1;
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }
            //did dealer get blackjack
            if (checkForBlackJackD(dealerHandTotalValue)==true)
            {
                blackJack = true;
                dealerWins+=1;
                dealerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Dealer Blackjack wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }
            //did player get blackjack
            if (checkForBlackJackP(playerHandTotalValue)==true)
            {
                blackJack = true;
                playerWins+=1;
                playerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Player Blackjack wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }

            /** check for busts **/

            //did both bust
            if (checkForBustD(dealerHandTotalValue) && checkForBustP(playerHandTotalValue))
            {
                if (numRounds <=10)
                    System.out.println("Result: Dealer / Player bust!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }

            //did dealer bust
            if (checkForBustD(dealerHandTotalValue))
            {
                playerWins += 1;
                playerWon = true;
                if (numRounds <=10)
                    System.out.println("Result: Dealer busts - Player wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }
            //did player bust
            if (checkForBustP(playerHandTotalValue))
            {
                dealerWins+=1;
                dealerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Player Busts - dealer wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }

            //assuming neither player busts....
            /** PLAYER stay or hit **/
            if (shouldPlayerHit(playerHandTotalValue)==true)
            {

                playerHand.addItem(shoe.removeItem()); //player takes another card if under 17
                if (numRounds <=10)
                    System.out.println("Player Hits: "+ playerHand.get(playerHand.size()-1));
            }
            if (shouldDealerHit(playerHandTotalValue) ==false)
            {
                if (numRounds <=10)
                    System.out.println("Player Stands: "+ playerHand.toString());
            }

            /** tally player hand value **/
            playerHandTotalValue=0; //reset to tally the full hand with new additions
            for (int t = 0; t < playerHand.size(); t++)
            {
                Card tempCard = playerHand.get(t);
                playerHandTotalValue+=tempCard.value();
            } // end of tally player cards loop

            //check for blackjack
            if (checkForBlackJackP(playerHandTotalValue)==true)
            {
                blackJack = true;
                playerWins+=1;
                playerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Player Blackjack wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }
            //check for bust
            if (checkForBustP(playerHandTotalValue))
            {
                dealerWins+=1;
                dealerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Player Busts - Dealer wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            } //end of check for bust

            /** DEALER stay or hit **/
            if (shouldDealerHit(dealerHandTotalValue)==true)
            {

                dealerHand.addItem(shoe.removeItem()); //dealer takes another card if under 17
                if (numRounds <=10)
                    System.out.println("Dealer Hits: "+ dealerHand.get(dealerHand.size()-1));
            }
            else
            {
                if (numRounds <=10)
                    System.out.println("Dealer Stands: "+ dealerHand.toString());
            }

            /** tally dealer hand value **/
            dealerHandTotalValue = 0; //reset value to re tally total with full hand and additions
            for (int t = 0; t <dealerHand.size(); t++)
            {
                Card tempCard = dealerHand.get(t);
                dealerHandTotalValue+=tempCard.value();
            } // end of tally dealer cards loop

            //check for blackjack
            if (checkForBlackJackD(dealerHandTotalValue)==true)
            {
                blackJack = true;
                dealerWins+=1;
                dealerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Dealer Blackjack wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }
            //check for bust
            if (checkForBustD(dealerHandTotalValue))
            {
                playerWins+=1;
                playerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Dealer Busts -player wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            } //end of check for bust

            /** if neither player gets blackjack or busts **/

            if (dealerHandTotalValue > playerHandTotalValue)
            {
                dealerWins+=1;
                dealerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Dealer wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            } //dealer wins by points

            else if (playerHandTotalValue > dealerHandTotalValue)
            {
                playerWins+=1;
                playerWon=true;
                if (numRounds <=10)
                    System.out.println("Result: Player wins!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            } //player wins by points

            else if (playerHandTotalValue == dealerHandTotalValue)
            {
                numTies+=1;
                if (numRounds <=10)
                    System.out.println("Result: tie!");
                //send both hands to discard pile
                for (int h=0; h<dealerHand.size(); h++)
                {
                    discardPile.addItem(dealerHand.removeItem());
                }
                for (int h=0; h<playerHand.size(); h++)
                {
                    discardPile.addItem(playerHand.removeItem());
                }
                continue;
            }

        }   // end of rounds loop

        /** show final results after x rounds **/
        showFinalResults(playerWins,dealerWins,numTies,numRounds);


    }//end of main


    public static void showFinalResults(int _playerWins, int _dealerWins, int _numTies, int _numRounds)
    {
        System.out.printf("\n\nAfter %d rounds, here are the results: \n", _numRounds);
        System.out.printf("\tDealer Wins: %d\n", _dealerWins);
        System.out.printf("\tPlayer Wins: %d\n", _playerWins);
        System.out.printf("\tPushes: %d\n\n", _numTies);

    } // end of show final results method

    public static boolean checkForBlackJackP(int _playerHandTotalValue)
    {
        if (_playerHandTotalValue ==21)
            return true;
        return false;
    }   //end of check for blackjack player

    public static boolean checkForBlackJackD(int _dealerHandTotalValue)
    {
        if (_dealerHandTotalValue ==21)
            return true;
        return false;
    }   //end of check for blackjack player

    public static boolean shouldPlayerHit(int _playerHandTotalValue)
    {
        if (_playerHandTotalValue <= 17)
            return true;
        return false;
    }   // end of player stay or hit

    public static boolean shouldDealerHit(int _dealerHandTotalValue)
    {
        if (_dealerHandTotalValue <= 17)
            return true;
        return false;
    }   // end of dealer stay or hit

    public static boolean checkForBustP(int _playerHandTotalValue)
    {
        if (_playerHandTotalValue >21)
            return true;
        return false;
    }

    public static boolean checkForBustD(int _dealerHandTotalValue)
    {
        if (_dealerHandTotalValue >21)
            return true;
        return false;
    }
}//end of class
