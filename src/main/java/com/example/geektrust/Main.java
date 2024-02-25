package com.example.geektrust;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.config.ApplicationConfig;
import com.example.geektrust.entities.InputCommand;
import com.example.geektrust.exception.ProcessingException;
import com.example.geektrust.utils.InputFileProcessing;
import com.example.geektrust.utils.InputFileProcessingImpl;
import com.example.geektrust.utils.InputValidator;
import com.example.geektrust.utils.InputValidatorImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new ProcessingException("Invalid input argument");
            }

            String inputFilePath = args[0];
            InputFileProcessing fileProcessing = new InputFileProcessingImpl();
            List<InputCommand> inputCommands = fileProcessing.readFile(inputFilePath);
            InputValidator inputValidator  = new InputValidatorImpl();

            ApplicationConfig applicationConfig = new ApplicationConfig();
            CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();

            for (InputCommand inputCommand : inputCommands) {
                // throws error if input command is not valid
                inputValidator.validateCommand(inputCommand);

                commandInvoker.executeCommand(inputCommand.getCommand(), inputCommand.getTokens());
            }
            
        } catch (ProcessingException e) {
            throw e;
        }
    }
}
