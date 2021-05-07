package md.weatherAdventure.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToOne
    @JoinColumn(name = "ROLE")
    private RoleEntity roleEntity;
    @ManyToOne()
    @JoinColumn(name = "USER_DETAIL_ID")
    private UserDetailEntity userDetailEntityId;
    @Column(name = "ACTIVE")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserDetailEntity getUserDetailEntityId() {
        return userDetailEntityId;
    }

    public void setUserDetailEntityId(UserDetailEntity userDetailEntityId) {
        this.userDetailEntityId = userDetailEntityId;
    }
}
