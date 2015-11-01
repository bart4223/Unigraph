package Unigraph.Test;

import Unigraph.Test.Units.NGAllTestUnits;
import Uniwork.Misc.NGConsoleLogEventListener;
import Uniwork.Misc.NGLogManager;
import Uniwork.Test.NGTeamcityLogEventListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NGTestRunner {

    protected static NGConsoleLogEventListener FLogListener;

    public static void main(String[] args) {
        FLogListener = new NGTeamcityLogEventListener();
        Uniwork.Test.NGTestRunner.Logger = new NGLogManager();
        Uniwork.Test.NGTestRunner.Logger.addEventListener(FLogListener);
        Uniwork.Test.NGTestRunner.Logger.writeLog("message text='Test run started...'");
        Result result = JUnitCore.runClasses(NGAllTestUnits.class);
        for (Failure failure : result.getFailures()) {
            Uniwork.Test.NGTestRunner.Logger.writeLog(String.format("message text='Error' errorDetails='%s'", failure.toString()));
        }
        Uniwork.Test.NGTestRunner.Logger.writeLog("message text='Test run finished!'");
    }

}
