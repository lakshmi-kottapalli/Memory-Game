import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;


public class MemoryGame {

    public static Card[] shuffleArray(Card[] array) {
        Random random = new Random(); 
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); 
            Card temp = array[i]; //swap
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
     
    public static void main(String[] args) {

        ArrayList<Card> flippedCards = new ArrayList<Card>(1);
        ArrayList<Card> matched = new ArrayList<Card>(2);

        JFrame frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        JPanel cardPanel = new JPanel(new GridLayout(4, 4));
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setPreferredSize(new Dimension(700, 500));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        Card[] cardDeck = new Card[16]; //adds all buttons

        //images
    ImageIcon Aa = new ImageIcon("images/blueberry.png");

    Image Aimage = Aa.getImage();
    Image AscaledImage = Aimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon A = new ImageIcon(AscaledImage);

    ImageIcon Bb = new ImageIcon("images/bread.png");

    Image Bimage = Bb.getImage();
    Image BscaledImage = Bimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon B = new ImageIcon(BscaledImage);

    ImageIcon Cc = new ImageIcon("images/lemon.png");

    Image Cimage = Cc.getImage();
    Image CscaledImage = Cimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon C = new ImageIcon(CscaledImage);

    ImageIcon Dd = new ImageIcon("images/lime.png");

    Image Dimage = Dd.getImage();
    Image DscaledImage = Dimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon D = new ImageIcon(DscaledImage);

    ImageIcon Ee = new ImageIcon("images/orange.png");

    Image Eimage = Ee.getImage();
    Image EscaledImage = Eimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon E = new ImageIcon(EscaledImage);

    ImageIcon Ff = new ImageIcon("images/pear.png");

    Image Fimage = Ff.getImage();
    Image FscaledImage = Fimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon F = new ImageIcon(FscaledImage);

    ImageIcon Gg = new ImageIcon("images/pumpkin.png");

    Image Gimage = Gg.getImage();
    Image GscaledImage = Gimage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon G = new ImageIcon(GscaledImage);

    ImageIcon Hh = new ImageIcon("images/strawberry.png");

    Image Himage = Hh.getImage();
    Image HscaledImage = Himage.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon H = new ImageIcon(HscaledImage);

    ImageIcon cover1 = new ImageIcon("images/cover.png");

    Image Cover = cover1.getImage();
    Image coverscaledImage = Cover.getScaledInstance(145, 125, Image.SCALE_SMOOTH);
    ImageIcon cover = new ImageIcon(coverscaledImage);

    JLabel text = new JLabel();

        for (int i = 0; i < 16; i++) {  
            cardDeck[i] = new Card(cover);
            cardDeck[i].getButton().setFocusPainted(true);
        
        cardDeck[i].getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                Card associatedCard = (Card) clickedButton.getClientProperty("card");
                if (associatedCard.getisFlipped()) {
                    //text.setText("Card is already flipped!");
                    JOptionPane.showMessageDialog(frame, "Card is already flipped!");
                } else {
                    associatedCard.changeCover(associatedCard.getImage());
                    associatedCard.isFlipped = true;
                    flippedCards.add(associatedCard);

                    if (flippedCards.size() == 2) {
                        //check for match here 
                        if (flippedCards.get(0).getFront().equals(flippedCards.get(1).getFront()) == false) {

                            JOptionPane.showMessageDialog(frame, "Not a match, try again!");
                           // text.setText("Not a match!");
                             
                            flippedCards.get(0).getButton().setIcon(cover);
                            flippedCards.get(0).isFlipped = false;
                            flippedCards.get(1).getButton().setIcon(cover); 
                            flippedCards.get(1).isFlipped = false;
                            flippedCards.clear();
                            
                        } else if (flippedCards.get(0).getFront().equals(flippedCards.get(1).getFront()) ) {
                            JOptionPane.showMessageDialog(frame, "Match!");
                            matched.add(flippedCards.get(0));
                            matched.add(flippedCards.get(1));
                            flippedCards.clear();

                            if (matched.size() == 16) {
                                JOptionPane.showMessageDialog(frame, "Congratulations! You matched all 16 cards!");
                            } 


                        }
                    }

                }
            }


        });

        cardPanel.add(cardDeck[i].getButton()); 
    }

    ArrayList<String> cardvalues = new ArrayList<>(16);
    cardvalues.add("A");
    cardvalues.add("A");
    cardvalues.add("B");
    cardvalues.add("B");
    cardvalues.add("C");
    cardvalues.add("C");
    cardvalues.add("D");
    cardvalues.add("D");
    cardvalues.add("E");
    cardvalues.add("E");
    cardvalues.add("F");
    cardvalues.add("F");
    cardvalues.add("G");
    cardvalues.add("G");
    cardvalues.add("H");
    cardvalues.add("H");

    //assigning image to Cards
    cardDeck[0].setImage(A);
    cardDeck[1].setImage(A);
    cardDeck[2].setImage(B);
    cardDeck[3].setImage(B);
    cardDeck[4].setImage(C);
    cardDeck[5].setImage(C);
    cardDeck[6].setImage(D);
    cardDeck[7].setImage(D);
    cardDeck[8].setImage(E);
    cardDeck[9].setImage(E);
    cardDeck[10].setImage(F);
    cardDeck[11].setImage(F);
    cardDeck[12].setImage(G);
    cardDeck[13].setImage(G);
    cardDeck[14].setImage(H);
    cardDeck[15].setImage(H);


    for (int j = 0; j < 16; j++) { //sets values & shows starting text as "Card" (back)
        cardDeck[j].setFront(cardvalues.get(j));
        cardDeck[j].getButton().putClientProperty("card", cardDeck[j]);
    }

        cardDeck = shuffleArray(cardDeck);   //shuffles cards
        
        for (int k = 0; k < cardDeck.length; k++) {   //Add buttons to the cardPanel
            cardPanel.add(cardDeck[k].getButton()); 
        }
        cardPanel.setBackground(Color.WHITE);
        ImageIcon titleIcon = new ImageIcon("images/Screenshot (144).png");
        JLabel title = new JLabel(titleIcon);
      
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        text.setBounds(55, 125, 150, 50);
        frame.add(text);
        frame.setLayout(new BorderLayout());
        frame.add(title, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        //GAME START!!!
        JOptionPane.showMessageDialog(frame, "Select two cards at a time to check if they are matching! Continue to make pairs until all cards have been matched. Good luck!");
       
     }

}
