package pl.org.opi.sdsm.app.simplerepo.model.config;

import lombok.Data;

@Data
public class ConfigModel {
    private String databaseUrl;
    private String databaseUser;
    private String databasePass;
}
