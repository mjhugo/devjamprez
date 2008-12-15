package com.piragua.groovy

import com.piragua.java.MyServlet
import javax.servlet.http.*

public class DuckTypeTest extends GroovyTestCase {

    void testDef() {
        def name = "Mike"
        assertTrue name instanceof String
    }

    void testSet() {
        def myList = [1, 2, 3, 4, 5]
        assertTrue((myList as Set) instanceof Set)
    }
}