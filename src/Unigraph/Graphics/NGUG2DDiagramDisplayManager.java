package Unigraph.Graphics;

import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DDiagramObjectLayoutManager;
import Uniwork.Visuals.NGDisplayController;
import Uniwork.Visuals.NGDisplayManager;
import javafx.scene.canvas.Canvas;

import java.util.Iterator;

public class NGUG2DDiagramDisplayManager extends NGDisplayManager {

    protected void CreateDiagramDisplayController() {
        NGDisplayController dc = new NGUG2DClassObjectDisplayController(FCanvas);
        addController(dc);
        dc = new NGUG2DTableObjectDisplayController(FCanvas);
        addController(dc);
    }

    @Override
    protected void DoBeforeRender() {
        super.DoBeforeRender();
        FGC.clearRect(FPosition.getXAsInt() * FPixelSize, FPosition.getYAsInt() * FPixelSize, FWidth, FHeight);
    }

    protected NGDisplayController getDiagramDisplayController(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        for (NGDisplayController dc : FControllers) {
            if (dc instanceof NGUGDiagramDisplayController) {
                NGUGDiagramDisplayController ddc = (NGUGDiagramDisplayController)dc;
                if (ddc.SupportLayoutClass(aDiagramObjectLayout.getClass()))
                    return dc;
            }
        }
        return null;
    }

    @Override
    protected void InternalRender() {
        Iterator<NGUGCustomDiagramObjectLayout> itr = ObjectLayoutManager.getObjectLayouts();
        while (itr.hasNext()) {
            setCurrentController(getDiagramDisplayController(itr.next()));
            super.InternalRender();
        }
    }

    public NGUG2DDiagramDisplayManager(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DDiagramDisplayManager(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
        CreateDiagramDisplayController();
        ObjectLayoutManager = null;
    }

    public NGUG2DDiagramObjectLayoutManager ObjectLayoutManager;

}
