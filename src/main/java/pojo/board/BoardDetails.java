package pojo.board;


public class BoardDetails {
    public String id;
    public String name;
    public String desc;
    public Object descData;
    public boolean closed;
    public String idOrganization;
    public Object idEnterprise;
    public boolean pinned;
    public String url;
    public String shortUrl;
    public Preferences prefs;
    public LabelNames labelNames;
    public Limits limits;

    public BoardDetails(String name, String desc, Preferences prefs) {
        this.name = name;
        this.desc = desc;
        this.prefs = prefs;
    }

    public BoardDetails() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public void setIdEnterprise(Object idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setPrefs(Preferences prefs) {
        this.prefs = prefs;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    public Preferences getPrefs() {
        return prefs;
    }
}
