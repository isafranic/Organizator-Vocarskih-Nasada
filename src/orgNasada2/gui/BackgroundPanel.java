package orgNasada2.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {

	    
			Image img;

	        public BackgroundPanel(int i) {
	            try {
	            	if(i==1) img = ImageIO.read(getClass().getResource("/01.jpg"));
	            	else img = ImageIO.read(getClass().getResource("/02.jpg"));
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            // Draws the img to the BackgroundPanel.
	            if (img != null) {
	                g.drawImage(img, 0, 0, null);
	            }
	        }

	        public Dimension getPreferredSize() {
	            return img == null ? super.getPreferredSize() : new Dimension(img.getWidth(this), img.getHeight(this));
	        }
	    }
	

