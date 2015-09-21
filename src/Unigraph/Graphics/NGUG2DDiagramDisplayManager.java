package Unigraph.Graphics;

import Unigraph.Base.NGUGDiagramObjectManager;
import Unigraph.Visuals.NGUG2DDiagramObjectLayoutManager;
import Uniwork.Visuals.NGDisplayManager;
import javafx.scene.canvas.Canvas;

public class NGUG2DDiagramDisplayManager extends NGDisplayManager {

    @Override
    protected void DoBeforeRender() {
        super.DoBeforeRender();
        FGC.clearRect(FPosition.getXAsInt() * FPixelSize, FPosition.getYAsInt() * FPixelSize, FWidth, FHeight);
    }

    @Override
    protected void InternalRender() {
        super.InternalRender();
    }

    public NGUG2DDiagramDisplayManager(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DDiagramDisplayManager(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
        ObjectManager = null;
        ObjectLayoutManager = null;
    }

    public NGUGDiagramObjectManager ObjectManager;
    public NGUG2DDiagramObjectLayoutManager ObjectLayoutManager;

}
