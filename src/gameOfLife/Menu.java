package gameOfLife;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

public class Menu extends JFrame {

	private static final long serialVersionUID = -3807777151118880382L;
	private JPanel contentPane;
	private Table table = new SquareTable();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JPanel mainMenu() {
		JPanel ret = new JPanel();
		ret.setBackground(Color.DARK_GRAY);
		ret.setBorder(null);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{210, 260, 210, 0};
		gbl_contentPane.rowHeights = new int[]{110, 223, 29, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		ret.setLayout(gbl_contentPane);
		
		JPanel top = new JPanel();
		top.setBackground(Color.DARK_GRAY);
		
		JLabel title = new JLabel("Conway's Game of Life");
		title.setForeground(Color.LIGHT_GRAY);
		title.setBackground(Color.DARK_GRAY);
		title.setFont(new Font("Hack", Font.BOLD, 20));
		top.add(title);
		GridBagConstraints gbc_top = new GridBagConstraints();
		gbc_top.anchor = GridBagConstraints.WEST;
		gbc_top.insets = new Insets(0, 0, 5, 5);
		gbc_top.gridx = 1;
		gbc_top.gridy = 0;
		ret.add(top, gbc_top);
		
		JPanel mid = new JPanel();
		mid.setForeground(Color.DARK_GRAY);
		mid.setBackground(Color.DARK_GRAY);
		mid.setBorder(null);
		mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));
		
		JPanel startGame = new JPanel();
		startGame.setForeground(Color.DARK_GRAY);
		startGame.setBorder(null);
		startGame.setBackground(Color.DARK_GRAY);
		mid.add(startGame);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setFocusPainted(false);
		btnStartGame.setForeground(Color.LIGHT_GRAY);
		startGame.add(btnStartGame);
		btnStartGame.setFont(new Font("Hack", Font.BOLD, 14));
		btnStartGame.setBackground(Color.DARK_GRAY);
		
		JPanel loadGame = new JPanel();
		loadGame.setBorder(null);
		loadGame.setBackground(Color.DARK_GRAY);
		mid.add(loadGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setFocusPainted(false);
		loadGame.add(btnLoadGame);
		btnLoadGame.setFont(new Font("Hack", Font.BOLD, 14));
		btnLoadGame.setForeground(Color.LIGHT_GRAY);
		btnLoadGame.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_mid = new GridBagConstraints();
		gbc_mid.insets = new Insets(4, 0, 5, 5);
		gbc_mid.gridx = 1;
		gbc_mid.gridy = 1;
		
		JPanel options = new JPanel();
		options.setBorder(null);
		options.setBackground(Color.DARK_GRAY);
		mid.add(options);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.setFocusPainted(false);
		options.add(btnOptions);
		btnOptions.setFont(new Font("Hack", Font.BOLD, 14));
		btnOptions.setForeground(Color.LIGHT_GRAY);
		btnOptions.setBackground(Color.DARK_GRAY);
		btnOptions.addActionListener(a -> {
			getContentPane().removeAll();
			getContentPane().add(optionsMenu());
			getContentPane().doLayout();
			this.revalidate();
			this.repaint();
		});
		
		ret.add(mid, gbc_mid);
		
		JPanel exit = new JPanel();
		exit.setForeground(Color.DARK_GRAY);
		exit.setBackground(Color.DARK_GRAY);
		mid.add(exit);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFocusPainted(false);
		btnExit.setForeground(Color.LIGHT_GRAY);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setFont(new Font("Hack", Font.BOLD, 14));
		btnExit.addActionListener(e -> System.exit(0));
		exit.add(btnExit);
		
		JLabel lbCredit = new JLabel("Created by Gabor Forgacs   ");
		lbCredit.setForeground(Color.LIGHT_GRAY);
		lbCredit.setBackground(Color.DARK_GRAY);
		lbCredit.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_lbCredit = new GridBagConstraints();
		gbc_lbCredit.anchor = GridBagConstraints.EAST;
		gbc_lbCredit.gridx = 2;
		gbc_lbCredit.gridy = 2;
		ret.add(lbCredit, gbc_lbCredit);
		return ret;
	}
	
	public JPanel optionsMenu() {
		ArrayList<Color> newScheme = new ArrayList<Color>(); 
		for(Color c : table.getColors()) {
			newScheme.add(new Color(c.hashCode()));
		}
		
		JPanel options = new JPanel();
		options.setBackground(Color.DARK_GRAY);
		options.setBorder(null);

		
		JLabel optionsTf = new JLabel("Options");
		optionsTf.setFont(new Font("Hack", Font.BOLD, 20));
		optionsTf.setForeground(Color.LIGHT_GRAY);
		optionsTf.setBackground(Color.DARK_GRAY);
		
		
		JButton backBtn = new JButton("Back");
		backBtn.setFont(new Font("Hack", Font.BOLD, 14));
		backBtn.setFocusPainted(false);
		backBtn.setBackground(Color.DARK_GRAY);
		backBtn.setForeground(Color.LIGHT_GRAY);
		backBtn.addActionListener(e->{
			getContentPane().removeAll();
			getContentPane().add(mainMenu());
			getContentPane().doLayout();
			revalidate();
			repaint();
		});
		
		// Color choosing buttons
		ArrayList<JButton> colorButtons = new ArrayList<JButton>();
		
		for(int i = 0; i < 10; i++) {
			colorButtons.add(new JButton(""));
			if(i < table.getColors().size()) {
				colorButtons.get(i).setEnabled(true);
				colorButtons.get(i).setBackground(table.getColors().get(i));
			}
			else {
				colorButtons.get(i).setEnabled(false);
				colorButtons.get(i).setBackground(Color.white);
			}
		}
		for(JButton button : colorButtons) {
			button.setFocusPainted(false);
			button.addActionListener(e -> {
				Color c = JColorChooser.showDialog(options, getTitle(), getForeground());
				if (c != null) {
					button.setBackground(c);
				}
			});
		}
		
		
		
		//Color scheme size
		Integer[] numbers = new Integer[11]; //currentYear is an int variable
		for(int i=0;i<11;i++){
		    numbers[i] = i+1;
		}
		JComboBox<Integer> colorsNbr = new JComboBox<Integer>(numbers);
		//JComboBox colorsNbr = new JComboBox();
		colorsNbr.setSelectedIndex(table.getColors().size()-1);
		colorsNbr.setMaximumRowCount(10);
		colorsNbr.setForeground(Color.DARK_GRAY);
		colorsNbr.setBackground(Color.LIGHT_GRAY);
		colorsNbr.addActionListener(e -> {
			int newSize = (int)colorsNbr.getSelectedItem();
			if(newScheme.size() < newSize) {
				for(int i = newScheme.size(); i < newSize; i++) {
					newScheme.add(Color.WHITE);
				}
			}
			else if(newScheme.size() > newSize) {
				for(int i = newScheme.size()-1; i >= newSize; i--) {
					newScheme.remove(i);
				}
			}
			for(int i = 0; i < 10; i++) {
				if(i < newSize) {
					colorButtons.get(i).setEnabled(true);
				}
				else {
					colorButtons.get(i).setEnabled(false);
				}
			}
		});
		
		
		//Table size
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 5, true));
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel labelX = new JLabel(Integer.toString(table.getWidth()));
		labelX.setHorizontalAlignment(SwingConstants.CENTER);
		labelX.setFont(new Font("Hack", Font.BOLD, 14));
		labelX.setForeground(Color.LIGHT_GRAY);
		
		JLabel labelY = new JLabel(Integer.toString(table.getHeight()));
		labelY.setFont(new Font("Hack", Font.BOLD, 14));
		labelY.setForeground(Color.LIGHT_GRAY);
		
		JSlider sliderX = new JSlider();
		sliderX.setValue(table.getWidth());
		sliderX.setMinimum(10);
		sliderX.addChangeListener(e -> {
			labelX.setText(Integer.toString(sliderX.getValue()));
		});
		sliderX.setMinorTickSpacing(1);
		sliderX.setForeground(Color.LIGHT_GRAY);
		sliderX.setBackground(Color.DARK_GRAY);
		sliderX.setFont(new Font("Dialog", Font.BOLD, 14));

		JSlider sliderY = new JSlider();
		sliderY.setValue(table.getHeight());
		sliderY.setMinimum(10);
		sliderY.setMinorTickSpacing(1);
		sliderY.addChangeListener(e -> {
			labelY.setText(Integer.toString(sliderY.getValue()));
		});
		sliderY.setBackground(Color.DARK_GRAY);
		
		JLabel colorSchemeLabel = new JLabel("Color scheme");
		colorSchemeLabel.setFont(new Font("Hack", Font.BOLD, 14));
		colorSchemeLabel.setForeground(Color.LIGHT_GRAY);
		colorSchemeLabel.setBackground(Color.DARK_GRAY);
		
		JLabel tableSizeLabel = new JLabel("Table size");
		tableSizeLabel.setFont(new Font("Hack", Font.BOLD, 14));
		tableSizeLabel.setBackground(Color.DARK_GRAY);
		tableSizeLabel.setForeground(Color.LIGHT_GRAY);
		
		
		//Save button 
		JButton saveBtn = new JButton("Save");
		saveBtn.setFocusPainted(false);
		saveBtn.setBackground(Color.DARK_GRAY);
		saveBtn.setForeground(Color.LIGHT_GRAY);
		saveBtn.addActionListener(e -> {
			table.setWidth(sliderX.getValue());
			table.setHeight(sliderY.getValue());
			for(int i = 0; i < newScheme.size(); i++) {
				newScheme.set(i, colorButtons.get(i).getBackground());
			}
			table.setColors(newScheme);
		});
		
		//Layout
		GroupLayout gl_contentPane = new GroupLayout(options);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(colorsNbr, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(colorSchemeLabel)
						.addComponent(tableSizeLabel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(colorButtons.get(0))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(sliderY, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
								.addComponent(sliderX, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(colorButtons.get(1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(colorButtons.get(2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(colorButtons.get(3))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(colorButtons.get(4))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(colorButtons.get(5))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(colorButtons.get(6))
									.addGap(6)
									.addComponent(colorButtons.get(7))
									.addGap(6)
									.addComponent(colorButtons.get(8))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(colorButtons.get(9)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelY, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(92, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(243)
					.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(244, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(277)
					.addComponent(optionsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(281, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(optionsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(colorSchemeLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(colorButtons.get(9), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorButtons.get(5), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorButtons.get(4), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorButtons.get(3), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorButtons.get(0), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(colorButtons.get(1), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
							.addComponent(colorButtons.get(2), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
						.addComponent(colorButtons.get(6), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorButtons.get(7), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorButtons.get(8), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorsNbr, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(tableSizeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(sliderX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(sliderY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(10))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(labelY)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		options.setLayout(gl_contentPane);
		return options;
	}
	
	public JPanel newGame() {
		
		return null;
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setTitle("Conway's Game of Life");
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 400);

		getContentPane().add(mainMenu());
		//getContentPane().add(optionsMenu());
		getContentPane().doLayout();
		update(getGraphics());
		
	}
}
