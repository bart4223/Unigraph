package Unigraph;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Objects.*;
import Unigraph.Visuals.*;

public interface NGUnigraph2DAPI {

    // Common
    void Refresh();
    void Refresh(NGUG2DDiagramLayer aDiagramLayer);

    // Layers
    NGUG2DDiagramLayer addLayer(String aName, Integer ZOrder, Double aOpacity);

    // Objects
    NGUGBoxDiagramObject addBox(String aName);
    NGUGBoxDiagramObject addBox(String aName, Object aReference);
    NGUG2DBoxDiagramObjectLayout addBoxLayout(NGUGBoxDiagramObject aBoxObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);
    NGUGClassDiagramObject addClass(String aName);
    NGUGClassDiagramObject addClass(String aName, Object aReference);
    NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aClassObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);
    NGUGTableDiagramObject addTable(String aName);
    NGUGTableDiagramObject addTable(String aName, Object aReference);
    NGUG2DTableDiagramObjectLayout addTableLayout(NGUGTableDiagramObject aTableObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight);

    // Links
    NGUGSimpleDiagramLink addSimpleLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject);
    NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink);
    NGUGLabeledDiagramLink addLabeledLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject, String aName);
    NGUG2DLabeledDiagramLinkLayout addLabeledLinkLayout(NGUGLabeledDiagramLink aDiagramLink, Integer aWidth, Integer aHeight);

}
