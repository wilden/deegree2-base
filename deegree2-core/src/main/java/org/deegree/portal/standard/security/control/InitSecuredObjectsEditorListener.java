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
package org.deegree.portal.standard.security.control;

import org.deegree.enterprise.control.AbstractListener;
import org.deegree.enterprise.control.FormEvent;
import org.deegree.framework.log.ILogger;
import org.deegree.framework.log.LoggerFactory;
import org.deegree.i18n.Messages;
import org.deegree.security.GeneralSecurityException;
import org.deegree.security.drm.SecurityAccess;

/**
 * This <code>Listener</code> reacts on 'initSecuredObjectEditor' events and passes the
 * <code>SecuredObjects</code> (Layers / FeatureTypes) to be displayed on the JSP.
 *
 * Access constraints:
 * <ul>
 * <li>only users that have the 'SEC_ADMIN'-role are allowed</li>
 * </ul>
 *
 * @author <a href="mschneider@lat-lon.de">Markus Schneider </a>
 * @author last edited by: $Author$
 *
 * @version $Revision$, $Date$
 */
public class InitSecuredObjectsEditorListener extends AbstractListener {

    private static final ILogger LOG = LoggerFactory.getLogger( InitSecuredObjectsEditorListener.class );

    @Override
    public void actionPerformed( FormEvent event ) {

        try {
            // perform access check
            SecurityAccess access = SecurityHelper.acquireAccess( this );
            SecurityHelper.checkForAdminRole( access );

            // submit data objects for the JSP
            getRequest().setAttribute( ClientHelper.TYPE_LAYER,
                                       access.getAllSecuredObjects( ClientHelper.TYPE_LAYER ) );
            getRequest().setAttribute( ClientHelper.TYPE_FEATURETYPE,
                                       access.getAllSecuredObjects( ClientHelper.TYPE_FEATURETYPE ) );
        } catch ( GeneralSecurityException e ) {
            getRequest().setAttribute( "SOURCE", this.getClass().getName() );
            getRequest().setAttribute( "MESSAGE",
                                       Messages.getMessage( "IGEO_STD_SEC_FAIL_INIT_SECUREDOBJECTS_EDITOR",
                                                            e.getMessage() ) );
            setNextPage( "error.jsp" );
            LOG.logError( e.getMessage(), e );
        }

    }
}
