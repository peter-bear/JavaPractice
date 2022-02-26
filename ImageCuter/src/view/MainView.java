package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Label;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.JSlider;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.UIManager;



public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSlider slider;
	private JPanel inputPanel;
	private JPanel outputPanel;
	private JSlider outputSlider;
	
	
	private BufferedImage inputImg = null;
	private BufferedImage outputImg = null;
	private final static int ELLIPSE = 0;
	private final static int RECTANGLE = 1;
	
	private int startX, startY,endX, endY;
	
	private int cutModule = ELLIPSE;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		//initialization for the window
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1858, 956);
		
		//add a main content panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//a label "File Address"
		Label inputAddressLabel = new Label("File Address");
		inputAddressLabel.setAlignment(Label.CENTER);
		inputAddressLabel.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 20));
		inputAddressLabel.setBounds(106, 794, 152, 44);
		contentPane.add(inputAddressLabel);
		
		//create an image selector
		JFileChooser jfc = new JFileChooser("E:/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
		jfc.setFileFilter(filter);
		
		//an area to show the input image address
		JTextPane inputAddress = new JTextPane();
		inputAddress.setBounds(289, 794, 304, 36);
		contentPane.add(inputAddress);
		
		
		//input panel that shows input image
		inputPanel = new JPanel();
		inputPanel.setBounds(30, 26, 873, 618);
		inputPanel.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				startX = e.getX();
				startY = e.getY();
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				endX = e.getX();
				endY = e.getY();
				if(inputImg != null) {
					drawImage(slider.getValue()/100.0, inputImg, inputPanel);
					drawShap(inputPanel);
				}
				
			}
			
			
			
			
		});
		
		contentPane.add(inputPanel);
		
		//output panel that shows output image
		outputPanel = new JPanel();
		outputPanel.setBounds(938, 26, 889, 618);
		contentPane.add(outputPanel);
		
		
		//a slider that can change picture's size if you move it
		slider = new JSlider();
		slider.addMouseListener(new MouseAdapter() {
			//draw the image
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(inputImg!=null) {
					drawImage(slider.getValue()/100.0, inputImg, inputPanel);
				}
			}
		});
	
		slider.setValue(100);
		slider.setBounds(348, 866, 200, 26);
		slider.setMinimum(1);
		contentPane.add(slider);
		
		
		outputSlider = new JSlider();
		outputSlider.addMouseListener(new MouseAdapter() {
			//draw the image
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(outputImg!=null) {
					drawImage(outputSlider.getValue()/100.0, outputImg, outputPanel);
				}
			}
		});
		outputSlider.setValue(100);
		outputSlider.setBounds(1279, 784, 200, 26);
		outputSlider.setMinimum(1);
		contentPane.add(outputSlider);
		
		
		//add an button to choose the input image
		JButton inputBtn = new JButton("Input");
		inputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnValue = jfc.showOpenDialog(contentPane);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					loadImage(inputAddress, jfc);
					drawImage(slider.getValue()/100.0, inputImg, inputPanel);
					
				}
			}
		});
		inputBtn.setBounds(679, 794, 110, 34);
		contentPane.add(inputBtn);
		
		//label to show "output address"
		JLabel outputAddressLabel = new JLabel("outputAddress");
		outputAddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputAddressLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		outputAddressLabel.setBounds(954, 710, 188, 44);
		contentPane.add(outputAddressLabel);
		
		
		JTextPane outputAddress = new JTextPane();
		outputAddress.setBounds(1168, 710, 387, 44);
		contentPane.add(outputAddress);
		
		
		
		//a button to allow user to output the image
		JButton outputBtn = new JButton("Output");
		outputBtn.setFont(new Font("宋体", Font.PLAIN, 20));
		outputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int choice = jfc.showSaveDialog(contentPane);
				if(outputImg!=null && choice == JFileChooser.APPROVE_OPTION) {
					outputFile(outputAddress, jfc);
					
				}
			}
		});
		outputBtn.setBounds(1593, 718, 110, 30);
		contentPane.add(outputBtn);
		
		//the user need to choose a moudle to cut the image
		JLabel moduleChoice = new JLabel("Choose Module");
		moduleChoice.setHorizontalAlignment(SwingConstants.CENTER);
		moduleChoice.setFont(new Font("宋体", Font.PLAIN, 20));
		moduleChoice.setBounds(82, 701, 188, 64);
		contentPane.add(moduleChoice);
		
		//the moudle button for elipse
		JButton ellipseBtn = new JButton("Ellipse");
		ellipseBtn.setFont(new Font("宋体", Font.PLAIN, 20));
		ellipseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cutModule = MainView.ELLIPSE;
			}
		});

		ellipseBtn.setBounds(301, 699, 116, 68);
		contentPane.add(ellipseBtn);
		
		//the module button for rectangle
		JButton rectBtn = new JButton("Rectangle");
		rectBtn.setFont(new Font("宋体", Font.PLAIN, 20));
		rectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cutModule = MainView.RECTANGLE;
			}
		});

		rectBtn.setBounds(459, 699, 134, 68);
		contentPane.add(rectBtn);
		
		JButton cutBtn = new JButton("Cut");
		cutBtn.setBackground(UIManager.getColor("Button.background"));
		cutBtn.setFont(new Font("宋体", Font.PLAIN, 20));

		cutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(inputImg != null) {
					cutImage(inputImg, 100*startX/slider.getValue(), 100*startY/slider.getValue(), 100*(endX-startX)/slider.getValue(),  100*(endY-startY)/slider.getValue());
					slider.setValue(100);
					drawImage(1,outputImg, outputPanel);
				}
				
				
			}
		});
		cutBtn.setBounds(679, 711, 110, 45);
		contentPane.add(cutBtn);
		
	
	
		
		

		
		
		
	}
	
	//output image and save it to my computer
	protected void outputFile(JTextPane textPane, JFileChooser jfc) {
		// TODO Auto-generated method stub

		//check the accessibility of file address
		String outputAddressString = jfc.getSelectedFile().getAbsolutePath();
		if(outputAddressString.length() <4) {			
			outputAddressString += ".png";
	
		}else if(!outputAddressString.substring(outputAddressString.length()-4).equals(".png") ||  !outputAddressString.substring(outputAddressString.length()-4).equals(".jpg")) {
			JOptionPane.showConfirmDialog(null, "Please End The File With PNG or JPG");
			outputAddressString =  outputAddressString.subSequence(0, outputAddressString.length()-4) + ".png";
		}
		
		
		textPane.setText(outputAddressString);
		
		//create the file and save it
		File outputFile = new File(outputAddressString);
		try {
			if(outputFile.createNewFile()) {
				ImageIO.write(outputImg, "PNG", outputFile);
			}else {
				new JOptionPane();
				int choice = JOptionPane.showConfirmDialog(null, "This File Already Exist! Do you want to continue?");
				if(choice == JOptionPane.YES_OPTION)
					ImageIO.write(outputImg, "PNG", outputFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		textPane.setEnabled(false);
		
	}

	//load image from an address and put the address on th textpane
	protected void loadImage(JTextPane textPane, JFileChooser jfc) {
		
		//load file address string to textpane
		textPane.setText(jfc.getSelectedFile().getAbsolutePath());
		textPane.setEnabled(false);
		try {
			
			inputImg = ImageIO.read(new File(textPane.getText()));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//draw the shape
	protected void drawShap(JPanel panel) {
		if(cutModule == MainView.ELLIPSE)
			panel.getGraphics().drawArc(startX, startY, endX-startX, endY-startY, 0, 360);
		else if(cutModule == MainView.RECTANGLE) 
			panel.getGraphics().drawRect(startX, startY, endX-startX, endY-startY);
		
	}
	
	//draw image on specific panel with some sacle
	protected void drawImage(double scale, BufferedImage img, JPanel panel) {
		
		
		int picWidth = (int)(img.getWidth()*scale);
		int picHeight = (int)(img.getHeight()*scale);
		Image resizedImage = getSizeChangedPic(img, picHeight, picWidth);
		
		
		panel.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
		panel.getGraphics().drawImage(resizedImage, 0, 0, picWidth, picHeight, this);
	
		
	}
	
	//cut image with specific module
	protected void cutImage(BufferedImage img, int x, int y, int width, int height) {
		outputImg = img.getSubimage(x, y, width, height);
		//create a new bufferImg to save the graphics
		BufferedImage tmp = new BufferedImage(outputImg.getWidth(), outputImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d =  tmp.createGraphics() ;
		
		//smooth the cut operation
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        g2d.setRenderingHints(qualityHints);
		
		if(cutModule == MainView.ELLIPSE) {	   
	        //cut with an ellipse
	        g2d.setClip(new Ellipse2D.Double(0, 0, outputImg.getWidth(), outputImg.getHeight()));
	        
		}else if(cutModule == MainView.RECTANGLE){
			//cut with round rectangle
	        g2d.setClip(new RoundRectangle2D.Double(0, 0, outputImg.getWidth(), outputImg.getHeight(), outputImg.getWidth() / 4, outputImg.getHeight()	 / 4));
	        
		}
		
		//put the image into the ellipse
		g2d.drawImage(outputImg, 0, 0, null);
		
		//close the graphics
		g2d.dispose();
		
		//copy changed picture to original one
		outputImg = tmp;
		

	}
	
	//resize image
	protected Image getSizeChangedPic(Image img, int height, int width) {
		return img.getScaledInstance(height, width, Image.SCALE_SMOOTH);
	}
}
