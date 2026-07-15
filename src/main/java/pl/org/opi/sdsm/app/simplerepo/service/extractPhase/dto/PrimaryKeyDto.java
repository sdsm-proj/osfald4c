package pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto;

import lombok.Data;

@Data
public class PrimaryKeyDto {
    private String columnName;
    private String pkName;
    private String keySeq;
}
