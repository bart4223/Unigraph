package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DBoxDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Font;

public class NGUG2DBoxObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    protected Integer FFontSize = 12;

    @Override
    protected void DoRender() {
        // Frame
        int dx = DiagramObjectLayout.getWidth()/2;
        int dy = DiagramObjectLayout.getHeight()/2;
        int TLX = DiagramObjectLayout.getPosition().getXAsInt() - dx;
        int TLY = DiagramObjectLayout.getPosition().getYAsInt() - dy;
        FGC.setFill(DiagramObjectLayout.getObjectColor());
        FGC.fillRect(TLX, TLY, DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight());
        FGC.setLineWidth(1.0);
        FGC.setStroke(DiagramObjectLayout.getLineColor());
        FGC.strokeRect(TLX, TLY, DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight());
        // Text
        FGC.setFont(new Font("Arial", FFontSize));
        FGC.strokeText(DiagramObjectLayout.getDiagramObject().getName(), TLX + 10, TLY + 20);
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
