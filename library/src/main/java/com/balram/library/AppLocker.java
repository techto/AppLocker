package com.balram.library;

import android.app.Application;

public class AppLocker {

	private volatile static AppLocker instance;
	private AppLock curAppLocker;

	public static AppLocker getInstance() {
		synchronized (AppLocker.class) {
			if (instance == null) {
				instance = new AppLocker();
			}
		}
		return instance;
	}

	public void enableAppLock(Application app) {
		if (curAppLocker == null) {
			curAppLocker = new AppLockImpl(app);
		}
		curAppLocker.enable();
	}

	public boolean isAppLockEnabled() {
		if (curAppLocker == null) {
			return false;
		} else {
			return true;
		}
	}

	public void setAppLock(AppLock appLocker) {
		if (curAppLocker != null) {
			curAppLocker.disable();
		}
		curAppLocker = appLocker;
	}

	public AppLock getAppLock() {
		return curAppLocker;
	}
}
