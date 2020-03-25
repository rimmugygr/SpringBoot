package car.servis.servis;

import car.servis.model.Issue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AplicationIssuesService implements IssuesService {

    private List<Issue> issues;

    public AplicationIssuesService() {
        this.issues = new ArrayList<>();
        issues.add(new Issue(1,"first issue", "small issue" , new Date()));
        issues.add(new Issue(2,"second issue", "big issue" , new Date()));
        issues.add(new Issue(3,"third issue", "small and big issue" , new Date()));
        issues.add(new Issue(4,"four issue", "another issue" , new Date()));

    }

    @Override
    public String getIssue() {
        return  "Some Issue";
    }

    @Override
    public List<Issue> listIssues() {
        return Collections.unmodifiableList(issues);
    }

    @Override
    public void addIssue(IssueForm issueForm) {
        issues.add(new Issue(issues.size()+1, issueForm.getTitle(),issueForm.getContent(),new Date()));
    }
}
