package editorframework;

import editorframework.interfaces.IDocument;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.ISerializer;

public class DocumentController implements IDocumentController {
    
    @Override
    public void setSerializer(ISerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public IDocument openDocument(String fileName) {
        if (serializer != null)
            return serializer.openDocument(fileName);
        return null;
    }
    private ISerializer serializer;
}
