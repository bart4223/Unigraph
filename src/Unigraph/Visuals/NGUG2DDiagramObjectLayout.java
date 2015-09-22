package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

public class NGUG2DDiagramObjectLayout extends NGUGCustomDiagramObjectLayout {

    protected Integer FWidth;
    protected Integer FHeight;
    protected NGPoint2D FPosition;
    protected Integer FZOrder;
    protected Color FLineColor;

    public NGUG2DDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, Integer aWidth, Integer aHeight) {
        super(aDiagramObject);
        FWidth = aWidth;
        FHeight = aHeight;
        FPosition = new NGPoint2D(0, 0);
        FZOrder = 0;
        FLineColor = Color.BLACK;
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

    public void setLineColor(Color aLineColor) {
        FLineColor = aLineColor;
    }

    public Color getLineColor() {
        return FLineColor;
    }

}
