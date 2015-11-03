package Unigraph.Test.Units;

import Unigraph.Objects.NGUGTableDiagramObject;
import Uniwork.Test.NGCustomTestUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NGUGTableDiagramObjectTest extends NGCustomTestUnit {

    @BeforeClass
    public static void beforeSuite() {
        StartTestSuite();
    }

    @AfterClass
    public static void afterSuite() {
        FinishTestSuite();
    }

    @Test
    public void testTable01() throws Exception {
        StartTest();
        NGUGTableDiagramObject obj = new NGUGTableDiagramObject("Table");
        assertEquals("Table", obj.getName());
        FinishTest();
    }

}