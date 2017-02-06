package com.baki.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Dell
 *
 */
public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel cell[][] = new JPanel[6][6];
	private JPanel contentScore = new JPanel();

	public Fenetre() {
		// Cr�ation de la fen�tre
		this.setTitle("Exercice JAVA"); // titre de la fen�tre
		this.setSize(500, 500); // taille de la fen�tre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLocationRelativeTo(null); // fen�tre positionn�e au centre de  l'�cran
		this.setResizable(false);// fixe la fenetre

		// content layout
		JPanel content = new JPanel();
		this.setContentPane(content); // On pr�vient notre JFrame que notre JPanel sera son content pane
		content.setLayout(new BorderLayout());// On d�finit le layout � utiliser sur le content pane

		contentGrille(content);
		// Deplacement depl = new Deplacement();

		this.setVisible(true); // fen�tre visible

	}

	private  JPanel[][] contentGrille(JPanel content) {
		// JPanel affichage Grille
		JPanel contentGrille = new JPanel();

		// On d�finit le layout � utiliser pour la grille
		contentGrille.setLayout(new GridLayout(6, 6));// 6 lignes, 6 colonnes

		// Cr�ation de la grille
		JPanel cell[][] = creationGrille(contentGrille);

		content.add(contentGrille, BorderLayout.CENTER);
		return cell;
	}

	

	private  JPanel[][] creationGrille(JPanel contentGrille) {
		for (int i = 0; i < getCell().length; i++) {
			for (int j = 0; j < getCell().length; j++) {
				getCell()[i][j] = new JPanel();
				getCell()[i][j].setSize(new Dimension(50, 50));
				if ((i + j) % 2 == 0) {
					getCell()[i][j].setBackground(Color.gray);
				} else {
					getCell()[i][j].setBackground(Color.white);
				}
				contentGrille.add(getCell()[i][j]);
			}
		}
		return cell;
	}

	/**
	 * @return the cell
	 */
	public JPanel[][] getCell() {
		return cell;
	}

	/**
	 * @param cell the cell to set
	 */
	public void setCell(JPanel[][] cell) {
		this.cell = cell;
	}

	/**
	 * @return the contentScore
	 */
	public JPanel getContentScore() {
		return contentScore;
	}

	/**
	 * @param contentScore the contentScore to set
	 */
	public void setContentScore(JPanel contentScore) {
		this.contentScore = contentScore;
	}
	
	
}
