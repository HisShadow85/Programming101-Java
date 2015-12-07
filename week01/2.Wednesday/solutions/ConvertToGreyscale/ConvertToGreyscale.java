package week1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConvertToGreyscale {

	private Container content;
	private BufferedImage image;
	private int width;
	private int height;
	String imgPath;

	public ConvertToGreyscale(String imgPath) {
		loadImage(imgPath);
	}

	public void loadImage(String imgPath) {
		File f = new File(imgPath);
		// assume file is the image file
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println("Invalid image file: " + imgPath);
			System.exit(0);
		}
		this.imgPath = imgPath;
		width = image.getWidth();
		height = image.getHeight();
	}

	public static void main(String[] args) {
		/// home/hisshadow/Downloads/images.jpeg
		ConvertToGreyscale ctg = new ConvertToGreyscale("/home/hisshadow/Downloads/images.jpeg");
		ctg.convertToGreyscale();
		ctg.show();
		ctg.overwritingPicture();
	}

	void convertToGreyscale() {

		// 0.21 R + 0.72 G + 0.07 B.
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color color = new Color(image.getRGB(i, j));
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				int rGray = (int) (red * (0.21));
				int gGray = (int) (green * (0.72));
				int bGray = (int) (blue * (0.07));
				int grayScale = rGray + gGray + bGray;
				grayScale = new Color(grayScale, grayScale, grayScale).getRGB();
				image.setRGB(i, j, grayScale);
			}
		}
	}

	public void show() {
		final int width = image.getWidth();
		final int height = image.getHeight();

		JFrame frame = new JFrame("Edit Picture");

		// set frame title, set it visible, etc
		content = frame.getContentPane();
		content.setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add a menubar on the frame with a single option: saving the image
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem saveAction = new JMenuItem("Save");
		fileMenu.add(saveAction);
		JMenuItem grayScale = new JMenuItem("Grayscale");
		fileMenu.add(grayScale);
		grayScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertToGreyscale();
			}
		});

		// add the image to the frame
		ImageIcon icon = new ImageIcon(image);
		frame.setContentPane(new JLabel(icon));

		// paint the frame
		frame.setVisible(true);
		frame.repaint();
	}

	public boolean overwritingPicture() {
		return save(imgPath);
	}

	public boolean save(String path) {
		String format = getFileExtension(path);
		if (format.equals("UNKNOWN")) {
			format = "png";
		}
		File outputfile = new File("path");
		try {
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return false;
		}
		return true;
	}


	public String getFileExtension(String fileName){
		
		String extension = "UNKNOWN";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i+1);
	    
	     }
		return extension;
	}
}
