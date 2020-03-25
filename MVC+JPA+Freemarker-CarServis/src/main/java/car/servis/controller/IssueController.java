package car.servis.controller;

import car.servis.model.RecordRange;
import car.servis.servis.IssueForm;
import car.servis.servis.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/issue")
public class IssueController {

    private IssuesService issuesService;

    //injection in constructor to inject all beans in one place
    @Autowired
    public IssueController(IssuesService issuesService) {
        this.issuesService = issuesService;
    }


    @GetMapping("/")
    public String getIssue(@RequestParam(name = "Range", required = false) RecordRange range, Model model){
        if (range == null){
            model.addAttribute("issues", issuesService.listIssues());
            model.addAttribute("from", 0);
            model.addAttribute("to", "end");

        } else {
            model.addAttribute("issues", issuesService.listIssues().subList(range.getFrom(),range.getTo()));
            model.addAttribute("from", range.getFrom());
            model.addAttribute("to", range.getTo());
        }
        return "issueList";
    }

    @GetMapping("/add")
    public String addIssue(Model model){
        model.addAttribute("issueForm",new IssueForm());
        return "addissue";
    }

    @PostMapping("/add")
    public String saveIssue(@Valid IssueForm issueForm, BindingResult bindingResult , Model model){
        if(!bindingResult.hasErrors()){
            model.addAttribute("issueForm", issueForm);
            issuesService.addIssue(issueForm);
            model.addAttribute("noErrors", true);
        }
        return "addissue";
    }


    @GetMapping("/{idVariable}")
    public String home(@PathVariable(name = "idVariable") String idVariable , Model model){
        model.addAttribute("idVariable", idVariable);
        return "home";
    }



}
