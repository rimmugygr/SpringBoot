package car.servis.controller;

import car.servis.dto.RecordRange;
import car.servis.servis.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class IssueController {


    private IssuesService issuesService;
    //injection
    @Autowired
    public IssueController(IssuesService issuesService) {
        this.issuesService = issuesService;
    }


    @GetMapping("/")
    public String setIssue(@RequestParam(name = "Range") RecordRange range, Model model){
        model.addAttribute("issues", issuesService.listIssues().subList(range.getFrom(),range.getTo()));
        model.addAttribute("from", range.getFrom());
        model.addAttribute("to", range.getTo());
        return "issueList";
    }


    @GetMapping("/{idVariable}")
    public String home(@PathVariable(name = "idVariable") String idVariable , Model model){
        model.addAttribute("idVariable", idVariable);
        return "home";
    }



}
