package my.safe.model;

import java.util.Objects;

public class Info {
    private String tile;
    private String content;

    public Info(String tile, String content) {
        this.tile = tile;
        this.content = content;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(tile, info.tile) &&
                Objects.equals(content, info.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tile, content);
    }
}
