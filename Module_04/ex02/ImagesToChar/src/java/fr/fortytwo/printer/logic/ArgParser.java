package fr.fortytwo.printer.logic;

import com.beust.jcommander.Parameter;

public class ArgParser {

    @Parameter(names = "--white=", description = "Character to represent white pixels", required = true)
    public String whiteColor;

    @Parameter(names = "--black=", description = "Character to represent black pixels", required = true)
    public String blackColor;

    @Parameter(names = "--help", help = true, description = "Display help")
    public boolean help = false;
}
