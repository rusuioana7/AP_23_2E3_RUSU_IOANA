package homework;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

//ReportCommand creates and opens an HTML report using Velocity
public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }


    @Override
    public void executeCommand() throws InvalidDocumentException, InvalidCatalogException {
        VelocityEngine velocityEngine = new VelocityEngine(); //new instance of VelocityEngine
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("reportbun.vm"); //loading the template
        VelocityContext context = new VelocityContext();//creating context - VelocityContext object
        List<Document> documents = catalog.getDocuments();
        context.put("documents", documents); // adding the list of documents into context
        StringWriter writer = new StringWriter();
        template.merge(context, writer); //merging template and context and writing the result in writer

        try {
            BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("catalog.html"));
            htmlWriter.write(writer.toString()); //writing the content of writer into an HTML file
            htmlWriter.close();
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("catalog.html")); //opening the HTML file
        } catch (IOException exception) {
            System.err.println("Error: HTML file");
        }
    }

}