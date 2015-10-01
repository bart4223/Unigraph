package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramLink;
import Unigraph.Objects.NGUGSimpleDiagramLink;

public class NGUG2DSimpleDiagramLinkLayout extends NGUG2DDiagramLinkLayout {

    public NGUG2DSimpleDiagramLinkLayout(NGUG2DDiagramLayoutManager aLayoutManager, NGUGCustomDiagramLink aDiagramLink) {
        super(aLayoutManager, aDiagramLink);
    }

    NGUGSimpleDiagramLink getSimpleDiagramLink() {
        return (NGUGSimpleDiagramLink)FDiagramLink;
    }

}
