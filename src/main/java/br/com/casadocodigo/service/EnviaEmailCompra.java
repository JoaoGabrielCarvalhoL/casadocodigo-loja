package br.com.casadocodigo.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.casadocodigo.daos.CompraDao;
import br.com.casadocodigo.infra.MailSender;
import br.com.casadocodigo.models.Compra;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topics/CarrinhoComprasTopico"), 
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class EnviaEmailCompra implements MessageListener{
	
	@Inject
	private MailSender mailSender;
	
	@Inject
	private CompraDao compraDao;
	
	@Override
	public void onMessage(Message message) {
				
		try {
			TextMessage textMessage = (TextMessage) message;	
			Compra compra = compraDao.buscarPorUuid(textMessage.getText());
		
		mailSender.send("compras@casacodigo.com.br", compra.getUsuario().getEmail(), 
        		"Nova Compra na Casa do Código", "Sua compra foi realizada com sucesso! Número do Pedido: " 
        + compra.getUuid());
		
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}

	

}
