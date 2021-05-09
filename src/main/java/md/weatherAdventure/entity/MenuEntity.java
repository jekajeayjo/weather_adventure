package md.weatherAdventure.entity;

import javax.persistence.*;

@Entity
@Table(name = "MENU")
public class MenuEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne
    @JoinColumn(name = "PARENT_ID")
    MenuEntity parentId;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "URL")
    String url;
    @Column(name = "ICON")
    String icon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuEntity getParentId() {
        return parentId;
    }

    public void setParentId(MenuEntity parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
