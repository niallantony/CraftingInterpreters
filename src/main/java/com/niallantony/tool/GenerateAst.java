package com.niallantony.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: generate_ast <output directory>");
            System.exit(64);
        }
        String outputDirectory = args[0];
        defineAst(outputDirectory, "Expr", Arrays.asList(
                "Binary     : Expr left, Token operator, Expr right",
                "Grouping   : Expr expression",
                "Literal    : Object value",
                "Unary      : Token operator, Expr right"
        ));
    }

    private static void defineAst(
            String outputDir, String basename, List<String> types)
        throws IOException {
        String path = outputDir + "/" + basename + ".java";
        PrintWriter writer = new PrintWriter(path, "utf-8");

        writer.println("package com.craftinginterpreters.lox;");
        writer.println();
        writer.println("import java.util.List;");
        writer.println("abstract class " + basename + " {");

        for (String type : types) {
            String className = type.split(":")[0].trim();
            String fields = type.split(":")[1].trim();
            defineType(writer, basename, className, fields);
        }

        writer.println("}");
        writer.println();

    }
}
