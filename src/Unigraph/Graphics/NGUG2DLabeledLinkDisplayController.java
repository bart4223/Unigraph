package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DLabeledDiagramLinkLayout;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Uniwork.Misc.NGMisc;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NGUG2DLabeledLinkDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    protected Integer FFontSize = 10;

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
            // Text
            Double x = (NGMisc.Max(fromObject.getPosition().getX(), toObject.getPosition().getX()) - NGMisc.Min(fromObject.getPosition().getX(), toObject.getPosition().getX())) / 2 + NGMisc.Min(fromObject.getPosition().getX(), toObject.getPosition().getX());
            Double y = (NGMisc.Max(fromObject.getPosition().getY(), toObject.getPosition().getY()) - NGMisc.Min(fromObject.getPosition().getY(), toObject.getPosition().getY())) / 2 + NGMisc.Min(fromObject.getPosition().getY(), toObject.getPosition().getY());
            int dx = DiagramLinkLayout.getWidth()/2;
            int dy = DiagramLinkLayout.getHeight()/2;
            int TLX = x.intValue() - dx;
            int TLY = y.intValue() - dy;
            FGC.setFill(DiagramLinkLayout.getLinkColor());
            FGC.fillRect(TLX, TLY, DiagramLinkLayout.getWidth(), DiagramLinkLayout.getHeight());
            FGC.strokeRect(TLX, TLY, DiagramLinkLayout.getWidth(), DiagramLinkLayout.getHeight());
            FGC.setFont(new Font("Arial", FFontSize));
            FGC.strokeText(DiagramLinkLayout.getLabeledDiagramLink().getName(), x - DiagramLinkLayout.getWidth() / 2 + 4, y + 4);
        } finally {
            FGC.closePath();
        }
    }

    public NGUG2DLabeledLinkDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DLabeledLinkDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DLabeledDiagramLinkLayout DiagramLinkLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramLinkLayoutClass) {
        return aDiagramLinkLayoutClass.equals(NGUG2DLabeledDiagramLinkLayout.class);
    }

}
