package hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonListener btnListener = new ButtonListener();
		JButton btnAddToCart = new JButton("Add to cart");
		container.add(btnAddToCart);
		btnAddToCart.addActionListener(btnListener);
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			container.add(btnPlay);
			btnPlay.addActionListener(btnListener);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			String btn = evt.getActionCommand();
			if (btn.equals("Play")) {
				JFrame f = new JFrame();
				JDialog d = new JDialog(f, "Playing media", true);
				
				d.add(new JLabel("Now playing: " + media.getTitle()));
				d.setSize(300, 150);
				d.setVisible(true);
			}
			else if(btn.equals("Add to cart")) {
				cart.addMedia(media);
			}
		}
	}
}
