package Unigraph.UI;

import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Unigraph.Graphics.NGUG2DDiagramDisplayManager;
import Unigraph.Visuals.NGUG2DDiagramLayer;
import Unigraph.Visuals.NGUG2DDiagramLayoutManager;
import Unigraph.Visuals.NGUG2DDiagramLinkLayout;
import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Visuals.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NGUG2DDiagramStageController extends NGStageController {

    protected Double FGridDistance;

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
    private AnchorPane apLayer;

    @FXML
    private Canvas Layer0;

    @FXML
    private Canvas LayerTop;

    protected ArrayList<DiagramLayer> FDiagramLayers;
    protected NGDisplayView FDisplayView;
    protected NGUG2DDiagramLayoutManager FLayoutManager;
    protected NGUG2DDiagramObjectLayout FCurrentLO;
    protected NGPoint2D FCurrentPos;

    @Override
    protected void CreateDisplayController() {
        super.CreateDisplayController();
        FDisplayView = new NGDisplayView(Layer0.getWidth(), Layer0.getHeight());
        NGGrid2DDisplayController dcgrid = new NGGrid2DDisplayController(Layer0, "Grid");
        dcgrid.setView(FDisplayView);
        dcgrid.GridDistance = FGridDistance.intValue();
        dcgrid.GridColor = Color.DARKGRAY;
        dcgrid.AlternateGridColor = getConfigurationPropertyAsBoolean("NGUnigraph2DApplicationModule.AlternateGridColor", false);
        dcgrid.DrawGrid = getConfigurationPropertyAsBoolean("NGUnigraph2DApplicationModule.DrawGrid", true);
        registerDisplayController(dcgrid);
    }

    @Override
    protected void DoInitialize() {
        super.DoInitialize();
        LayerTop.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        HandleMousePressed(t);
                    }
                });
        LayerTop.addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        HandleMouseReleased(t);
                    }
                });
        LayerTop.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        HandleMouseDragged(t);
                    }
                });
    }

    protected void HandleMousePressed(MouseEvent t) {
        FCurrentPos.setX(t.getX());
        FCurrentPos.setY(t.getY());
        switch (t.getButton()) {
            case PRIMARY:
                FCurrentLO = FLayoutManager.getObjectLayout(FCurrentPos);
                break;
        }
    }

    protected void HandleMouseReleased(MouseEvent t) {
        switch (t.getButton()) {
            case PRIMARY:
                FCurrentLO = null;
                break;
        }
    }

    protected void HandleMouseDragged(MouseEvent t) {
        if (FCurrentLO != null) {
            Double dx = t.getX() - FCurrentPos.getX();
            Double dy = t.getY() - FCurrentPos.getY();
            if (dx >= FGridDistance || dx <= -FGridDistance || dy >= FGridDistance || dy <= -FGridDistance) {
                Double x = FCurrentLO.getPosition().getX() + dx;
                Integer xx = (int)(x / FGridDistance);
                Double x2 = xx * FGridDistance;
                Double y = FCurrentLO.getPosition().getY() + dy;
                Integer yy = (int)(y / FGridDistance);
                Double y2 = yy * FGridDistance;
                FLayoutManager.setObjectPosition(FCurrentLO, x2, y2);
                FCurrentPos.setX(t.getX() + (x2 - x));
                FCurrentPos.setY(t.getY() + (y2 - y));
            }
        }
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
        canvas.setHeight(apLayer.getHeight());
        canvas.setWidth(apLayer.getWidth());
        canvas.setOpacity(aDiagramLayer.getOpacity());
        FDiagramLayers.add(new DiagramLayer(canvas, aDiagramLayer.getZOrder()));
        Canvas OverLayingCanvas = getOverlyingLayer(aDiagramLayer.getZOrder());
        Integer index = apLayer.getChildren().size() - 1;
        if (OverLayingCanvas != null)
            index = apLayer.getChildren().indexOf(OverLayingCanvas);
        apLayer.getChildren().add(index, canvas);
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
        FCurrentPos = new NGPoint2D(0, 0);
        FGridDistance = 20.0;
    }

    public void addDiagramObjectLayout(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        if (aDiagramObjectLayout instanceof NGUG2DDiagramObjectLayout) {
            NGUG2DDiagramObjectLayout layout = (NGUG2DDiagramObjectLayout)aDiagramObjectLayout;
            String layername = getLayerName(layout.getDiagramLayerID());
            NGUG2DDiagramDisplayManager dm = (NGUG2DDiagramDisplayManager)getDisplayController(layername);
            dm.addObjectLayout(aDiagramObjectLayout);
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
        }
    }

    public void addDiagramLayer(NGUG2DDiagramLayer aDiagramLayer) {
        FLayoutManager = aDiagramLayer.getLayoutManager();
        NGDisplayManager dm = CreateDiagramLayer(aDiagramLayer);
        dm.Initialize();
        registerDisplayController(dm);
    }

    public void RefreshDiagram() {
        RenderScene();
    }

    public void RefreshDiagram(NGUG2DDiagramLayer aDiagramLayer) {
        String layername = getLayerName(aDiagramLayer.getID());
        NGDisplayController dc = getDisplayController(layername);
        RenderScene(dc);
    }

}
