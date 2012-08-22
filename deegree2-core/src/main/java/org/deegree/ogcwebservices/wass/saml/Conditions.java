//$HeadURL$
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

package org.deegree.ogcwebservices.wass.saml;

import java.util.ArrayList;
import java.util.Date;

/**
 * Encapsulated data: Conditions element
 *
 * Namespace: http://urn:oasis:names:tc.SAML:1.0:assertion
 *
 * @author <a href="mailto:bezema@lat-lon.de">Rutger Bezema</a>
 * @author last edited by: $Author$
 *
 * @version 2.0, $Revision$, $Date$
 *
 * @since 2.0
 */
public class Conditions {

    private ArrayList<Condition> conditions = new ArrayList<Condition>();

    private Date notBefore = null;

    private Date notOnOrAfter = null;

    /**
     * @param conditions
     * @param notBefore
     * @param notOnOrAfter
     */
    public Conditions( ArrayList<Condition> conditions, Date notBefore, Date notOnOrAfter ) {
        this.conditions = conditions;
        this.notBefore = notBefore;
        this.notOnOrAfter = notOnOrAfter;
    }

    /**
     * @return the date
     */
    public Date getNotBefore() {
        return notBefore;
    }

    /**
     * @return the date
     */
    public Date getNotOnOrAfter() {
        return notOnOrAfter;
    }

    /**
     * @return the condition list
     */
    public ArrayList<Condition> getConditions() {
        return conditions;
    }

}
