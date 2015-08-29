package de.gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JComboBox comboBox;
	private JButton btnStart;
	private JLabel lblBesetzungsdichte;
	private JFormattedTextField formattedTextField_2;
	private JCheckBox chckbxPeriodischeRandbedingungen;
	private JCheckBox chckbxEntwicklungenBisZum;
	private JLabel lblGenerationen;
	private JFormattedTextField formattedTextField_3;

	/**
	 * Create the frame.
	 */
	public GameOfLifeMaske() {
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
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField_1.setText("400");
		GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
		gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_1.gridx = 1;
		gbc_formattedTextField_1.gridy = 0;
		jPanelEinstellungen.add(formattedTextField_1, gbc_formattedTextField_1);
		
		lblDimensionyrichtung = new JLabel("Dimension (y-Richtung)");
		GridBagConstraints gbc_lblDimensionyrichtung = new GridBagConstraints();
		gbc_lblDimensionyrichtung.anchor = GridBagConstraints.EAST;
		gbc_lblDimensionyrichtung.insets = new Insets(0, 0, 5, 5);
		gbc_lblDimensionyrichtung.gridx = 0;
		gbc_lblDimensionyrichtung.gridy = 1;
		jPanelEinstellungen.add(lblDimensionyrichtung, gbc_lblDimensionyrichtung);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField.setText("400");
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 1;
		gbc_formattedTextField.gridy = 1;
		jPanelEinstellungen.add(formattedTextField, gbc_formattedTextField);
		
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
		
		formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField_2.setText("50");
		GridBagConstraints gbc_formattedTextField_2 = new GridBagConstraints();
		gbc_formattedTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextField_2.gridx = 1;
		gbc_formattedTextField_2.gridy = 3;
		jPanelEinstellungen.add(formattedTextField_2, gbc_formattedTextField_2);
		
		lblAnfangsverteilung = new JLabel("Anfangsverteilung");
		GridBagConstraints gbc_lblAnfangsverteilung = new GridBagConstraints();
		gbc_lblAnfangsverteilung.anchor = GridBagConstraints.WEST;
		gbc_lblAnfangsverteilung.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnfangsverteilung.gridx = 0;
		gbc_lblAnfangsverteilung.gridy = 4;
		jPanelEinstellungen.add(lblAnfangsverteilung, gbc_lblAnfangsverteilung);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gleichverteilt", "Normalverteilt"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.anchor = GridBagConstraints.EAST;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		jPanelEinstellungen.add(comboBox, gbc_comboBox);
		
		chckbxEntwicklungenBisZum = new JCheckBox("Entwicklung bis zum Tod");
		GridBagConstraints gbc_chckbxEntwicklungenBisZum = new GridBagConstraints();
		gbc_chckbxEntwicklungenBisZum.anchor = GridBagConstraints.EAST;
		gbc_chckbxEntwicklungenBisZum.gridwidth = 2;
		gbc_chckbxEntwicklungenBisZum.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxEntwicklungenBisZum.gridx = 0;
		gbc_chckbxEntwicklungenBisZum.gridy = 5;
		jPanelEinstellungen.add(chckbxEntwicklungenBisZum, gbc_chckbxEntwicklungenBisZum);
		
		lblGenerationen = new JLabel("Generationen");
		lblGenerationen.setEnabled(false);
		GridBagConstraints gbc_lblGenerationen = new GridBagConstraints();
		gbc_lblGenerationen.anchor = GridBagConstraints.EAST;
		gbc_lblGenerationen.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenerationen.gridx = 0;
		gbc_lblGenerationen.gridy = 6;
		jPanelEinstellungen.add(lblGenerationen, gbc_lblGenerationen);
		
		formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField_3.setEnabled(false);
		formattedTextField_3.setText("1000");
		GridBagConstraints gbc_formattedTextField_3 = new GridBagConstraints();
		gbc_formattedTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_3.gridx = 1;
		gbc_formattedTextField_3.gridy = 6;
		jPanelEinstellungen.add(formattedTextField_3, gbc_formattedTextField_3);
		
		chckbxPeriodischeRandbedingungen = new JCheckBox("Periodische Randbedingungen");
		GridBagConstraints gbc_chckbxPeriodischeRandbedingungen = new GridBagConstraints();
		gbc_chckbxPeriodischeRandbedingungen.anchor = GridBagConstraints.EAST;
		gbc_chckbxPeriodischeRandbedingungen.gridwidth = 2;
		gbc_chckbxPeriodischeRandbedingungen.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPeriodischeRandbedingungen.gridx = 0;
		gbc_chckbxPeriodischeRandbedingungen.gridy = 7;
		jPanelEinstellungen.add(chckbxPeriodischeRandbedingungen, gbc_chckbxPeriodischeRandbedingungen);
		
		btnStart = new JButton("Start");
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.gridwidth = 2;
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 8;
		jPanelEinstellungen.add(btnStart, gbc_btnStart);
	}
	
	public void setGameOfLifeAlsBild(BufferedImage gameOfLifeAlsBild) {
		this.gameOfLifeAlsBild = gameOfLifeAlsBild;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(this.gameOfLifeAlsBild, 0, 0, this);
	}
}
