package Unigraph.Base;

public interface NGUGDiagramEventListener {

    void handleObjectAdded(NGUGDiagramObjectEvent e);
    void handleObjectSelectionChanged(NGUGDiagramObjectEvent e);
    void handleLinkAdded(NGUGDiagramLinkEvent e);

}
