package br.com.casadocodigo.websockets;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

@ApplicationScoped
public class UsuariosSession {

	private List<Session> sessions = new ArrayList<Session>();
	
	public void add(Session session) {
		sessions.add(session);
	}
	
	public void remove(Session session) {
		sessions.remove(session);
	}
	
	public List<Session> getSessions() {
		return sessions;
	}
	
}
