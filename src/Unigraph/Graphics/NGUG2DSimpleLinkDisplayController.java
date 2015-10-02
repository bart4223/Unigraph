package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DSimpleLinkDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        FGC.beginPath();
        try {
            // Link
            NGUG2DDiagramObjectLayout fromObject = (NGUG2DDiagramObjectLayout)DiagramLinkLayout.getLayoutManager().getObjectLayout(DiagramLinkLayout.getDiagramLink().getFromObject());
            NGUG2DDiagramObjectLayout toObject = (NGUG2DDiagramObjectLayout)DiagramLinkLayout.getLayoutManager().getObjectLayout(DiagramLinkLayout.getDiagramLink().getToObject());
            FGC.setStroke(DiagramLinkLayout.getLineColor());
            FGC.setLineWidth(1.0);
            FGC.moveTo(fromObject.getPosition().getXAsInt(), fromObject.getPosition().getYAsInt());
            FGC.lineTo(toObject.getPosition().getXAsInt(), toObject.getPosition().getYAsInt());
            FGC.stroke();
        } finally {
            FGC.closePath();
        }
    }

    public NGUG2DSimpleLinkDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DSimpleLinkDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DSimpleDiagramLinkLayout DiagramLinkLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramLinkLayoutClass) {
        return aDiagramLinkLayoutClass.equals(NGUG2DSimpleDiagramLinkLayout.class);
    }

}
