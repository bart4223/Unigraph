package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DSimpleLinkDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        super.DoRender();
        NGUG2DDiagramObjectLayout fromObject = (NGUG2DDiagramObjectLayout)DiagramLinkLayout.getLayoutManager().getObjectLayout(DiagramLinkLayout.getDiagramLink().getFromObject());
        NGUG2DDiagramObjectLayout toObject = (NGUG2DDiagramObjectLayout)DiagramLinkLayout.getLayoutManager().getObjectLayout(DiagramLinkLayout.getDiagramLink().getToObject());
        drawLine(fromObject.getPosition().getXAsInt(), fromObject.getPosition().getYAsInt(), toObject.getPosition().getXAsInt(), toObject.getPosition().getYAsInt(), DiagramLinkLayout.getLineColor());
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
