package app.controllers.admin;

import app.repository.entity.Stable;
import app.services.StableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;;

@Controller
public class EditorStablesController {

    @Autowired
    private StableService service;

    @GetMapping("/admin/stables")
    public String view(Model model){
        model.addAttribute("stables", service.findAll());
        return "/admin/stable/index";
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
        Stable stable = service.findById(id);
        model.addAttribute("stable", stable);
        return "/admin/stable/edit";
    }

    @GetMapping("/admin/stable/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "/admin/stables";
    }
}
