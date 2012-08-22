//$HeadURL: svn+ssh://developername@svn.wald.intevation.org/deegree/base/trunk/test/junit/org/deegree/io/datastore/schema/MappedGMLSchemaDocumentTest.java $
/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2009 by:
 Department of Geography, University of Bonn
 and
 lat/lon GmbH

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/

package org.deegree.io.datastore.schema;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import junit.framework.TestCase;

import org.deegree.datatypes.QualifiedName;
import org.deegree.framework.log.ILogger;
import org.deegree.framework.log.LoggerFactory;
import org.deegree.framework.xml.XMLParsingException;
import org.deegree.framework.xml.schema.XMLSchemaException;
import org.deegree.io.datastore.Datastore;
import org.deegree.model.crs.UnknownCRSException;
import org.deegree.model.feature.schema.FeatureType;

import alltests.Configuration;

public class MappedGMLSchemaDocumentTest extends TestCase {

    private static ILogger LOG = LoggerFactory.getLogger( MappedGMLSchemaDocumentTest.class );
    static {
        try {
            NAMESPACE = new URI( "http://www.deegree.org/app" );
        } catch ( URISyntaxException e ) {
            LOG.logError( "Invalid namespace URI: " + e.getMessage(), e );
        }
    }

    private static URI NAMESPACE;

    private static final QualifiedName PHILOSOPHER_NAME = new QualifiedName( "Philosopher", NAMESPACE );

    private static final QualifiedName BOOK_NAME = new QualifiedName( "Book", NAMESPACE );

    private static final QualifiedName PLACE_NAME = new QualifiedName( "Place", NAMESPACE );

    private static final QualifiedName COUNTRY_NAME = new QualifiedName( "Country", NAMESPACE );

    private static final String XSD_FILE = "wfs/demo/conf/featuretypes/example_featuretypes/philosopher/postgis/Philosopher.xsd";

    private MappedGMLSchemaDocument doc;

    protected void setUp()
                            throws Exception {
        super.setUp();
        URL inputURL = new URL( Configuration.getResourceDir(), XSD_FILE );
        doc = new MappedGMLSchemaDocument();
        doc.load( inputURL );
    }

    protected void tearDown()
                            throws Exception {
        super.tearDown();
    }

    public void testFeatureTypes()
                            throws XMLParsingException, XMLSchemaException, UnknownCRSException {
        MappedGMLSchema schema = doc.parseMappedGMLSchema();
        FeatureType[] featureTypes = schema.getFeatureTypes();
        assertNotNull( featureTypes );
        assertEquals( 4, featureTypes.length );

        FeatureType philosopher = schema.getFeatureType( PHILOSOPHER_NAME );
        assertNotNull( philosopher );

        FeatureType book = schema.getFeatureType( BOOK_NAME );
        assertNotNull( book );

        FeatureType place = schema.getFeatureType( PLACE_NAME );
        assertNotNull( place );

        FeatureType country = schema.getFeatureType( COUNTRY_NAME );
        assertNotNull( country );

        Datastore datastore = schema.getDatastore();
        assertNotNull( datastore );
    }
}

/***************************************************************************************************
 * <code>
 Changes to this class. What the people have been up to:

 $Log$
 Revision 1.11  2007/02/21 12:46:10  mschneider
 Adapted test to changes in Philosopher schema.

 Revision 1.10  2007/02/12 09:47:01  wanhoff
 added footer, corrected header

 </code>
 **************************************************************************************************/
