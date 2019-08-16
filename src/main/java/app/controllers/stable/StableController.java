package app.controllers.stable;


import app.repository.entity.Stable;
import app.services.StableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StableController {

    @Autowired
    private StableService service;


    @GetMapping("/stable/{id}")
    public String view(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("stable", service.findById(id));
        return "/stable/index";
    }


    @PostMapping("/stable/edit")
    public String edit(Stable stable){
        service.edit(stable);
        return "redirect:/stable/"+stable.getId();
    }

    @GetMapping("/stable/edit/{id}")
    public String editView(@PathVariable(name = "id") Long id, Model model){
        Stable stable = service.findById(id);
        model.addAttribute("stable", stable);
        return "/stable/edit";
    }

}
