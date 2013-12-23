package com.anyonecantest.jenkins.plugins.mypeople;

import hudson.model.User;
import hudson.plugins.im.IMConnection;
import hudson.plugins.im.IMConnectionListener;
import hudson.plugins.im.IMException;
import hudson.plugins.im.IMMessageTarget;
import hudson.plugins.im.IMPresence;

import java.io.IOException;


final class GcmImConnection implements IMConnection {

    private static final GcmImConnection INSTANCE = new GcmImConnection();

    static GcmImConnection getInstance() {
        return INSTANCE;
    }

    @Override
    public void send(IMMessageTarget target, String text) throws IMException {
    	
        GcmMessageTarget gcmTarget = (GcmMessageTarget) target;
        String buddyId = gcmTarget.getBuddyId();

		try {
			
			//MyPeople.setAPIKEY("4200547f3ebd3d29061cc9ee456b266252de1271");
			//MyPeople.sendMessage("BU_lQaA7mh5f5bCAq_5lz7aOw00", text);
			
			String apikey = GcmPublisher.DESCRIPTOR.getApiKey();
			MyPeople.setAPIKEY(apikey);
			boolean bSuccess = MyPeople.sendMessage(buddyId, text);
			
			
			if (bSuccess == false) {
				throw new IMException("sending error");
			}
		}catch (Exception e) {
			throw new IMException(e);
		}

    }


    @Override
    public boolean connect() {
        // Do nothing!
        return true;
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public void setPresence(IMPresence presence, String statusMessage)
            throws IMException {
        // Not required
    }

    @Override
    public void addConnectionListener(IMConnectionListener listener) {
        // Not required
    }

    @Override
    public void removeConnectionListener(IMConnectionListener listener) {
        // Not required
    }

    @Override
    public void close() {
        // Not required
    }

}
