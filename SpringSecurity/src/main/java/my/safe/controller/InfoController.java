package my.safe.controller;


import my.safe.model.Info;
import my.safe.services.InfoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    InfoServices infoServices;

    public InfoController(InfoServices infoServices) {
        this.infoServices = infoServices;
    }

    @GetMapping
    public List<Info> getInfo() {
        return infoServices.getInformation();
    }

    @PostMapping
    public boolean addInfo(@RequestBody Info info) {
        return infoServices.addInformation(info);
    }

    @DeleteMapping
    public boolean deleteInfo(@RequestBody Info info) {
        return infoServices.deleteInformation(info);
    }

}
