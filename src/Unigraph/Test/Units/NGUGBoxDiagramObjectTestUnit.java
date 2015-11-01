package Unigraph.Test.Units;

import Unigraph.Objects.NGUGBoxDiagramObject;
import Uniwork.Test.NGCustomTestUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NGUGBoxDiagramObjectTestUnit extends NGCustomTestUnit {

    @BeforeClass
    public static void beforeSuite() {
        StartTestSuite();
    }

    @AfterClass
    public static void afterSuite() {
        FinishTestSuite();
    }

    @Test
    public void testBox01() throws Exception {
        StartTest();
        NGUGBoxDiagramObject obj = new NGUGBoxDiagramObject("Test");
        assertEquals("Test", obj.getName());
        FinishTest();
    }

}