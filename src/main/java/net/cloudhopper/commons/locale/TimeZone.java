package net.cloudhopper.commons.locale;

import java.io.IOException;

/**
 * Represents a TimeZone that be used with either the DateTime joda classes
 * or with the JVM TimeZone class.  Useful for displaying a list of timezones
 * to a user.
 */
public final class TimeZone implements Comparable {

    private String id;
    private String standardOffsetTime;

    /**
     * Constructs a new TimeZone.
     * @param id The TimeZone id such as "America/Los_Angeles"
     * @param standardOffsetTime The string representing the standard offset from UTC
     *          such as "-08:00" for "America/Los_Angeles"
     */
    protected TimeZone(String id, String standardOffsetTime) {
        this.id = id;
        this.standardOffsetTime = standardOffsetTime;
    }

    /**
     * Returns the id of this TimeZone such as "America/Los_Angeles"
     * @return The id of this TimeZone such as "America/Los_Angeles"
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns a String representing the offset from GMT for this timezone
     * such as "-08:00" for "America/Los_Angeles".
     * @return
     */
    public String getStandardOffsetTime() {
        return this.standardOffsetTime;
    }

    /**
     * Returns a name to display for this TimeZone such as "America/Los_Angeles (GMT-08:00)"
     * @return The display name of this TimeZone such as "America/Los_Angeles (GMT-08:00)"
     */
    public String getDisplayName() {
        return this.id + " (GMT" + this.standardOffsetTime + ")";
    }

    /**
     * Compares a timezone based on id (String comparison).
     */
    public int compareTo(TimeZone tz) {
        return id.compareTo(tz.id);
    }

    public int compareTo(String tzId) {
        return id.compareTo(tzId);
    }

    public int compareTo(Object o) {
        if (o instanceof String) {
            return compareTo((String)o);
        } else {
            return compareTo((TimeZone) o);
        }
    }
    
    /**
     * Tests if a TimeZone is equal to another.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TimeZone)) {
            return false;
        } else if (o instanceof String) {
            return (compareTo((String)o) == 0);
        } else {
            return (compareTo((TimeZone)o) == 0);
        }
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
