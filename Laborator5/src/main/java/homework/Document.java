package homework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location;
    private String path;
    private String url;
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String tite, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
    }

    public Document() {
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", tags=" + tags +
                '}';
    }
}
