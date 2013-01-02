package view;


import model.DFileUtils;
import model.DStringUtils;
import model.DHttp;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


import java.util.List;



public class TextDownloader extends Form {

	/**
	 * @param args
	 */
	public static void show() {

		Display display = getDisplay();
		
		Shell shell = new Shell(display);
		shell.setText("My first java SWT Downloader");
		shell.setSize(500, 500);
		
		Label label = new Label (shell, SWT.NONE);
		label.setText ("Enter page address:");
		final Text text = new Text (shell, SWT.BORDER);
		text.setLayoutData (new GridData (300, SWT.DEFAULT));
		
		Label tagFromLabel = new Label (shell, SWT.NONE);
		tagFromLabel.setText ("tag from:");
		final Text tagFromText = new Text (shell, SWT.BORDER);
		tagFromText.setLayoutData (new GridData (300, SWT.DEFAULT));
		
		Label tagToLabel = new Label (shell, SWT.NONE);
		tagToLabel.setText ("tag to:");
		final Text tagToText = new Text (shell, SWT.BORDER);
		tagToText.setLayoutData (new GridData (300, SWT.DEFAULT));
		
		
		text.setText("http://bash.org.pl/latest/?page=1");
		tagFromText.setText("&lt;");
		tagToText.setText("&gt;");
		
		Button ok = new Button (shell, SWT.PUSH);
		ok.setText ("OK");
		

		setCentralized(shell);
		
	    // Create a multiple-line text field
	    final Text t = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    t.setLayoutData(new GridData(GridData.FILL_BOTH));
	    t.setSize(300, 500);
	   
		ok.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent e) {
				DHttp Dh = new DHttp();
				String content = new String();
				DFileUtils fu = new DFileUtils();
				DStringUtils su = new DStringUtils();

				content = Dh.getUrl(text.getText());
				fu.writeTextFile(content, "pageContent.txt");
				t.setText("Page content written into file 'pageContent.txt' ");
				
				List<String> wordList  = su.getContentBetweenTags(content, tagFromText.getText(), tagToText.getText()); 
				
				for (String el: wordList) {
				t.append("\n"+el);
				}
				
			}
		});
		
		shell.setLayout (new GridLayout ());
		//shell.pack ();
		
		
		shell.open();
		while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
		}
		//display.dispose();
	}

}
