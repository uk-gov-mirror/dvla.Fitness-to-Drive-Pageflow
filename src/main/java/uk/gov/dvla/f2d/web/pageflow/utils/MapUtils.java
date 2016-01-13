package uk.gov.dvla.f2d.web.pageflow.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.gov.dvla.f2d.web.pageflow.model.MedicalForm;

import java.io.IOException;

public final class MapUtils
{
    public static MedicalForm mapStringToModel(final String jsonModel) throws IOException {
        return new ObjectMapper().readValue(jsonModel, MedicalForm.class);
    }

    public static String mapModelToString(MedicalForm form) throws JsonProcessingException{
        return new ObjectMapper().writeValueAsString(form);
    }
}