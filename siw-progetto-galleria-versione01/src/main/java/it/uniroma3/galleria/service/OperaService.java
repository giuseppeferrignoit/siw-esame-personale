package it.uniroma3.galleria.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;
	
	@Autowired
	private ArtistaService artistaService;
	
	@Transactional
	public void save(Opera opera, Artista artista) { 
		// Il save è di tipo transactional
		opera.setArtista(artista);
		artista.addOpera(opera);
		operaRepository.save(opera);
	}
	
	@Transactional
	public void delete(Opera opera) { 
		// Il save è di tipo transactional
		operaRepository.delete(opera);
	}
	
	@Transactional
	public void deleteById(Long id) {
		operaRepository.deleteById(id);
		
	}
	
	public Opera findById (Long id) {
		return operaRepository.findById(id).get();
	}
	
	public List<Opera> findAll() {
		List<Opera> opere = new ArrayList<Opera>();
		for (Opera o : operaRepository.findAll()) {
			opere.add(o);
		}
		return opere;
	}
	
	// Metodo che risponde ad una validazione del Validator
	public boolean alreadyExists(Opera opera) {
		//return operaRepository.existsByNome(opera.getNome());
		return operaRepository.existsByNomeAndDescrizione(opera.getNome(), opera.getDescrizione());	
	}
	
	public List<Opera> findAllByArtista(Artista artista) {
		List<Opera> opere = new ArrayList<Opera>();
		for(Opera o : operaRepository.findAllByArtista(artista)) {
			opere.add(o);
		}
		return opere;
	}
	
}