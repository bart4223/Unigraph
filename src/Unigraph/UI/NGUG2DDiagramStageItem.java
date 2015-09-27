package Unigraph.UI;

import Unigraph.Base.*;
import Unigraph.Visuals.NGUG2DDiagramLayerEvent;
import Unigraph.Visuals.NGUG2DDiagramLayoutEventListener;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class NGUG2DDiagramStageItem extends NGCustomStageItem implements NGUGDiagramEventListener, NGUG2DDiagramLayoutEventListener {

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
        sc.addDiagramObjectLayout(e.getDiagramObjectLayout());
    }

    @Override
    public void handleLinkLayoutAdded(NGUGDiagramLinkLayoutEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.addDiagramLinkLayout(e.getDiagramLinkLayout());
    }

    @Override
    public void handleLayerAdded(NGUG2DDiagramLayerEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.addDiagramLayer(e.getDigramLayer());
    }

}
