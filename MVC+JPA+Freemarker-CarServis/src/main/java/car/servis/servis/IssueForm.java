package car.servis.servis;

import javax.validation.constraints.Size;

public class IssueForm {
    @Size(min = 1, max = 20)
    private String title;
    @Size(min = 20, max = 200)
    private String content;

    public IssueForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public IssueForm() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
