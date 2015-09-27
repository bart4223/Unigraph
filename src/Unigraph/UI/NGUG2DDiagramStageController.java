package Unigraph.UI;

import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Unigraph.Graphics.NGUG2DDiagramDisplayManager;
import Unigraph.Visuals.NGUG2DDiagramLayer;
import Unigraph.Visuals.NGUG2DDiagramLayoutManager;
import Unigraph.Visuals.NGUG2DDiagramLinkLayout;
import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGDisplayManager;
import Uniwork.Visuals.NGDisplayView;
import Uniwork.Visuals.NGGrid2DDisplayController;
import Uniwork.Visuals.NGStageController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NGUG2DDiagramStageController extends NGStageController {

    protected class DiagramLayer {

        protected Canvas FCanvas;
        protected Integer FZOrder;

        public DiagramLayer(Canvas aCanvas, Integer aZOrder) {
            FCanvas = aCanvas;
            FZOrder = aZOrder;
        }

        public Canvas getCanvas() {
            return FCanvas;
        }

        public Integer getZOrder() {
            return FZOrder;
        }

    }

    @FXML
    private AnchorPane AnchorPane0;

    @FXML
    private Canvas Layer0;

    @FXML
    private Canvas LayerTop;

    protected ArrayList<DiagramLayer> FDiagramLayers;
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

    protected Canvas getOverlyingLayer(Integer aZOrder) {
        DiagramLayer res = null;
        for (DiagramLayer layer : FDiagramLayers) {
            if (layer.getZOrder() > aZOrder) {
                if (res == null || (res.getZOrder() > layer.getZOrder()))
                    res = layer;
            }
        }
        if (res != null)
            return res.getCanvas();
        else
            return null;
    }

    protected String getLayerName(String aID) {
        return String.format("Layer.%s", aID);
    }

    protected NGUG2DDiagramDisplayManager CreateDiagramLayer(NGUG2DDiagramLayer aDiagramLayer) {
        String layername = getLayerName(aDiagramLayer.getID());
        Canvas canvas = new Canvas();
        canvas.setHeight(AnchorPane0.getHeight());
        canvas.setWidth(AnchorPane0.getWidth());
        FDiagramLayers.add(new DiagramLayer(canvas, aDiagramLayer.getZOrder()));
        Canvas OverLayingCanvas = getOverlyingLayer(aDiagramLayer.getZOrder());
        if (OverLayingCanvas == null)
            OverLayingCanvas = LayerTop;
        Integer index = FDiagramLayers.indexOf(OverLayingCanvas);
        AnchorPane0.getChildren().add(index, canvas);
        NGUG2DDiagramDisplayManager dm = new NGUG2DDiagramDisplayManager(canvas, layername);
        dm.setView(FDisplayView);
        return dm;
    }

    public NGUG2DDiagramStageController() {
        this(null);
    }

    public NGUG2DDiagramStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
        FDiagramLayers = new ArrayList<>();
    }

    public void addDiagramObjectLayout(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        if (aDiagramObjectLayout instanceof NGUG2DDiagramObjectLayout) {
            NGUG2DDiagramObjectLayout layout = (NGUG2DDiagramObjectLayout)aDiagramObjectLayout;
            String layername = getLayerName(layout.getDiagramLayerID());
            NGUG2DDiagramDisplayManager dm = (NGUG2DDiagramDisplayManager)getDisplayController(layername);
            dm.addObjectLayout(aDiagramObjectLayout);
            RenderScene(dm);
        }
    }

    public void addDiagramLinkLayout(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {
        if (aDiagramLinkLayout instanceof NGUG2DDiagramLinkLayout) {
            NGUG2DDiagramLinkLayout layout = (NGUG2DDiagramLinkLayout)aDiagramLinkLayout;
            NGUG2DDiagramObjectLayout layoutFrom = (NGUG2DDiagramObjectLayout)layout.getLayoutManager().getObjectLayout(layout.getDiagramLink().getFromObject());
            NGUG2DDiagramObjectLayout layoutTo = (NGUG2DDiagramObjectLayout)layout.getLayoutManager().getObjectLayout(layout.getDiagramLink().getToObject());
            String id = layoutFrom.getDiagramLayerID();
            if (layoutFrom.getDiagramLayerZOrder() > layoutTo.getDiagramLayerZOrder())
                id = layoutTo.getDiagramLayerID();
            String layername = getLayerName(id);
            NGUG2DDiagramDisplayManager dm = (NGUG2DDiagramDisplayManager)getDisplayController(layername);
            dm.addLinkLayout(aDiagramLinkLayout);
            RenderScene(dm);
        }
    }

    public void addDiagramLayer(NGUG2DDiagramLayer aDiagramLayer) {
        NGDisplayManager dm = CreateDiagramLayer(aDiagramLayer);
        RenderScene(dm);
    }

}
