package test.service;


import org.junit.Test;

/**
 * Created by Adrian on 24/06/2017.
 */
public class PathFinderServiceTest extends BaseTest {

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
    public void testDirectionConnections() throws Exception {
        testDirectConnections(A, B, 3);
        testDirectConnections(B, A, 3);
        testDirectConnections(B, C, 7);
        testDirectConnections(C, E, 3);
        testDirectConnections(E, D, 9);
        testDirectConnections(D, E, 9);
        testDirectConnections(D, B, 5);
        testDirectConnections(D, C, 9);
    }

    // GROUP 2: 2 stations far tests
    // A -> B -> C 10m
    // B -> C -> E 10m
    // B -> A -> D 9m
    // D -> B -> A 8m
    @Test
    public void testConnectionsTwoStationsFar() throws Exception {
        testConnectionsTwoStationsFar(A, B, C, 10);
        testConnectionsTwoStationsFar(B, C, E, 10);
        testConnectionsTwoStationsFar(B, A, D, 10);
        testConnectionsTwoStationsFar(D, B, A, 10);
    }




}
