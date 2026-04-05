package domain;

import java.util.Date;

public class Post {
    private final String id;
    private final String idUser;
    private String title;
    private String content;
    private final Date dateCreate;
    private Date dateUpdate;

    public Post(String id, String idUser, String title, String content, Date dateCreate, Date dateUpdate) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.content = content;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }
}
