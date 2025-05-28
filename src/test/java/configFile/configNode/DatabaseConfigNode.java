package configFile.configNode;

import javax.xml.bind.annotation.XmlElement;

public class DatabaseConfigNode {

    @XmlElement(name="Port")
    public String port;
    @XmlElement(name = "DatabaseName")
    public String databaseName;
    @XmlElement(name = "Username")
    public String username;
    @XmlElement(name = "Password")
    public String password;

}
