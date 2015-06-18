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
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveUpVakMuur() {
        System.out.println("move Up");
        Level l = new Level(Doolhof.getLevel0(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(1);
        assertEquals(p.getVak(), p.getVak());
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveRightLeegVak() {
        System.out.println("move Right");
        Level l = new Level(Doolhof.getLevel0(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(4);
        assertEquals(p.getVak(), start.getBuur(4));
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveDownVakVijand() {
        System.out.println("move Down");
        Level l = new Level(Doolhof.getLevel0(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(2);
        assertEquals(p.getVak(), start.getBuur(2));
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveLeftVakExit() {
        System.out.println("move Left");
        Level l = new Level(Doolhof.getLevel0(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(3);
        assertEquals(p.getVak(), start.getBuur(3));
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveUpVakBuitenMuur() {
        System.out.println("move Up");
        Level l = new Level(Doolhof.getLevelTest(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(1);
        assertEquals(p.getVak(), p.getVak());
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveDownVakBazooka() {
        System.out.println("move Down");
        Level l = new Level(Doolhof.getLevelTest(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(2);
        assertEquals(p.getVak(), start.getBuur(2));
    }
    
    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void testMoveRightVakHelper() {
        System.out.println("move Right");
        Level l = new Level(Doolhof.getLevelTest(), new Timers(), 10000 );
        Pacman p = l.getPacman();
        Vak start = p.getVak();
        p.move(3);
        assertEquals(p.getVak(), start.getBuur(3));
    }
    
    
}
