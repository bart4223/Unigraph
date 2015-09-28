package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DBoxDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DBoxObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        super.DoRender();
        fillRectangle(ClassLayout.getPosition().getXAsInt(), ClassLayout.getPosition().getYAsInt(), ClassLayout.getWidth(), ClassLayout.getHeight(), ClassLayout.getObjectColor());
        drawRectangle(ClassLayout.getPosition().getXAsInt(), ClassLayout.getPosition().getYAsInt(), ClassLayout.getWidth(), ClassLayout.getHeight(), ClassLayout.getLineColor());
    }

    public NGUG2DBoxObjectDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DBoxObjectDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DClassDiagramObjectLayout ClassLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramObjectLayoutClass) {
        return aDiagramObjectLayoutClass.equals(NGUG2DBoxDiagramObjectLayout.class);
    }

}
