package view;


import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public abstract class Form {

	
	   public static Display getDisplay() {
		      Display display = Display.getCurrent();
		      //may be null if outside the UI thread
		      if (display == null)
		         display = Display.getDefault();
		      return display;		
		   }
	   
	   
		public static void setCentralized(Shell shell) {
		
		    Monitor primary = getDisplay().getPrimaryMonitor();
		    Rectangle bounds = primary.getBounds();
		    Rectangle rect = shell.getBounds();
	  		//getDisplay().getShells()
		    int x = bounds.x + (bounds.width - rect.width) / 2;
		    int y = bounds.y + (bounds.height - rect.height) / 2;
		    shell.setLocation(x, y);
		}
}
