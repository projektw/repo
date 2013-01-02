package view;


import model.DFileUtils;
import model.DStringUtils;
import model.DHttp;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


import java.util.List;



public class TextManualInuput extends Form {

	/**
	 * @param args
	 */
	public static void show() {

		Display display = getDisplay();
		
		Shell shell = new Shell(display);
		shell.setText("Text - Manual Input");
		shell.setSize(500, 500);
		
		Label label = new Label (shell, SWT.NONE);
		label.setText ("Enter page addresses:");
		
		
	    // Create a multiple-line text field
	    final Text t = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    t.setLayoutData(new GridData(GridData.FILL_BOTH));
	    t.setSize(300, 500);
	   
	    
		
		Label tagFromLabel = new Label (shell, SWT.NONE);
		tagFromLabel.setText ("tag from:");
		final Text tagFromText = new Text (shell, SWT.BORDER);
		tagFromText.setLayoutData (new GridData (300, SWT.DEFAULT));
		
		Label tagToLabel = new Label (shell, SWT.NONE);
		tagToLabel.setText ("tag to:");
		final Text tagToText = new Text (shell, SWT.BORDER);
		tagToText.setLayoutData (new GridData (300, SWT.DEFAULT));
		
		
		t.setText("http://www.ibm.com/us/en/\n");
		t.append("http://www-03.ibm.com/systems/z/news/announcement/20120828_announce.html\n");
		tagFromText.setText("<h3>");
		tagToText.setText("</h3>");
		
		Button ok = new Button (shell, SWT.PUSH);
		ok.setText ("OK");
		

		Label outputLabel = new Label (shell, SWT.NONE);
		outputLabel.setText ("Output:");
		
	    // Create a multiple-line text field
	    final Text out = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    out.setLayoutData(new GridData(GridData.FILL_BOTH));
	    out.setSize(300, 500);
		
		setCentralized(shell);
		

		ok.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent e) {
				DHttp Dh = new DHttp();
				String content = new String();
				DFileUtils fu = new DFileUtils();
				DStringUtils su = new DStringUtils();

				
				int i =0;
				int j = out.getText().length();
				
				while (out.getText(i,j).contains("\n"))
				{
			//		out.getText(start, end)
			//		content = Dh.getUrl(text.getText());
					fu.writeTextFile(content, "pageContentManual.txt");
					out.setText("Page content written into file 'pageContent.txt' ");
					
					List<String> wordList  = su.getContentBetweenTags(content, tagFromText.getText(), tagToText.getText()); 
					
					for (String el: wordList) {
					out.append("\n"+el);
					}
					
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
