package view;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;





public class ImageSelector extends Form {

	/**
	 * @param args
	 */
	public static void show() {

		Display display = getDisplay();
		
		Shell shell = new Shell(display);
		shell.setText("Select dowload Method");
		shell.setSize(500,265);
		shell.setLayout (new GridLayout ());
		
		Button incButton = new Button (shell, SWT.PUSH);
		incButton.setText ("Incremental");
		incButton.setLayoutData(new GridData (475,50));
	   
//		Button manualButton = new Button (shell, SWT.PUSH);
//		manualButton.setText ("Manual");
//		manualButton.setLayoutData(new GridData (475,50));
		
		Button advancedButton = new Button (shell, SWT.PUSH);
		advancedButton.setText ("Advanced");
		advancedButton.setLayoutData(new GridData (475,50));
		
//		Button otherButton = new Button (shell, SWT.PUSH);
//		otherButton.setText ("Other");
//		otherButton.setLayoutData(new GridData (475,50));
	   
		shell.setDefaultButton(incButton);
		 
		incButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent e) {
				
				TextDownloader.show();				
			}
		});
		
		
		
		setCentralized(shell);
	
		shell.open();
		while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

}
