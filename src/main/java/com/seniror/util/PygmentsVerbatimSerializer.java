package com.seniror.util;

import org.pegdown.Printer;
import org.pegdown.VerbatimSerializer;
import org.pegdown.ast.VerbatimNode;
import org.python.util.PythonInterpreter;

public class PygmentsVerbatimSerializer implements VerbatimSerializer {
    public static final PygmentsVerbatimSerializer INSTANCE = new PygmentsVerbatimSerializer();

    @Override
    public void serialize(final VerbatimNode node, final Printer printer) {
        printer.print(highlight(node.getText()));
    }
    
    public String highlight(String content) {
    	
		try(PythonInterpreter interpreter = new PythonInterpreter();) {
	        // Set a variable with the content you want to work with
	        interpreter.set("code", content);

	        // Simple use Pygments as you would in Python
	        interpreter.exec("from pygments import highlight\n"
	            + "from pygments.lexers import PythonLexer\n"
	            + "from pygments.formatters import HtmlFormatter\n"
	            + "\nresult = highlight(code, PythonLexer(), HtmlFormatter())");

	        return interpreter.get("result", String.class);
		} catch (Exception e) {
			// TODO: log the exception
		}

		return "ERROR_PARSE_SOURCE";
    }
}