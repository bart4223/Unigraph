package Unigraph.UI;

import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGDisplayView;
import Uniwork.Visuals.NGGrid2DDisplayController;
import Uniwork.Visuals.NGStageController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class NGUG2DDiagramStageController extends NGStageController {

    @FXML
    private Canvas Layer0;

    @FXML
    private Canvas LayerTop;

    @Override
    protected void CreateDisplayController() {
        super.CreateDisplayController();
        NGDisplayView dv = new NGDisplayView(Layer0.getWidth(), Layer0.getHeight());
        NGGrid2DDisplayController dcgrid = new NGGrid2DDisplayController(Layer0, "Grid");
        dcgrid.setView(dv);
        dcgrid.GridDistance = 20;
        dcgrid.GridColor = Color.DARKGRAY;
        registerDisplayController(dcgrid);
    }

    public NGUG2DDiagramStageController() {
        this(null);
    }

    public NGUG2DDiagramStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

    public void addObjectLayout(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        if (aDiagramObjectLayout instanceof NGUG2DDiagramObjectLayout) {
            NGUG2DDiagramObjectLayout layout = (NGUG2DDiagramObjectLayout)aDiagramObjectLayout;
        }
    }

    public void addLinkLayout(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {

    }

}
