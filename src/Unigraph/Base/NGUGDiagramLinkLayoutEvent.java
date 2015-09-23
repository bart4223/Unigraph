package Unigraph.Base;

public class NGUGDiagramLinkLayoutEvent extends NGUGDiagramEvent {

    protected NGUGCustomDiagramLinkLayout FDiagramLinkLayout;

    public NGUGDiagramLinkLayoutEvent(Object source, NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {
        super(source);
        FDiagramLinkLayout = aDiagramLinkLayout;
    }

    public NGUGCustomDiagramLinkLayout getDiagramLinkLayout() {
        return FDiagramLinkLayout;
    }

}
