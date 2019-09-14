package fr.ncg.mygardenguardian.webapp.controller.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.activation.MimetypesFileTypeMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;
import fr.ncg.mygardenguardian.webapp.utils.SymetricCrypto;

@RestController
public class ExportCalendrierRestController {

	private IBusinessManagerFactory managerFactory;

	private SymetricCrypto decryptor = new SymetricCrypto();

	@GetMapping("/API/ical")
	public ResponseEntity<Resource> exportCalendrier(HttpServletRequest req)
			throws FileNotFoundException, IOException, InvalidKeyException, NoSuchPaddingException,
			NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
//		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//		GardenGuardianAppUser monUser = (GardenGuardianAppUser) loggedInUser.getPrincipal();
//		Integer idUtilisateur = monUser.getIdUtilisateur();
		System.out.println("CTRL export REST ----------" + req.getParameter("idJardinier"));

		String uuid = new String(
				this.decryptor.decryptMessage(Base64.getDecoder().decode(req.getParameter("idJardinier").replaceAll(" ", "+"))));

//		String uuid = new String(
//				Base64.getDecoder().decode(this.decryptor.decryptMessage(req.getParameter("idJardinier").getBytes())),
//				"UTF-8");

		Path chemFichier = this.managerFactory.getExportCalendrier().exportCalendrier(uuid);
		System.out.println("CTRL export REST ----------" + chemFichier.toString());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(chemFichier));
		MimetypesFileTypeMap m = new MimetypesFileTypeMap(chemFichier.toString());
		System.out.println("CTRL export REST ---------- " + m.getContentType(chemFichier.toFile()));

		MediaType mediaType = MediaType.parseMediaType(m.getContentType(chemFichier.toFile()));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + chemFichier.getFileName())
				.contentLength(resource.contentLength()).contentType(mediaType).body(resource);

	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
}
