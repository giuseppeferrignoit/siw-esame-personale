package it.uniroma3.galleria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class GalleriaArte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String descrizione;
	
	@NotBlank
	private String citta;
	
	@OneToMany(mappedBy="galleriaArte")
	private List<Opera> opere;
	

	@ManyToMany(mappedBy="gallerieArte")
	private List<Cliente> clienti;
	
	//------------------------------------------------------

	public GalleriaArte() {
		this.clienti = new ArrayList<Cliente>();
		this.opere = new ArrayList<Opera>();	 
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public List<Opera> getOpere() {
		return opere;
	}


	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}


	public List<Cliente> getClienti() {
		return clienti;
	}


	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}
	
}
