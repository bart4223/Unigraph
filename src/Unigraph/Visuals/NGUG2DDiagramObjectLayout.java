package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Uniwork.Graphics.NGPoint2D;

public class NGUG2DDiagramObjectLayout extends NGUGCustomDiagramObjectLayout {

    public Integer FWidth;
    public Integer FHeight;
    public NGPoint2D FPosition;
    public Integer FZOrder;

    public NGUG2DDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, Integer aWidth, Integer aHeight) {
        super(aDiagramObject);
        FWidth = aWidth;
        FHeight = aHeight;
        FPosition = new NGPoint2D(0, 0);
        FZOrder = 0;
    }

    public Integer getWidth() {
        return FWidth;
    }

    public Integer getHeight() {
        return FHeight;
    }

    public void setPosition(Double aX, Double aY) {
        FPosition.setX(aX);
        FPosition.setY(aY);
    }

    public NGPoint2D getPosition() {
        return FPosition;
    }

    public void setZOrder(Integer aZOrder) {
        FZOrder = aZOrder;
    }

    public Integer getZOrder() {
        return FZOrder;
    }

}
