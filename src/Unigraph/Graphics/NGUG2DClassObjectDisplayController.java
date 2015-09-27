package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DClassObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        super.DoRender();
        drawRectangle(ClassLayout.getPosition().getXAsInt(), ClassLayout.getPosition().getYAsInt(), ClassLayout.getWidth(), ClassLayout.getHeight(), ClassLayout.getLineColor());
    }

    public NGUG2DClassObjectDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DClassObjectDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DClassDiagramObjectLayout ClassLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramObjectLayoutClass) {
        return aDiagramObjectLayoutClass.equals(NGUG2DClassDiagramObjectLayout.class);
    }

}
