package br.ufc.TrabalhoFBD.model;

public class MensagemGrupo extends Mensagem{
	
	private Grupo destinatario;

	public Grupo getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Grupo destinatario) {
		this.destinatario = destinatario;
	}
	

}
