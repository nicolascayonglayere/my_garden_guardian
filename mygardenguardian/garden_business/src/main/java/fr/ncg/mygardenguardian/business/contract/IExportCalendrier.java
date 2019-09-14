package fr.ncg.mygardenguardian.business.contract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public interface IExportCalendrier {

	public Path exportCalendrier(String uuidUtilisateur) throws FileNotFoundException, IOException;

}
