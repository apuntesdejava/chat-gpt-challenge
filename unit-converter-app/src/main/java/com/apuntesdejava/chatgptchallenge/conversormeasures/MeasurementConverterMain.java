package com.apuntesdejava.chatgptchallenge.conversormeasures;

import java.util.ArrayList;
import java.util.List;

public class MeasurementConverterMain {

    List<String> options = new ArrayList<>(UnitOfMeasurementConverter.getCategories());

    public static void main(String[] args) {
        new MeasurementConverterMain().start();

    }

    private void start() {
        int selectedOption;
        do {
            selectedOption = showMenu();

            if (selectedOption >= 0) {
                showInputScreen(selectedOption);
            }
        } while (selectedOption >= 0);
    }

    private int showMenu() {
        System.out.println("CONVERTIDOR DE UNIDADES");

        int optIdx = 0;
        for (String option : options) {
            System.out.printf("%d. %s\n", ++optIdx, option);
        }
        System.out.printf("%d. Salir\n", ++optIdx);

        int optionInputNumber = 0;
        do {
            var optionInputString =
                System.console().readLine("Seleccione una categoría de unidades:");
            optionInputNumber = Integer.parseInt(optionInputString);
            if (optionInputNumber == optIdx) {
                return -1;
            }

        } while (optionInputNumber > optIdx);
        return optionInputNumber - 1;

    }

    private void showInputScreen(int selectedOption) {
        var categorySelected = options.get(selectedOption);
        System.out.println("-------------------");
        System.out.printf("Seleccione la unidad de medida origen para %s :%n", categorySelected);
        List<String> measuresSource =
            new ArrayList<>(UnitOfMeasurementConverter.getMeasuresByCategory(categorySelected));
        int idxOpt = 0;
        for (String measureSource : measuresSource) {
            System.out.printf("%d. %s%n", ++idxOpt, measureSource);
        }
        var measureSourceIdx = getOptionNumber(idxOpt, "Seleccione:");
        var measureSource = measuresSource.get(measureSourceIdx - 1);

        List<String> measuresTarget = new ArrayList<>(
            UnitOfMeasurementConverter.getTargetMeasuresByCategoryAndMeasureSource(categorySelected,
                                                                                   measureSource));
        idxOpt = 0;
        for (String measureTarget : measuresTarget) {
            System.out.printf("%d. %s%n", ++idxOpt, measureTarget);
        }
        var measureTargetIdx = getOptionNumber(idxOpt, "Seleccione la unidad de medidad destino:");
        var measureTarget = measuresTarget.get(measureTargetIdx - 1);

        var value = System.console().readLine("Escriba la cantidad a convertir:");
        var valueFloat = Float.parseFloat(value);

        var valueConverted =
            UnitOfMeasurementConverter.convert(categorySelected, measureSource, measureTarget,
                                               valueFloat);

        System.out.printf("%.2f %s es igual a %.2f %s%n", valueFloat, measureSource, valueConverted,
                          measureTarget);

        System.out.println("------------");
    }

    private static int getOptionNumber(int maxOption, String prompt) {
        int inputNumber;
        do {
            var inputString = System.console().readLine(prompt);
            inputNumber = Integer.parseInt(inputString);
        } while (inputNumber > maxOption);
        return inputNumber;
    }

}
