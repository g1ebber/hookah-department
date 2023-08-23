package com.glebber.hookahdepartment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.glebber.hookahdepartment.Ingredient.Type;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("hookahOrder")
public class HookahOrderController {
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("VRDS", "Overdose", Type.TOBACCO),
                new Ingredient("DKSD", "Darkside", Type.TOBACCO),
                new Ingredient("L", "Low", Type.BOWL),
                new Ingredient("M", "Medium", Type.BOWL),
                new Ingredient("B", "Big", Type.BOWL),
                new Ingredient("STND", "Standard", Type.COAL),
                new Ingredient("DFLT", "Default", Type.HOOKAH)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "hookahOrder")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "hookahBuild")
    public HookahBuild hookah() {
        return new HookahBuild();
    }
    @GetMapping
    public String showDesignForm() {
        return "DesignHookah";
    }
    @PostMapping
    public String processHookah(HookahBuild hookahBuild,
                                @ModelAttribute Order order) {
        order.addHookahBuild(hookahBuild);
        log.info("Processing hookah: {}", hookahBuild);
        return "redirect:/orders/current";
    }
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
