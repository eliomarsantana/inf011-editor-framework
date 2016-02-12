package editorframework;

import editorframework.interfaces.Editor;
import javax.swing.JComponent;
import javax.swing.JTextArea;

/**
 *
 * @author Eliomar Santana
 */
public class TextEditor extends Editor{
    
    @Override
    public JComponent getView() {
        JTextArea textArea = new JTextArea();
        for(String line : ((TextDocument)document).getData())
            textArea.append(line + '\n');
        return textArea;
    }
}
