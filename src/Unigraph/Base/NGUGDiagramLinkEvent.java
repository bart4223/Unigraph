package Unigraph.Base;

public class NGUGDiagramLinkEvent extends NGUGDiagramEvent {

    protected NGUGCustomDiagramLink FDiagramLink;

    public NGUGDiagramLinkEvent(Object source, NGUGCustomDiagramLink aDiagramLink) {
        super(source);
        FDiagramLink = aDiagramLink;
    }

    public NGUGCustomDiagramLink getDiagramLink() {
        return FDiagramLink;
    }

}
