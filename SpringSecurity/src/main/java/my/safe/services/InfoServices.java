package my.safe.services;

import my.safe.model.Info;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServices {
    private final List<Info> infoList;

    public InfoServices() {
        infoList = new ArrayList<>();
        infoList.add(new Info("first", "content one"));
        infoList.add(new Info("second", "content second"));
        infoList.add(new Info("x", "xxx"));
    }

    public List<Info> getInformation() {
        return infoList;
    }

    public boolean addInformation(Info info) {
        return this.infoList.add(info);
    }

    public boolean deleteInformation(Info info) {
        return this.infoList.remove(info);
    }
}
