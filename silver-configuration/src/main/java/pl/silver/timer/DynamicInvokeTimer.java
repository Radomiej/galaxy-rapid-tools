package pl.silver.timer;

public class DynamicInvokeTimer {
	
	private long lastFireTime;
	private long timeToUpdate;
	
	public DynamicInvokeTimer(long timeToUpdate){
		this.timeToUpdate = timeToUpdate;
	}
	
	public boolean canFire(){
		return lastFireTime + timeToUpdate < System.currentTimeMillis() ? returnTrue() : false;
	}

	private boolean returnTrue() {
		lastFireTime = System.currentTimeMillis();
		return true;
	}
}
