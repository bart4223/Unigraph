package Unigraph.Base;

public class NGUGDiagramObjectEvent extends NGUGDiagramEvent {

    protected NGUGCustomDiagramObject FDiagramObject;

    public NGUGDiagramObjectEvent(Object source, NGUGCustomDiagramObject aDiagramObject) {
        super(source);
        FDiagramObject = aDiagramObject;
    }

    public NGUGCustomDiagramObject getDiagramObject() {
        return FDiagramObject;
    }

}
