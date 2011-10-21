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
package org.deegree.ogcwebservices.getcapabilities;

import java.io.Serializable;

import org.deegree.ogcwebservices.ExceptionFormat;

/**
 * @version $Revision$
 * @author <a href="mailto:poth@lat-lon.de">Andreas Poth</a>
 * @author last edited by: $Author$
 *
 * @version 1.0. $Revision$, $Date$
 *
 * @since 2.0
 */

public class Capability implements Serializable {

    private static final long serialVersionUID = 5019339214302903751L;

    private String version = null;

    private String updateSequence = null;

    private OperationsMetadata operations = null;

    private ExceptionFormat exception = null;

    private Object vendorSpecificCapabilities = null;

    /**
     * @param operations
     * @param exception
     * @param vendorSpecificCapabilities
     */
    public Capability( OperationsMetadata operations, ExceptionFormat exception, Object vendorSpecificCapabilities ) {
        this.operations = operations;
        this.exception = exception;
        this.vendorSpecificCapabilities = vendorSpecificCapabilities;
    }

    /**
     * @param version
     * @param updateSequence
     * @param operations
     * @param exception
     * @param vendorSpecificCapabilities
     */
    public Capability( String version, String updateSequence, OperationsMetadata operations, ExceptionFormat exception,
                       Object vendorSpecificCapabilities ) {
        this.version = version;
        this.updateSequence = updateSequence;
        this.operations = operations;
        this.exception = exception;
        this.vendorSpecificCapabilities = vendorSpecificCapabilities;
    }

    /**
     * @return Returns the exception.
     *
     */
    public ExceptionFormat getException() {
        return exception;
    }

    /**
     * @param exception
     *            The exception to set.
     *
     */
    public void setException( ExceptionFormat exception ) {
        this.exception = exception;
    }

    /**
     * @return Returns the request.
     *
     */
    public OperationsMetadata getOperations() {
        return operations;
    }

    /**
     * @param operations
     *            operations supported by a service
     *
     */
    public void setOperations( OperationsMetadata operations ) {
        this.operations = operations;
    }

    /**
     * @return Returns the updateSequence.
     *
     */
    public String getUpdateSequence() {
        return updateSequence;
    }

    /**
     * @param updateSequence
     *            The updateSequence to set.
     *
     */
    public void setUpdateSequence( String updateSequence ) {
        this.updateSequence = updateSequence;
    }

    /**
     * @return Returns the vendorSpecificCapabilities.
     *
     */
    public Object getVendorSpecificCapabilities() {
        return vendorSpecificCapabilities;
    }

    /**
     * @param vendorSpecificCapabilities
     *            The vendorSpecificCapabilities to set.
     *
     */
    public void setVendorSpecificCapabilities( Object vendorSpecificCapabilities ) {
        this.vendorSpecificCapabilities = vendorSpecificCapabilities;
    }

    /**
     * @return Returns the version.
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     *            The version to set.
     *
     */
    public void setVersion( String version ) {
        this.version = version;
    }

}
