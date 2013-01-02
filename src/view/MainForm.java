package view;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;




public class MainForm extends Form{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Display display = getDisplay();
		
		Shell shell = new Shell(display);
		shell.setText("Choose a way to download page content");
		shell.setSize(500,265);
		shell.setLayout (new GridLayout ());
		
		Button textButton = new Button (shell, SWT.PUSH);
		textButton.setText ("Text");
		textButton.setLayoutData(new GridData (475,50));

	   
		Button imageButton = new Button (shell, SWT.PUSH);
		imageButton.setText ("Image");
		imageButton.setLayoutData(new GridData (475,50));
		
		Button videoButton = new Button (shell, SWT.PUSH);
		videoButton.setText ("Image");
		videoButton.setLayoutData(new GridData (475,50));
		
		Button otherButton = new Button (shell, SWT.PUSH);
		otherButton.setText ("Other");
		otherButton.setLayoutData(new GridData (475,50));
	   
		shell.setDefaultButton(textButton);
		 
		textButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent e) {
				
				TextSelector.show();				
			}
		});
		
		imageButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent e) {
				
				ImageSelector.show();				
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
