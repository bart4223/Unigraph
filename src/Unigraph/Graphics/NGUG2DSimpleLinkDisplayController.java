package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

public class NGUG2DSimpleLinkDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    @Override
    protected void DoRender() {
        super.DoRender();
        NGUG2DDiagramObjectLayout fromObject = (NGUG2DDiagramObjectLayout)LinkLayout.getLayoutManager().getObjectLayout(LinkLayout.getDiagramLink().getFromObject());
        NGUG2DDiagramObjectLayout toObject = (NGUG2DDiagramObjectLayout)LinkLayout.getLayoutManager().getObjectLayout(LinkLayout.getDiagramLink().getToObject());
        drawLine(fromObject.getPosition().getXAsInt(), fromObject.getPosition().getYAsInt(), toObject.getPosition().getXAsInt(), toObject.getPosition().getYAsInt(), LinkLayout.getLineColor());
    }

    public NGUG2DSimpleLinkDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DSimpleLinkDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DSimpleDiagramLinkLayout LinkLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramLinkLayoutClass) {
        return aDiagramLinkLayoutClass.equals(NGUG2DSimpleDiagramLinkLayout.class);
    }

}
