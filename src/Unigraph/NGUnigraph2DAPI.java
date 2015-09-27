package Unigraph;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Objects.NGUGClassDiagramObject;
import Unigraph.Objects.NGUGSimpleDiagramLink;
import Unigraph.Objects.NGUGTableDiagramObject;
import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DDiagramLayer;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Unigraph.Visuals.NGUG2DTableDiagramObjectLayout;

public interface NGUnigraph2DAPI {

    // Layers
    NGUG2DDiagramLayer addLayer(String aName, Integer ZOrder);

    // Objects
    NGUGClassDiagramObject addClass(String aName, Object aReference);
    NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);
    NGUGTableDiagramObject addTable(String aName, Object aReference);
    NGUG2DTableDiagramObjectLayout addTableLayout(NGUGClassDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);

    // Links
    NGUGSimpleDiagramLink addSimpleLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject);
    NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink);

}
