package org.jenkinsci.plugins.gcm.im;

import hudson.model.User;
import hudson.plugins.im.IMMessageTarget;


import org.kohsuke.stapler.export.Exported;

final class GcmMessageTarget implements IMMessageTarget {

    private static final long serialVersionUID = 1L;

    private final String buddyId;

    /**
     * Creates a target who should receive notification messages.
     * 
     * @param buddyId My People buddy ID.
     */
    GcmMessageTarget(String buddyId) {
        this.buddyId = buddyId;
    }

    @Exported
    public String getBuddyId() {
        return buddyId;
    }

    /** @return Returns the configured GCM token for this target, or {@code null}. */
    String getToken() {
    	return null;
    	
    }

    @Override
    public String toString() {
        return getBuddyId();
    }

}
