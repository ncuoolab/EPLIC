package eplic.core.breakpoint;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jdt.debug.core.JDIDebugModel;
/**
 * EPLIC - A Tool to Assist Locating Interested Code.
 * Copyright (C) 2013 Frank Wang <eternnoir@gmail.com>
 * 
 * This file is part of EPLIC.
 * 
 * Java breakpoint setter
 * 
 * @see IBreakpointSetter
 * @author FrankWang
 *
 */
public class JavaBreakpointSetter implements IBreakpointSetter {
	private static JavaBreakpointSetter instance = null;

	public JavaBreakpointSetter(){

	}
	/**
	 * set breakpoint at line number in file(resource)
	 * 
	 */
	@Override
	public void setBreakpoint(IResource resource,int lineNum){
		String typeName = FileParaviserUtils.getClassName(resource);	//javabreakpoint need this
		try {
			IBreakpoint bp = JDIDebugModel.createLineBreakpoint(resource,typeName, lineNum+1, -1, -1, 0,true,null);
			BreakpointManager.getInstance().addBreakpointSet(bp, resource);
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(bp);
			System.out.print("setBreakpoint at "+typeName+":"+lineNum+"\n");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}