package br.com.casadocodigo.service;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import java.io.Serializable;
import br.com.casadocodigo.models.Pagamento;

public class PagamentoGateway implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String pagar(BigDecimal total) {

		Client client = ClientBuilder.newClient();
		Pagamento pagamento = new Pagamento(total);
		String target = "http://book-payment.herokuapp.com/payment";
		javax.ws.rs.client.Entity<Pagamento> json = javax.ws.rs.client.Entity.json(pagamento);
		WebTarget webTarget = client.target(target);
		Builder request = webTarget.request();
		return request.post(json, String.class);

	}
	
}

	/*
	 * Pagamento pagamento = new Pagamento(getTotal()); String target =
	 * "http://book-payment.herokuapp.com/payment"; Client client =
	 * ClientBuilder.newClient(); String response =
	 * client.target(target).request().post(Entity.json(pagamento), String.class);
	 * System.out.println(response);
	 */


