package Unigraph.Test;

import Uniwork.Test.NGCustomTestRunner;
import Unigraph.Test.Units.NGUGAllTestUnits;

public class NGUGTestRunner extends NGCustomTestRunner {

    public NGUGTestRunner(Class aTestClass) {
        super(aTestClass);
    }

    public static void main(String[] args) {
        TestRunner = new NGUGTestRunner(NGUGAllTestUnits.class);
        TestRunner.InitTests();
        TestRunner.RunTests();
    }

}
