package workshop.jdi_common.enums;

/**
 * Created by Tit.
 */
public enum HeaderMenu {
    HOME, CONTACT_FORM, SERVICE, METALSиCOLORS;

    @Override
    public String toString() {
        return name().replaceAll("и", " & ");
    }
}
