package fr.ncg.mygardenguardian.webapp.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.ncg.mygardenguardian.business.IBusinessManagerFactory;

@RestController
public class Autocompletion {

	private IBusinessManagerFactory managerFactory;

	@GetMapping("/culture/autocompletion")
	public ResponseEntity<String> doAutoComplete(@RequestParam("q") final String input) {
		List<String> strings = this.managerFactory.getIntrantManager().obtenirNomsIntrants().stream()
				.filter(s -> s.toLowerCase().startsWith(input.toLowerCase())).collect(Collectors.toList());// autoCompleteService.doAutoComplete(input);
		ObjectMapper mapper = new ObjectMapper();
		String resp = "";
		try {
			resp = mapper.writeValueAsString(strings);
		} catch (JsonProcessingException e) {
		}
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	public IBusinessManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	@Autowired
	public void setManagerFactory(IBusinessManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
