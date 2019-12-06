package Organizador;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {
    private Properties properties = new Properties();
    private String domain, user, password, owner, listaBlanca; //Datos necesarios
    private OutputStream outputStream; //Escribir datos
    private InputStream inputStream; //Leer datos

    public String getDomain() {
        return domain;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getOwner() {
        return owner;
    }

    public PropertiesManager(String domain, String user, String password) throws IOException {
        this.domain = domain;
        this.user = user;
        this.password = password;

        getOutputstream();
        System.out.println("INFO: Creando archivo de configuración");

        properties.setProperty("dominio", domain);
        properties.setProperty("usuario", user);
        properties.setProperty("password", password);
        properties.store(outputStream, "CONFIGURACION DE REGISTRO");
        outputStream.close();
    }

    public PropertiesManager() throws IOException {
        getInputstream();
        this.domain = properties.getProperty("dominio");
        this.user = properties.getProperty("usuario");
        this.password = properties.getProperty("password");
        inputStream.close();
    }

    private void getOutputstream() throws FileNotFoundException {
        this.outputStream = new FileOutputStream(System.getProperty("user.dir") + "/config.properties");
    }

    private void getInputstream() throws IOException {
        this.inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
        this.properties.clear();
        this.properties.load(inputStream);
    }

}
