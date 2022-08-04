package br.com.casadocodigo.conf;

import javax.jms.JMSDestinationDefinition;

@JMSDestinationDefinition(
		  name="java:/jms/topics/CarrinhoComprasTopico",
		  interfaceName="javax.jms.Topic"
	
		)
public class ConfigureJMSDestination {

}
