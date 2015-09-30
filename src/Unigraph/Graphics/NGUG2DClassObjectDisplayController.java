package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DClassObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

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

    public NGUG2DClassObjectDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DClassObjectDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DClassDiagramObjectLayout DiagramObjectLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramObjectLayoutClass) {
        return aDiagramObjectLayoutClass.equals(NGUG2DClassDiagramObjectLayout.class);
    }

}
