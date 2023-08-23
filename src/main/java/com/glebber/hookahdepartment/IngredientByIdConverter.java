package com.glebber.hookahdepartment;

import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.glebber.hookahdepartment.Ingredient;
import com.glebber.hookahdepartment.Ingredient.Type;
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();
    public IngredientByIdConverter() {
        ingredientMap.put("VRDS",
                new Ingredient("VRDS", "Overdose", Type.TOBACCO));
        ingredientMap.put("DKSD",
                new Ingredient("DKSD", "Darkside", Type.TOBACCO));
        ingredientMap.put("L",
                new Ingredient("L", "Low", Type.BOWL));
        ingredientMap.put("M",
                new Ingredient("M", "Medium", Type.BOWL));
        ingredientMap.put("B",
                new Ingredient("B", "Big", Type.BOWL));
        ingredientMap.put("STND",
                new Ingredient("STND", "Standard", Type.COAL));
        ingredientMap.put("DFLT",
                new Ingredient("DFLT", "Default", Type.HOOKAH));
    }
    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}