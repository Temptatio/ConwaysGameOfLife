package de.gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GameOfLifeMaske extends JFrame {

	private JPanel contentPane;
	private BufferedImage gameOfLifeAlsBild;
	private JSpinner jSpinnerLebensdauer;
	private JPanel jPanelEinstellungen;
	private JLabel lblDimensionxrichtung;
	private JLabel lblDimensionyrichtung;
	private JLabel lblLebensdauerms;
	private JLabel lblAnfangsverteilung;
	private JFormattedTextField jFormattedTextFieldyDimension;
	private JFormattedTextField jFormattedTextFieldxDimension;
	private JComboBox jComboBoxAnfangsverteilung;
	private JButton jButtonStart;
	private JLabel lblBesetzungsdichte;
	private JFormattedTextField jFormattedTextFieldInitialeBesetzungsdichte;
	private JCheckBox jCheckBoxIsPeriodischeRandbedingung;
	private JCheckBox jCheckBoxEndlosschleife;
	private JLabel lblGenerationen;
	private JFormattedTextField jFormattedTextFieldGenerationen;
	
	GameOfLifeController gameOfLifeController;
	
	/**
	 * Create the frame.
	 */
	public GameOfLifeMaske(GameOfLifeController gameOfLifeController) {
		
		this.gameOfLifeController = gameOfLifeController;
		
		setTitle("Conway's Game of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 4};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 4};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel jPanelGitter = new JPanel();
		jPanelGitter.setBackground(Color.WHITE);
		jPanelGitter.setBorder(null);
		GridBagConstraints gbc_jPanelGitter = new GridBagConstraints();
		gbc_jPanelGitter.insets = new Insets(5, 5, 0, 5);
		gbc_jPanelGitter.ipady = 10;
		gbc_jPanelGitter.ipadx = 10;
		gbc_jPanelGitter.gridheight = 3;
		gbc_jPanelGitter.fill = GridBagConstraints.BOTH;
		gbc_jPanelGitter.gridx = 0;
		gbc_jPanelGitter.gridy = 0;
		contentPane.add(jPanelGitter, gbc_jPanelGitter);
		
		jPanelEinstellungen = new JPanel();
		GridBagConstraints gbc_jPanelEinstellungen = new GridBagConstraints();
		gbc_jPanelEinstellungen.anchor = GridBagConstraints.NORTHWEST;
		gbc_jPanelEinstellungen.insets = new Insets(0, 0, 5, 0);
		gbc_jPanelEinstellungen.gridx = 1;
		gbc_jPanelEinstellungen.gridy = 0;
		contentPane.add(jPanelEinstellungen, gbc_jPanelEinstellungen);
		GridBagLayout gbl_jPanelEinstellungen = new GridBagLayout();
		gbl_jPanelEinstellungen.columnWidths = new int[]{0, 0, 0};
		gbl_jPanelEinstellungen.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jPanelEinstellungen.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jPanelEinstellungen.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jPanelEinstellungen.setLayout(gbl_jPanelEinstellungen);
		
		lblDimensionxrichtung = new JLabel("Dimension (x-Richtung)");
		GridBagConstraints gbc_lblDimensionxrichtung = new GridBagConstraints();
		gbc_lblDimensionxrichtung.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensionxrichtung.anchor = GridBagConstraints.EAST;
		gbc_lblDimensionxrichtung.gridx = 0;
		gbc_lblDimensionxrichtung.gridy = 0;
		jPanelEinstellungen.add(lblDimensionxrichtung, gbc_lblDimensionxrichtung);
		
		jFormattedTextFieldxDimension = new JFormattedTextField();
		jFormattedTextFieldxDimension.setHorizontalAlignment(SwingConstants.RIGHT);
		jFormattedTextFieldxDimension.setText("400");
		GridBagConstraints gbc_jFormattedTextFieldxDimension = new GridBagConstraints();
		gbc_jFormattedTextFieldxDimension.insets = new Insets(0, 0, 5, 0);
		gbc_jFormattedTextFieldxDimension.fill = GridBagConstraints.HORIZONTAL;
		gbc_jFormattedTextFieldxDimension.gridx = 1;
		gbc_jFormattedTextFieldxDimension.gridy = 0;
		jPanelEinstellungen.add(jFormattedTextFieldxDimension, gbc_jFormattedTextFieldxDimension);
		
		lblDimensionyrichtung = new JLabel("Dimension (y-Richtung)");
		GridBagConstraints gbc_lblDimensionyrichtung = new GridBagConstraints();
		gbc_lblDimensionyrichtung.anchor = GridBagConstraints.EAST;
		gbc_lblDimensionyrichtung.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensionyrichtung.gridx = 0;
		gbc_lblDimensionyrichtung.gridy = 1;
		jPanelEinstellungen.add(lblDimensionyrichtung, gbc_lblDimensionyrichtung);
		
		jFormattedTextFieldyDimension = new JFormattedTextField();
		jFormattedTextFieldyDimension.setHorizontalAlignment(SwingConstants.RIGHT);
		jFormattedTextFieldyDimension.setText("400");
		GridBagConstraints gbc_jFormattedTextFieldyDimension = new GridBagConstraints();
		gbc_jFormattedTextFieldyDimension.insets = new Insets(0, 0, 5, 0);
		gbc_jFormattedTextFieldyDimension.fill = GridBagConstraints.HORIZONTAL;
		gbc_jFormattedTextFieldyDimension.gridx = 1;
		gbc_jFormattedTextFieldyDimension.gridy = 1;
		jPanelEinstellungen.add(jFormattedTextFieldyDimension, gbc_jFormattedTextFieldyDimension);
		
		lblLebensdauerms = new JLabel("Lebensdauer (ms)");
		GridBagConstraints gbc_lblLebensdauerms = new GridBagConstraints();
		gbc_lblLebensdauerms.anchor = GridBagConstraints.WEST;
		gbc_lblLebensdauerms.insets = new Insets(0, 0, 5, 5);
		gbc_lblLebensdauerms.gridx = 0;
		gbc_lblLebensdauerms.gridy = 2;
		jPanelEinstellungen.add(lblLebensdauerms, gbc_lblLebensdauerms);
		
		jSpinnerLebensdauer = new JSpinner();
		GridBagConstraints gbc_jSpinnerLebensdauer = new GridBagConstraints();
		gbc_jSpinnerLebensdauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_jSpinnerLebensdauer.insets = new Insets(0, 0, 5, 0);
		gbc_jSpinnerLebensdauer.gridx = 1;
		gbc_jSpinnerLebensdauer.gridy = 2;
		jPanelEinstellungen.add(jSpinnerLebensdauer, gbc_jSpinnerLebensdauer);
		jSpinnerLebensdauer.setModel(new SpinnerNumberModel(500, 50, 5000, 50));
		
		lblBesetzungsdichte = new JLabel("Besetzungsdichte");
		GridBagConstraints gbc_lblBesetzungsdichte = new GridBagConstraints();
		gbc_lblBesetzungsdichte.anchor = GridBagConstraints.WEST;
		gbc_lblBesetzungsdichte.insets = new Insets(0, 0, 5, 5);
		gbc_lblBesetzungsdichte.gridx = 0;
		gbc_lblBesetzungsdichte.gridy = 3;
		jPanelEinstellungen.add(lblBesetzungsdichte, gbc_lblBesetzungsdichte);
		
		jFormattedTextFieldInitialeBesetzungsdichte = new JFormattedTextField();
		jFormattedTextFieldInitialeBesetzungsdichte.setHorizontalAlignment(SwingConstants.RIGHT);
		jFormattedTextFieldInitialeBesetzungsdichte.setText("50");
		GridBagConstraints gbc_jFormattedTextFieldInitialeBesetzungsdichte = new GridBagConstraints();
		gbc_jFormattedTextFieldInitialeBesetzungsdichte.fill = GridBagConstraints.HORIZONTAL;
		gbc_jFormattedTextFieldInitialeBesetzungsdichte.insets = new Insets(0, 0, 5, 0);
		gbc_jFormattedTextFieldInitialeBesetzungsdichte.gridx = 1;
		gbc_jFormattedTextFieldInitialeBesetzungsdichte.gridy = 3;
		jPanelEinstellungen.add(jFormattedTextFieldInitialeBesetzungsdichte, gbc_jFormattedTextFieldInitialeBesetzungsdichte);
		
		lblAnfangsverteilung = new JLabel("Anfangsverteilung");
		GridBagConstraints gbc_lblAnfangsverteilung = new GridBagConstraints();
		gbc_lblAnfangsverteilung.anchor = GridBagConstraints.WEST;
		gbc_lblAnfangsverteilung.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnfangsverteilung.gridx = 0;
		gbc_lblAnfangsverteilung.gridy = 4;
		jPanelEinstellungen.add(lblAnfangsverteilung, gbc_lblAnfangsverteilung);
		
		jComboBoxAnfangsverteilung = new JComboBox();
		jComboBoxAnfangsverteilung.setModel(new DefaultComboBoxModel(new String[] {"Gleichverteilt", "Normalverteilt"}));
		GridBagConstraints gbc_jComboBoxAnfangsverteilung = new GridBagConstraints();
		gbc_jComboBoxAnfangsverteilung.insets = new Insets(0, 0, 5, 0);
		gbc_jComboBoxAnfangsverteilung.anchor = GridBagConstraints.EAST;
		gbc_jComboBoxAnfangsverteilung.gridx = 1;
		gbc_jComboBoxAnfangsverteilung.gridy = 4;
		jPanelEinstellungen.add(jComboBoxAnfangsverteilung, gbc_jComboBoxAnfangsverteilung);
		
		jCheckBoxEndlosschleife = new JCheckBox("Entwicklung bis zum Tod");
		GridBagConstraints gbc_jCheckBoxEndlosschleife = new GridBagConstraints();
		gbc_jCheckBoxEndlosschleife.anchor = GridBagConstraints.EAST;
		gbc_jCheckBoxEndlosschleife.gridwidth = 2;
		gbc_jCheckBoxEndlosschleife.insets = new Insets(0, 0, 5, 0);
		gbc_jCheckBoxEndlosschleife.gridx = 0;
		gbc_jCheckBoxEndlosschleife.gridy = 5;
		jPanelEinstellungen.add(jCheckBoxEndlosschleife, gbc_jCheckBoxEndlosschleife);
		
		lblGenerationen = new JLabel("Generationen");
		lblGenerationen.setEnabled(false);
		GridBagConstraints gbc_lblGenerationen = new GridBagConstraints();
		gbc_lblGenerationen.anchor = GridBagConstraints.EAST;
		gbc_lblGenerationen.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenerationen.gridx = 0;
		gbc_lblGenerationen.gridy = 6;
		jPanelEinstellungen.add(lblGenerationen, gbc_lblGenerationen);
		
		jFormattedTextFieldGenerationen = new JFormattedTextField();
		jFormattedTextFieldGenerationen.setHorizontalAlignment(SwingConstants.RIGHT);
		jFormattedTextFieldGenerationen.setEnabled(false);
		jFormattedTextFieldGenerationen.setText("1000");
		GridBagConstraints gbc_jFormattedTextFieldGenerationen = new GridBagConstraints();
		gbc_jFormattedTextFieldGenerationen.insets = new Insets(0, 0, 5, 0);
		gbc_jFormattedTextFieldGenerationen.fill = GridBagConstraints.HORIZONTAL;
		gbc_jFormattedTextFieldGenerationen.gridx = 1;
		gbc_jFormattedTextFieldGenerationen.gridy = 6;
		jPanelEinstellungen.add(jFormattedTextFieldGenerationen, gbc_jFormattedTextFieldGenerationen);
		
		jCheckBoxIsPeriodischeRandbedingung = new JCheckBox("Periodische Randbedingungen");
		GridBagConstraints gbc_jCheckBoxIsPeriodischeRandbedingung = new GridBagConstraints();
		gbc_jCheckBoxIsPeriodischeRandbedingung.anchor = GridBagConstraints.EAST;
		gbc_jCheckBoxIsPeriodischeRandbedingung.gridwidth = 2;
		gbc_jCheckBoxIsPeriodischeRandbedingung.insets = new Insets(0, 0, 5, 0);
		gbc_jCheckBoxIsPeriodischeRandbedingung.gridx = 0;
		gbc_jCheckBoxIsPeriodischeRandbedingung.gridy = 7;
		jPanelEinstellungen.add(jCheckBoxIsPeriodischeRandbedingung, gbc_jCheckBoxIsPeriodischeRandbedingung);
		
		jButtonStart = new JButton("Start");
		jButtonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GameOfLifeDatenmodell gameOfLifeDatenmodell = new GameOfLifeDatenmodell();
				
				gameOfLifeDatenmodell.setxDimension(Integer.parseInt(jFormattedTextFieldxDimension.getText()));
				gameOfLifeDatenmodell.setyDimension(Integer.parseInt(jFormattedTextFieldyDimension.getText()));
				gameOfLifeDatenmodell.setInitialeBesetzungsdichte(Integer.parseInt(jFormattedTextFieldInitialeBesetzungsdichte.getText()));
				gameOfLifeDatenmodell.setInitialeVerteilung((Verteilungstyp)(jComboBoxAnfangsverteilung.getSelectedItem()));
				gameOfLifeDatenmodell.setLebensdauer(Integer.parseInt((String)(jSpinnerLebensdauer.getValue())));
				gameOfLifeDatenmodell.setGenerationen(Integer.parseInt(jFormattedTextFieldGenerationen.getText()));
				
				GameOfLifeMaske.this.getGameOfLifeController().intialisiereGameOfLife(gameOfLifeDatenmodell);
			}
		});
		GridBagConstraints gbc_jButtonStart = new GridBagConstraints();
		gbc_jButtonStart.gridwidth = 2;
		gbc_jButtonStart.gridx = 0;
		gbc_jButtonStart.gridy = 8;
		jPanelEinstellungen.add(jButtonStart, gbc_jButtonStart);
	}
	
	private GameOfLifeController getGameOfLifeController() {
		return this.gameOfLifeController;
	}
	
	public void setGameOfLifeAlsBild(BufferedImage gameOfLifeAlsBild) {
		this.gameOfLifeAlsBild = gameOfLifeAlsBild;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(this.gameOfLifeAlsBild, 0, 0, this);
	}
}
