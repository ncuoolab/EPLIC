package eplic.core.breakpoint;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaLineBreakpoint;

/**
 * EPLIC - A Tool to Assist Locating Interested Code.
 * Copyright (C) 2013 Frank Wang <eternnoir@gmail.com>
 * 
 * This file is part of EPLIC.
 * 
 * @author FrankWang
 *
 */

public class pcplBreakpoint extends JavaLineBreakpoint {

	public pcplBreakpoint(IResource resource) throws DebugException, CoreException {
	    IMarker marker;

			marker = resource.createMarker(
			         "org.eclipse.debug.core.breakpointMarker");
	        setMarker(marker);
	        setEnabled(true);
			ensureMarker().setAttribute(IMarker.LINE_NUMBER, 12);
			ensureMarker().setAttribute(IBreakpoint.ID, "Debug");
			Map<String,Object> m = new HashMap<String,Object>();
			/*
			 * IBreakpoint.ENABLED
				IMarker.LINE_NUMBER
				IMarker.CHAR_START
				IMarker.CHAR_END
			 * 
			 */
			m.put(IBreakpoint.ID, 1);
			m.put(IMarker.LINE_NUMBER, 5);
			m.put(IMarker.CHAR_START, 0);
			m.put(IMarker.CHAR_END, 10);
			
			this.addLineBreakpointAttributes(m, "Debug", true, 5, 0, 10);
	}
}
