package com.apuntesdejava.chatgptchallenge.conversormeasures;

import java.util.Map;
import java.util.Set;

public class UnitOfMeasurementConverter {

    private static final Map<String, Map<String, Map<String, Float>>> MEASUREMENT_UNITS =
        Map.of("LONGITUD",
               Map.of("METROS", Map.of("PULGADAS", 39.37F, "MILLAS", 6.2137E-4F, "PIES", 3.2808F),
                      "PULGADAS", Map.of("METROS", 0.0254F, "MILLAS", 1.578E-5F, "PIES", 0.0833F),
                      "MILLAS", Map.of("METROS", 1609.34F, "PULGADAS", 63.36F, "PIES", 5.28F),
                      "PIES", Map.of("METROS", 0.3048F, "PULGADAS", 12.0F, "MILLAS", 1.8939E-4F)),
               "PESOS", Map.of("KILOS", Map.of("LIBRA", 2.20462F, "ONZA", 35.274F), "LIBRA",
                               Map.of("KILOS", 0.453592F, "ONZA", 16.0F), "ONZA",
                               Map.of("KILOS", 0.0283495F, "LIBRA", 0.0625F)));

    public static float convert(String category, String source, String target, float measure) {
        if (!MEASUREMENT_UNITS.containsKey(category)) {
            throw new IllegalArgumentException("No existe la categoria:" + category);
        }
        var measuresMap = MEASUREMENT_UNITS.get(category);
        var measuresSources = measuresMap.get(source);
        var measuresTarget = measuresSources.get(target);
        return measure * measuresTarget;
    }

    public static Set<String> getCategories() {
        return MEASUREMENT_UNITS.keySet();
    }

    public static Set<String> getMeasuresByCategory(String category) {
        if (!MEASUREMENT_UNITS.containsKey(category)) {
            throw new IllegalArgumentException("No existe la categoria:" + category);
        }
        return MEASUREMENT_UNITS.get(category).keySet();
    }

    public static Set<String> getTargetMeasuresByCategoryAndMeasureSource(String category,
                                                                          String measureSource) {
        if (!MEASUREMENT_UNITS.containsKey(category)) {
            throw new IllegalArgumentException("No existe la categoria:" + category);
        }
        var measuresMap = MEASUREMENT_UNITS.get(category);
        if (!measuresMap.containsKey(measureSource)) {
            throw new IllegalArgumentException(
                "No existe la unidad de medida origen:" + measureSource);
        }
        return measuresMap.get(measureSource).keySet();

    }

}
