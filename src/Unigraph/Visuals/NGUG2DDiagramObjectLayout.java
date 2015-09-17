package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Uniwork.Graphics.NGPoint2D;

public class NGUG2DDiagramObjectLayout extends NGUGCustomDiagramObjectLayout {

    public Integer FWidth;
    public Integer FHeight;
    public NGPoint2D FTopLeft;

    public NGUG2DDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, Integer aWidth, Integer aHeight) {
        super(aDiagramObject);
        FWidth = aWidth;
        FHeight = aHeight;
        FTopLeft = new NGPoint2D(0, 0);
    }

    public Integer getWidth() {
        return FWidth;
    }

    public Integer getHeight() {
        return FHeight;
    }

    public void setTopLeft(Double aX, Double aY) {
        FTopLeft.setX(aX);
        FTopLeft.setY(aY);
    }

    public NGPoint2D getTopLeft() {
        return FTopLeft;
    }

}
