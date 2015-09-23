package Unigraph.Base;

public class NGUGDiagramObjectLayoutEvent extends NGUGDiagramEvent {

    protected NGUGCustomDiagramObjectLayout FDiagramObjectLayout;

    public NGUGDiagramObjectLayoutEvent(Object source, NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        super(source);
        FDiagramObjectLayout = aDiagramObjectLayout;
    }

    public NGUGCustomDiagramObjectLayout getDiagramObjectLayout() {
        return FDiagramObjectLayout;
    }

}
