package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
public class SessionCollector  {
    private static final Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();
    private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static Map<String, HttpSession> getSessions() {
		return sessions;
	}
    public void sessionCreated(HttpServletRequest event, HttpSession session1) {
    	session1.invalidate();
        HttpSession session = event.getSession();
        sessions.put(session.getId(), session);
        this.id = session.getId();
    }
    public HttpSession getSession() {
    	return sessions.get(id);
    }

    public void sessionDestroyed(String id) {
        sessions.remove(id);
    }

    public static HttpSession find(String sessionId) {
        return sessions.get(sessionId);
    }
    public static long findTime(String id) {
    	HttpSession httpSession = sessions.get(id);
    	
    

        long now = new java.util.Date().getTime();
        System.out.println(now);
        System.out.println(httpSession.getCreationTime());
		return now - httpSession.getCreationTime();
    	
    	
    }

}