package app.controllers.admin;

import app.model.converters.DataConverter;
import app.model.dto.StableDto;
import app.repository.entity.Stable;
import app.services.StableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;;import java.util.LinkedList;
import java.util.List;

@Controller
public class EditorStablesController {

    @Autowired
    private StableService service;

    @Autowired
    @Qualifier("stableConverter")
    private DataConverter<Stable, StableDto> converter;

    @GetMapping("/admin/stables")
    public String view(Model model){
        List<Stable> list = service.findAll();
        if (!list.isEmpty() && list != null){
            model.addAttribute("stables", convertToStableDtoList(list));
        }
        return "/admin/stable/index";
    }

    private List<StableDto> convertToStableDtoList(List<Stable> list) {
        List<StableDto> stableDtoList = new LinkedList<>();
        for(Stable stable: list){
            stableDtoList.add(converter.toModel(stable));
        }
        return stableDtoList;
    }

    @GetMapping("/admin/stable/add")
    public String addView(){
        return "/admin/stable/add";
    }

    @PostMapping("/admin/stable/add")
    public String add(Stable stable){
        service.add(stable);
        return "redirect:/admin/stables";
    }

    @PostMapping("/admin/stable/edit")
    public String edit(Stable stable){
        service.edit(stable);
        return "redirect:/admin/stables";
    }

    @GetMapping("/admin/stable/edit/{id}")
    public String editView(@PathVariable(name = "id") Long id, Model model){
        StableDto stable = service.findById(id);
        model.addAttribute("stable", stable);
        return "/admin/stable/edit";
    }

    @GetMapping("/admin/stable/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/admin/stables";
    }
}
