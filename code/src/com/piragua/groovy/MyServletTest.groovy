package com.piragua.groovy

import javax.servlet.http.*
import com.piragua.java.MyServlet

public class MyServletTest extends GroovyTestCase {

    Map params
    Map session

    def request

    protected void setUp() {
        params = [:]
        session = [:]
        def mockSession = [setAttribute: {k, v -> session[k] = v }]

        request = [
                getParameter: {param -> return params[param]},
                getSession: {createNew -> return mockSession as HttpSession}]
    }

    void testDoGetFoundUser() {
        params.username = 'mike'
        new MyServlet().doPost(request as HttpServletRequest,
                [:] as HttpServletResponse)
        assertEquals(params.username, session.loggedInUser)
    }

    void testDoGetNoUser() {
        params.username = null
        new MyServlet().doPost(request as HttpServletRequest,
                [:] as HttpServletResponse)
        assertNull(session.loggedInUser)
    }
}