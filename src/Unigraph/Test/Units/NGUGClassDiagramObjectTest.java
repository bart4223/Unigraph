package Unigraph.Test.Units;

import Unigraph.Objects.NGUGClassDiagramObject;
import Uniwork.Test.NGCustomTestUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NGUGClassDiagramObjectTest extends NGCustomTestUnit {

    @BeforeClass
    public static void beforeSuite() {
        StartTestSuite();
    }

    @AfterClass
    public static void afterSuite() {
        FinishTestSuite();
    }

    @Test
    public void testClass01() throws Exception {
        StartTest();
        NGUGClassDiagramObject obj = new NGUGClassDiagramObject("Class");
        assertEquals("Class", obj.getName());
        FinishTest();
    }

}