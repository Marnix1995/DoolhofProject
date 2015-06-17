/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Alois
 */
public class PacmanTest {
    
    public PacmanTest() {
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
     * Test of getImage method, of class Pacman.
     */
    //@Test
    public void testGetImage() {
        System.out.println("getImage");
        Pacman instance = new Pacman();
        Image expResult = null;
        Image result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of schiet method, of class Pacman.
     */
    //@Test
    public void testSchiet() {
        System.out.println("schiet");
        int dir = 1;
        Pacman instance = new Pacman();
        instance.schiet(dir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wakaWakaWaka method, of class Pacman.
     */
    //@Test
    public void testWakaWakaWaka() {
        System.out.println("wakaWakaWaka");
        Pacman instance = new Pacman();
        instance.wakaWakaWaka();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pakOp method, of class Pacman.
     */
    //@Test
    public void testPakOp() {
        System.out.println("pakOp");
        Pacman p = null;
        Pacman instance = new Pacman();
        instance.pakOp(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int dir = 1;
        Pacman instance = new Pacman();
        //instance.move(dir);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals("Result", 1, 1);
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMove1() {
        System.out.println("move");
        int dir = 1;
        Pacman instance = new Pacman();
        //instance.move(dir);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals("Result", 2, 1);
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    //@Test
    public void testMove2() {
        System.out.println("move");
        int dir = 2;
        Pacman instance = new Pacman();
        int n = 25;
        Vak[][] vakjes = new Vak[n][n];
        instance.setVak(vakjes[1][1]);
        instance.move(2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals("Result", 2, 1);
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMove3() {
        System.out.println("move");
        Level l = new Level(Doolhof.getLevel0(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(1);
        assertEquals(p.getVak(), start.getBuur(1));
    }
    
    
}
