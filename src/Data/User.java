package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="role")
    private String role;
    @XmlElement(name="username")
    private String username;
    @XmlElement(name="password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    @Override
    public String toString() {
        return "Role: "+this.role+" Name: " + this.name+" UserName: "+this.username+" Password: "+this.password;
    }
}
