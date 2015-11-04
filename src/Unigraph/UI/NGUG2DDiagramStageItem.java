package Unigraph.UI;

import Unigraph.Base.*;
import Unigraph.Visuals.NGUG2DDiagramLayerEvent;
import Unigraph.Visuals.NGUG2DDiagramLayoutEventListener;
import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

import java.util.EventObject;

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
    public void handleObjectLayoutChanged(NGUGDiagramObjectLayoutEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.RefreshDiagram(((NGUG2DDiagramObjectLayout)e.getDiagramObjectLayout()).getDiagramLayer());
    }

    @Override
    public void handleLinkLayoutAdded(NGUGDiagramLinkLayoutEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.addDiagramLinkLayout(e.getDiagramLinkLayout());
    }

    @Override
    public void handleRefresh(EventObject e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.RefreshDiagram();
    }

    @Override
    public void handleLayerRefresh(NGUG2DDiagramLayerEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.RefreshDiagram(e.getDiagramLayer());
    }

    @Override
    public void handleLayerAdded(NGUG2DDiagramLayerEvent e) {
        NGUG2DDiagramStageController sc = (NGUG2DDiagramStageController)FStageController;
        sc.addDiagramLayer(e.getDiagramLayer());
    }

}
