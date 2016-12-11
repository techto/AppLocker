package com.balram.library;

import android.app.Application;

public class AppLocker {

	private volatile static AppLocker instance;
	private Locker curAppLocker;

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

	public void setAppLock(Locker appLocker) {
		if (curAppLocker != null) {
			curAppLocker.disable();
		}
		curAppLocker = appLocker;
	}

	public Locker getAppLock() {
		return curAppLocker;
	}
}
