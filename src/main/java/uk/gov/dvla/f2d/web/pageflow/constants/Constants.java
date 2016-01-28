package uk.gov.dvla.f2d.web.pageflow.constants;

public class Constants
{
    /**
     * Define a list of all the supported services within this module.
     */
    public static final String[] SUPPORTED_SERVICES = {
        "notify"
    };

    public static final String NOTIFY_SERVICE = SUPPORTED_SERVICES[0];

    /**
     * Constants relating to stream loading and file naming conventions.
     */
    public static final String PAGEFLOW_PREFIX     = "pageflow";
    public static final String JSON_SUFFIX         = ".json";

    /**
     * Process the data model types required for validation and aggregation.
     */
    public static final String RADIO               = "Radio";
    public static final String CHECKBOX            = "CheckBox";
    public static final String FORM                = "Form";
    public static final String CONTINUE            = "Continue";

    /**
     * These are error/notification level constants used for validation.
     */
    public static final String EMPTY_STRING        = "";

    public static final String COMMA_SYMBOL        = ",";
    public static final String EQUALS_SYMBOL       = "=";
    public static final String HYPHEN_SYMBOL       = "-";
}