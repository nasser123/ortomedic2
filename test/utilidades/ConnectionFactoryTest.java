/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Atendimento
 */
public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class ConnectionFactory.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = ConnectionFactory.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnectionWithNoDatabase method, of class ConnectionFactory.
     */
    @Test
    public void testGetConnectionWithNoDatabase() {
        System.out.println("getConnectionWithNoDatabase");
        Connection expResult = null;
        Connection result = ConnectionFactory.getConnectionWithNoDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityManager method, of class ConnectionFactory.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManager expResult = null;
        EntityManager result = ConnectionFactory.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of geraBackup method, of class ConnectionFactory.
     */
    @Test
    public void testGeraBackup() {
        System.out.println("geraBackup");
        boolean expResult = false;
        boolean result = ConnectionFactory.geraBackup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restauraBackup method, of class ConnectionFactory.
     */
    @Test
    public void testRestauraBackup() {
        System.out.println("restauraBackup");
        String arquivo = "";
        String database = "";
        boolean expResult = false;
        boolean result = ConnectionFactory.restauraBackup(arquivo, database, true);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
