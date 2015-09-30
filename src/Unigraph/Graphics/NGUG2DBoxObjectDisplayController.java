package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DBoxDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DBoxObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        int dx = DiagramObjectLayout.getWidth()/2;
        int dy = DiagramObjectLayout.getHeight()/2;
        int TLX = DiagramObjectLayout.getPosition().getXAsInt() - dx;
        int TLY = DiagramObjectLayout.getPosition().getYAsInt() - dy;
        FGC.setFill(DiagramObjectLayout.getObjectColor());
        FGC.fillRect(TLX, TLY, DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight());
        FGC.setStroke(DiagramObjectLayout.getLineColor());
        FGC.strokeRect(TLX, TLY, DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight());
    }

    public NGUG2DBoxObjectDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DBoxObjectDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DBoxDiagramObjectLayout DiagramObjectLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramObjectLayoutClass) {
        return aDiagramObjectLayoutClass.equals(NGUG2DBoxDiagramObjectLayout.class);
    }

}
