package com.online.videostreaming.classrooms.onlineclassrooms.common;

public final class Version {
	private static final int MAJOR = 0;
	private static final int MINOR = 1;
	private static final int PATCH = 0;

	
	public static final long SERIAL_VERSION_UID = getVersion().hashCode();

	public static String getVersion() {
		return MAJOR + "." + MINOR + "." + PATCH;
	}
}

