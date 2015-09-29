package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DBoxDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DBoxObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        super.DoRender();
        fillRectangle(DiagramObjectLayout.getPosition().getXAsInt(), DiagramObjectLayout.getPosition().getYAsInt(), DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight(), DiagramObjectLayout.getObjectColor());
        drawRectangle(DiagramObjectLayout.getPosition().getXAsInt(), DiagramObjectLayout.getPosition().getYAsInt(), DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight(), DiagramObjectLayout.getLineColor());
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
