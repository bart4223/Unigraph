package Unigraph.Base;

public interface NGUGDiagramLayoutEventListener {

    void handleObjectLayoutAdded(NGUGDiagramObjectLayoutEvent e);
    void handleObjectLayoutChanged(NGUGDiagramObjectLayoutEvent e);
    void handleLinkLayoutAdded(NGUGDiagramLinkLayoutEvent e);

}
