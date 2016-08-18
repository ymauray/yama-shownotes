package ch.yama.shownotes.ui;

import ch.yama.shownotes.ui.bindings.AbstractModel;

public class MainPanelModel extends AbstractModel {

	private String m_nom;

	public String getNom() {
		return m_nom;
	}

	public void setNom(String nom) {
		firePropertyChange("nom", this.m_nom, this.m_nom = nom);
	}

}
