import javax.swing.*;
import java.awt.*;

public class Card {

    public JButton button;
    public String front; //assigned letter value
    public ImageIcon back;  //cover
    public ImageIcon image;
    public boolean isFlipped;

    public Card(ImageIcon back) {
        this.front = null;
        this.back = new ImageIcon("images/cover.png");
        this.image = new ImageIcon();
        this.button = new JButton(back); 
        button.setBackground(Color.WHITE);
        this.isFlipped = false;
    }
    
    public Card(String front, ImageIcon back) {
        this.front = front;
        this.back = new ImageIcon("images/cover.png");
        this.image = new ImageIcon();
        this.button = new JButton(back);  //always start with showing back
        button.setBackground(Color.WHITE);
        this.isFlipped = false;
    }

    public JButton getButton() {
        return button;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
      //  this.button.setIcon(image);
    }

    public void changeCover(ImageIcon image) {
        this.button.setIcon(image);
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getFront() {
        return front;
    }

    public boolean checkCardmatch(Card cardOne, Card cardTwo) {
        if (cardOne.getFront().equals(cardTwo.getFront())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getisFlipped() {
        if (isFlipped == true) {
            return true;
        } else {
            return false;
        }
    }

   
}
