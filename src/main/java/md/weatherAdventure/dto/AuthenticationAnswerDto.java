package md.weatherAdventure.dto;

public class AuthenticationAnswerDto {
    private String userName;
    private String token;
    private String fio;
    private String roleName;
    private String roleCode;
    private String textError;
    public AuthenticationAnswerDto() {
    }

    public AuthenticationAnswerDto(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public AuthenticationAnswerDto(String textError) {
        this.textError = textError;
    }

    public AuthenticationAnswerDto(String userName, String token, String fio) {
        this.userName = userName;
        this.token = token;
        this.fio = fio;
    }

    public AuthenticationAnswerDto(String userName, String token, String fio, String roleName) {
        this.userName = userName;
        this.token = token;
        this.fio = fio;
        this.roleName = roleName;
    }

    public AuthenticationAnswerDto(String userName, String token, String fio, String roleName, String roleCode) {
        this.userName = userName;
        this.token = token;
        this.fio = fio;
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public AuthenticationAnswerDto(String userName, String token, String fio, String roleName, String roleCode, String textError) {
        this.userName = userName;
        this.token = token;
        this.fio = fio;
        this.roleName = roleName;
        this.roleCode = roleCode;
        this.textError = textError;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getTextError() {
        return textError;
    }

    public void setTextError(String textError) {
        this.textError = textError;
    }

}
