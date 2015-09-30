package Unigraph.Graphics;

import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Font;

import java.util.Iterator;

public class NGUG2DClassObjectDisplayController extends NGDisplayController implements NGUGDiagramDisplayController {

    protected Integer FFontSize = 12;
    protected Integer FFontSizeMember = 10;
    protected Integer FFontSizeMethod = 10;

    @Override
    protected void DoRender() {
        // Frame
        int dx = DiagramObjectLayout.getWidth()/2;
        int dy = DiagramObjectLayout.getHeight()/2;
        int TLX = DiagramObjectLayout.getPosition().getXAsInt() - dx;
        int TLY = DiagramObjectLayout.getPosition().getYAsInt() - dy;
        FGC.setFill(DiagramObjectLayout.getObjectColor());
        FGC.fillRect(TLX, TLY, DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight());
        FGC.setStroke(DiagramObjectLayout.getLineColor());
        FGC.strokeRect(TLX, TLY, DiagramObjectLayout.getWidth(), DiagramObjectLayout.getHeight());
        FGC.strokeRect(TLX, TLY, DiagramObjectLayout.getWidth(), FFontSize * 3);
        // Text
        FGC.setFont(new Font("Arial", FFontSize));
        FGC.strokeText(DiagramObjectLayout.getDiagramObject().getName(), TLX + 20, TLY + 20);
        // Members
        Iterator<String> itr = DiagramObjectLayout.getClassDiagramObject().getMembers();
        Integer y = 2 * 20 + FFontSize;
        FGC.setStroke(DiagramObjectLayout.getLineColor().brighter());
        FGC.setFont(new Font("Arial", FFontSizeMember));
        while (itr.hasNext()) {
            String member = itr.next();
            FGC.strokeText(member, TLX + 20, TLY + y);
            y = y + FFontSizeMember;
        }
        // Methods
        itr = DiagramObjectLayout.getClassDiagramObject().getMethods();
        FGC.setStroke(DiagramObjectLayout.getLineColor().brighter());
        FGC.setFont(new Font("Arial", FFontSizeMethod));
        while (itr.hasNext()) {
            String member = itr.next();
            FGC.strokeText(member, TLX + 20, TLY + y);
            y = y + FFontSizeMethod;
        }
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
