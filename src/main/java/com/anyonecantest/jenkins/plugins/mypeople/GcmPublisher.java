package com.anyonecantest.jenkins.plugins.mypeople;

import hudson.Extension;
import hudson.model.User;
import hudson.plugins.im.IMConnection;
import hudson.plugins.im.IMException;
import hudson.plugins.im.IMMessageTarget;
import hudson.plugins.im.IMMessageTargetConversionException;
import hudson.plugins.im.MatrixJobMultiplier;
import hudson.plugins.im.IMPublisher;
import hudson.plugins.im.build_notify.BuildToChatNotifier;

import java.util.List;



public final class GcmPublisher extends IMPublisher {

    @Extension
    public static final GcmPublisherDescriptor DESCRIPTOR = new GcmPublisherDescriptor();

    GcmPublisher(List<IMMessageTarget> targets, String notificationStrategy,
            boolean notifyGroupChatsOnBuildStart, boolean notifySuspects, boolean notifyCulprits,
            boolean notifyFixers, boolean notifyUpstreamCommitters,
            BuildToChatNotifier buildToChatNotifier, MatrixJobMultiplier matrixJobMultiplier)
            throws IMMessageTargetConversionException {
        super(targets, notificationStrategy, notifyGroupChatsOnBuildStart, notifySuspects,
                notifyCulprits, notifyFixers, notifyUpstreamCommitters, buildToChatNotifier,
                matrixJobMultiplier);
    }

    @Override
    public GcmPublisherDescriptor getDescriptor() {
        return GcmPublisher.DESCRIPTOR;
    }

    @Override
    protected IMConnection getIMConnection() throws IMException {
        return GcmImConnectionProvider.getInstance().currentConnection();
    }

    @Override
    protected String getPluginName() {
        // Used in log messages
        return "MyPeople";
    }

    @Override
    protected String getConfiguredIMId(User user) {
    	return null;
	
    }

}
