package com.apuntesdejava.chatgptchallenge.conversormeasures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitOfMeasurementConverterTest {

    public UnitOfMeasurementConverterTest() {
    }

    /**
     * Test of convert method, of class UnitOfMeasurementConverter.
     */
    @org.junit.jupiter.api.Test
    public void testConvertLongitudMetrosMillas() {
        System.out.println("convert");
        String category = "LONGITUD";
        String source = "METROS";
        String target = "MILLAS";
        float measure = 10000.0F;
        float expResult = 6.2137F;
        float result = UnitOfMeasurementConverter.convert(category, source, target, measure);
        assertEquals(expResult, result, 0);
    }

    @org.junit.jupiter.api.Test
    public void testConvertPesosKilosOnzas() {
        System.out.println("pesos");
        String category = "PESOS";
        String source = "ONZA";
        String target = "KILOS";
        float measure = 10.0F;
        float expResult = 0.283495F;
        float result = UnitOfMeasurementConverter.convert(category, source, target, measure);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void getCategoriesTest() {
        var categories = UnitOfMeasurementConverter.getCategories();
        assertFalse(categories.isEmpty());
        System.out.println("categories:" + categories);
    }

    @Test
    public void getMeasuresByCategoryTest() {
        var longitudes = UnitOfMeasurementConverter.getMeasuresByCategory("LONGITUD");
        assertFalse(longitudes.isEmpty());
        System.out.println("longitudes:" + longitudes);
    }

    @Test
    public void getTargetMeasuresByCategoryAndMeasureSourceTest() {
        var measures =
            UnitOfMeasurementConverter.getTargetMeasuresByCategoryAndMeasureSource("LONGITUD",
                                                                                   "PIES");
        assertFalse(measures.isEmpty());
        System.out.println("medidas:" + measures);
    }

}
