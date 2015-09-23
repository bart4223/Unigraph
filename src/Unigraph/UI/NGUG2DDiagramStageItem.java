package Unigraph.UI;

import Unigraph.Base.*;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class NGUG2DDiagramStageItem extends NGCustomStageItem implements NGUGDiagramEventListener, NGUGDiagramLayoutEventListener {

    public NGUG2DDiagramStageItem(NGStageManager aStageManager, String aName, Stage aStage) {
        super(aStageManager, aName, aStage);
        FFXMLName = "NGUG2DDiagramStage.fxml";
        FWidth = 1600;
        FHeight = 800;
    }

    @Override
    public void handleObjectAdded(NGUGDiagramObjectEvent e) {

    }

    @Override
    public void handleLinkAdded(NGUGDiagramLinkEvent e) {

    }

    @Override
    public void handleObjectLayoutAdded(NGUGDiagramObjectLayoutEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.addObjectLayout(e.getDiagramObjectLayout());
    }

    @Override
    public void handleLinkLayoutAdded(NGUGDiagramLinkLayoutEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.addLinkLayout(e.getDiagramLinkLayout());
    }

}
