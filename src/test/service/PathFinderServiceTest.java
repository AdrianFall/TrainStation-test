package test.service;


import org.junit.Test;

/**
 * Created by Adrian on 24/06/2017.
 */
public class PathFinderServiceTest extends BaseServiceTest {

    // The below tests are divided into the following groups
    // Group 1 : direction connections tests
    // Group 2 : 2 stations far tests
    // 3 stations far do not exist, neither a non connection.


    // GROUP 1: direction connections tests
    // A -> B 3m
    // B -> A 3m
    // B -> C 7m
    // C -> E 3m
    // E -> D 9m
    // D -> E 9m
    // D -> B 5m
    // D -> C 9m
    @Test
    public void testAtoB() throws Exception {
        testDirectConnections(A, B, 3);
    }
    @Test
    public void testBtoA() throws Exception {
        testDirectConnections(B, A, 3);

    }
    @Test
    public void testBtoC() throws Exception {
        testDirectConnections(B, C, 7);
    }
    @Test
    public void testCtoE() throws Exception {
        testDirectConnections(C, E, 3);
    }
    @Test
    public void testEtoD() throws Exception {
        testDirectConnections(E, D, 9);
    }
    @Test
    public void testDtoE() throws Exception {
        testDirectConnections(D, E, 9);
    }
    @Test
    public void testDtoB() throws Exception {
        testDirectConnections(D, B, 5);
    }
    @Test
    public void testDtoC() throws Exception {
        testDirectConnections(D, C, 9);
    }


    // GROUP 2: 2 stations far tests
    // A -> B -> C 10m
    // B -> C -> E 10m
    // B -> A -> D 9m
    // D -> B -> A 8m
    @Test
    public void testAthroughBtoC() throws Exception {
        testConnectionsTwoStationsFar(A, B, C, 10);
    }

    @Test
    public void testBthroughCtoE() throws Exception {
        testConnectionsTwoStationsFar(B, C, E, 10);
    }

    @Test
    public void testBthroughAtoD() throws Exception {
        testConnectionsTwoStationsFar(B, A, D, 9);
    }

    @Test
    public void testDthroughBtoA() throws Exception {
        testConnectionsTwoStationsFar(D, B, A, 8);
    }

}
