package Unigraph.UI;

import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Unigraph.Graphics.NGUG2DDiagramDisplayManager;
import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGDisplayView;
import Uniwork.Visuals.NGGrid2DDisplayController;
import Uniwork.Visuals.NGStageController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NGUG2DDiagramStageController extends NGStageController {

    @FXML
    private AnchorPane AnchorPane0;

    @FXML
    private Canvas Layer0;

    @FXML
    private Canvas LayerTop;

    protected ArrayList<Canvas> FLayers;
    protected NGDisplayView FDisplayView;

    @Override
    protected void CreateDisplayController() {
        super.CreateDisplayController();
        FDisplayView = new NGDisplayView(Layer0.getWidth(), Layer0.getHeight());
        NGGrid2DDisplayController dcgrid = new NGGrid2DDisplayController(Layer0, "Grid");
        dcgrid.setView(FDisplayView);
        dcgrid.GridDistance = 20;
        dcgrid.GridColor = Color.DARKGRAY;
        registerDisplayController(dcgrid);
    }

    protected NGUG2DDiagramDisplayManager CreateDiagramLayer(String aLayername) {
        Canvas canvas = new Canvas();
        FLayers.add(canvas);
        canvas.setHeight(AnchorPane0.getHeight());
        canvas.setWidth(AnchorPane0.getWidth());
        AnchorPane0.getChildren().add(AnchorPane0.getChildren().size() - 2, canvas);
        NGUG2DDiagramDisplayManager dm = new NGUG2DDiagramDisplayManager(canvas, aLayername);
        dm.setView(FDisplayView);
        return dm;
    }

    public NGUG2DDiagramStageController() {
        this(null);
    }

    public NGUG2DDiagramStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
        FLayers = new ArrayList<>();
    }

    public void addObjectLayout(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        if (aDiagramObjectLayout instanceof NGUG2DDiagramObjectLayout) {
            NGUG2DDiagramObjectLayout layout = (NGUG2DDiagramObjectLayout)aDiagramObjectLayout;
            String name = String.format("Objects.%d",layout.getZOrder());
            NGUG2DDiagramDisplayManager dm = (NGUG2DDiagramDisplayManager)getDisplayController(name);
            if (dm == null)
                dm = CreateDiagramLayer(name);
            dm.addObjectLayout(aDiagramObjectLayout);
            RenderScene(dm);
        }
    }

    public void addLinkLayout(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {

    }

}
