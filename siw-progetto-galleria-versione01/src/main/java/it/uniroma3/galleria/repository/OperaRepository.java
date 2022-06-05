package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {
	
	/*
	 * Possiamo inserire, in aggiunta ai metodi dell'interfaccia, 
	 * delle query che servono all'applicazione
	*/
	
	public List<Opera> findAllByArtista(Artista artista);

	public boolean existsByNomeAndDescrizione(String nome, String descrizione);	

}
