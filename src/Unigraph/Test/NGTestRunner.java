package Unigraph.Test;

import Uniwork.Test.NGCustomTestRunner;
import Unigraph.Test.Units.NGAllTestUnits;

public class NGTestRunner extends NGCustomTestRunner{

    public NGTestRunner(Class aTestClass) {
        super(aTestClass);
    }

    public static void main(String[] args) {
        TestRunner = new NGTestRunner(NGAllTestUnits.class);
        TestRunner.InitTests();
        TestRunner.RunTests();
    }

}
