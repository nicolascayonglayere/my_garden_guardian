package fr.ncg.mygardenguardian.business.contract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import fr.ncg.mygardenguardian.entites.Utilisateur;

/**
 * Interface IExportCalendrier qui gère l'export du calendrier dans un fichier
 * ical
 * 
 * @author nicolas
 *
 */
public interface IExportCalendrier {

	/**
	 * Methode pour creer in fichier ical du calendrier de {@link Utilisateur}
	 * 
	 * @param uuidUtilisateur
	 * @return Path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Path exportCalendrier(String uuidUtilisateur) throws FileNotFoundException, IOException;

}
