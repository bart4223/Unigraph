package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

public class NGUG2DDiagramObjectLayout extends NGUGCustomDiagramObjectLayout {

    protected Integer FWidth;
    protected Integer FHeight;
    protected NGPoint2D FPosition;
    protected Color FLineColor;
    protected Color FObjectColor;
    protected NGUG2DDiagramLayer FDiagramLayer;
    protected NGUG2DDiagramLayoutManager FLayoutManager;

    public NGUG2DDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        super(aDiagramObject);
        FWidth = aWidth;
        FHeight = aHeight;
        FPosition = new NGPoint2D(0, 0);
        FLineColor = Color.BLACK;
        FObjectColor = Color.WHITE;
        FDiagramLayer = aDiagramLayer;
        FLayoutManager = FDiagramLayer.getLayoutManager();
    }

    protected NGUG2DDiagramLayoutManager getLayoutManager() {
        return FLayoutManager;
    }

    public NGUG2DDiagramLayer getDiagramLayer() {
        return FDiagramLayer;
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

    public void setLineColor(Color aLineColor) {
        FLineColor = aLineColor;
    }

    public Color getLineColor() {
        return FLineColor;
    }

    public void setObjectColor(Color aObjectColor) {
        FObjectColor = aObjectColor;
    }

    public Color getObjectColor() {
        return FObjectColor;
    }

    public String getDiagramLayerID() {
        return FDiagramLayer.getID();
    }

    public Integer getDiagramLayerZOrder() {
        return FDiagramLayer.getZOrder();
    }

    public Boolean Hit(NGPoint2D aPoint) {
        return (FPosition.getX() - getWidth() / 2 < aPoint.getX() && aPoint.getX() < FPosition.getX() + getWidth() / 2 && FPosition.getY() - getHeight() / 2 < aPoint.getY() && aPoint.getY() < FPosition.getY() + getHeight() / 2);
    }

}
