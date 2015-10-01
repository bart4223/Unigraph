package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DTableDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Font;

import java.util.Iterator;

public class NGUG2DTableObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    protected Integer FFontSize = 12;
    protected Integer FFontSizeField = 10;

    @Override
    protected void DoRender() {
        FGC.beginPath();
        try {
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
            FGC.moveTo(TLX, TLY + FFontSize * 3);
            FGC.lineTo(TLX + DiagramObjectLayout.getWidth(), TLY + FFontSize * 3);
            FGC.stroke();
            FGC.moveTo(TLX, TLY + FFontSize * 3 - 3);
            FGC.lineTo(TLX + DiagramObjectLayout.getWidth(), TLY + FFontSize * 3 - 3);
            FGC.stroke();
            // Text
            FGC.setFont(new Font("Arial", FFontSize));
            FGC.strokeText(DiagramObjectLayout.getDiagramObject().getName(), TLX + 10, TLY + 20);
            // Members
            Iterator<String> itr = DiagramObjectLayout.getTableDiagramObject().getFields();
            Integer y = 2 * 20 + FFontSize;
            FGC.setStroke(DiagramObjectLayout.getLineColor().brighter());
            FGC.setFont(new Font("Arial", FFontSizeField));
            while (itr.hasNext()) {
                String member = itr.next();
                FGC.strokeText(member, TLX + 10, TLY + y);
                y = y + FFontSizeField;
            }
        } finally {
            FGC.closePath();
        }
    }

    public NGUG2DTableObjectDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DTableObjectDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
    }

    public NGUG2DTableDiagramObjectLayout DiagramObjectLayout;

    @Override
    public Boolean SupportLayoutClass(Class aDiagramObjectLayoutClass) {
        return aDiagramObjectLayoutClass.equals(NGUG2DTableDiagramObjectLayout.class);
    }

}
