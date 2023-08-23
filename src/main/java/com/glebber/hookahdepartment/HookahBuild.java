package com.glebber.hookahdepartment;
import java.util.List;
import lombok.Data;
@Data
public class HookahBuild {
    private String name;
    private List<Ingredient> ingredients;
}