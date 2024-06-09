package tree;

import catcafe.CatCafe;
import catcafe.FelineOverLord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CatCafeTest {
    static CatCafe testCafe = new CatCafe();
    private static FelineOverLord test;
    @BeforeAll
    public static void setUp(){
        test = new FelineOverLord("Big Cat", 7);
        testCafe.addCat(test);
    }
    @Test
    public void testGetCatCount(){
        assertEquals(testCafe.getCatCount(), 1);
    }

    @Test
    public void testGetCatByWeight(){
        assertEquals(testCafe.getCatByWeight(6,8),Optional.of(test));
    }

    @Test
    public void testGetCatByWeightFalse(){
        assertEquals(testCafe.getCatByWeight(1,3),Optional.empty());
    }

    @Test
    public void testGetCatByName(){
        assertEquals(testCafe.getCatByName("Big Cat"), Optional.of(test));
    }

    @Test
    public void testGetCatByNameFalse(){
        assertEquals(testCafe.getCatByName("hello"), Optional.empty());
    }

    @Test
    public void testAddCat(){
        FelineOverLord f = new FelineOverLord("Mieze", 5);
        testCafe.addCat(f);
        assertEquals(testCafe.getCatCount(), 2);
    }
}
