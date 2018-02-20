package workshop.jdi_common.enums;

/**
 * Created by Tit.
 */
public enum HeaderMenu {
    HOME, CONTACT_FORM, SERVICE, METALS$COLORS;

    @Override
    public String toString() {
        return name().replaceAll("\\$", " & ");
    }
}
