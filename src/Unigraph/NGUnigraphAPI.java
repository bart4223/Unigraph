package Unigraph;

import Unigraph.Objects.NGUGClassDiagramObject;
import Unigraph.Objects.NGUGSimpleDiagramLink;
import Unigraph.Objects.NGUGTableDiagramObject;
import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Unigraph.Visuals.NGUG2DTableDiagramObjectLayout;

public interface NGUnigraphAPI {

    // Objects
    NGUGClassDiagramObject addClass(String aName, Object aReference);
    NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aDiagramObject, Integer aWidth, Integer aHeight);
    NGUGTableDiagramObject addTable(String aName, Object aReference);
    NGUG2DTableDiagramObjectLayout addTableLayout(NGUGClassDiagramObject aDiagramObject, Integer aWidth, Integer aHeight);
    // Links
    NGUGSimpleDiagramLink addSimpleLink(String aFromID, String aToID);
    NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink);

}
