package Unigraph;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Objects.NGUGBoxDiagramObject;
import Unigraph.Objects.NGUGClassDiagramObject;
import Unigraph.Objects.NGUGSimpleDiagramLink;
import Unigraph.Objects.NGUGTableDiagramObject;
import Unigraph.Visuals.*;

public interface NGUnigraph2DAPI {

    // Layers
    NGUG2DDiagramLayer addLayer(String aName, Integer ZOrder);

    // Objects
    NGUGBoxDiagramObject addBox(String aName, Object aReference);
    NGUG2DBoxDiagramObjectLayout addBoxLayout(NGUGBoxDiagramObject aBoxObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);
    NGUGClassDiagramObject addClass(String aName, Object aReference);
    NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aClassObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);
    NGUGTableDiagramObject addTable(String aName, Object aReference);
    NGUG2DTableDiagramObjectLayout addTableLayout(NGUGTableDiagramObject aTableObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);

    // Links
    NGUGSimpleDiagramLink addSimpleLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject);
    NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink);

}
