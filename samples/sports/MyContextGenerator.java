///////////////////////////////////////////////////////////////////////////////
// Copyright (C) 2001 Chieu Hai Leong and Jason Baldridge
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
//////////////////////////////////////////////////////////////////////////////   

import opennlp.maxent.*;
import gnu.regexp.*;
import java.util.*;

/**
 * Implements opennlp.maxent.ContextGenerator for the Weather sample.
 * Assumes a comma separated list of contextual predicates.
 *
 * @author  Chieu Hai Leong and Jason Baldridge
 * @version $Revision: 1.1 $, $Date: 2001/11/15 13:03:41 $
 */
public class MyContextGenerator implements ContextGenerator {

    public String[] getContext(Object o) {

	List collectFeats = new ArrayList();
	String[] toks = PerlHelp.split((String)o, ",");

	for(int i=0; i<toks.length; i++)
	    collectFeats.add(toks[i]);
	
	String[] context= new String[collectFeats.size()];
	collectFeats.toArray(context);
	return context;
    }
    
}