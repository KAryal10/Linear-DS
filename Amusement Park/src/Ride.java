import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Ride
{
    private String name;          // Name of the ride
    private int peoplePerLoad;    // Riders per load
    private int waitTimePerLoad;  // Time to wait between loads
    private int lastLoadStarted;  // Time the last group loaded
    private int riderCount;       // Riders in current load
    private int totalLoadCount;   // Number of loads of riders
    private int totalRiderCount;  // Total riders for the day

    private Queue<Rider> queue;   // Waiting line queue for the ride

    /**
     * Creates a ride using its name, number of people that fit in each load
     * on the ride, and how long each load lasts (how long to wait between rides).
     * @param name Name of the ride
     * @param peoplePerLoad People on each load of the ride
     * @param waitTimePerLoad How long the wait is between loads on the ride
     */
    public Ride(String name, int peoplePerLoad, int waitTimePerLoad)
    {
        this.name = name;
        this.peoplePerLoad = peoplePerLoad;
        this.waitTimePerLoad = waitTimePerLoad;
        this.lastLoadStarted = 0;
        this.riderCount = 0;
        this.totalLoadCount = 0;
        this.totalRiderCount = 0;
        this.queue = new LinkedList<Rider>();
    }

    /**
     * Gets the name of this ride.
     * @return Name of the ride
     */
    public String getName()
    {
        return name;
    }

    /**
     * Checks to see if the ride is available, meaning that it had a previous load
     * of riders on the ride and the ride just finished this second.
     * @param time Current clock time in the park
     * @return true if a load finished and the ride is available for more riders, false otherwise
     */
    public boolean available(int time)
    {
        return lastLoadStarted != time && (time % waitTimePerLoad == 0);
    }

    /**
     * Gets the current waiting time for this ride in seconds.
     * @return Seconds a rider entering the line for this ride will have to wait before riding
     */
    public int getWaitTime()
    {
        int peopleInLine = queue.size();
        int loads = (int)Math.ceil((double)peopleInLine / peoplePerLoad);
        int waitTime = loads * waitTimePerLoad;
        return waitTime;
    }

    public List<Rider> exitRide()
    {
    	List<Rider> display = new LinkedList<Rider> ();
    	for(int i=0;i<riderCount;i++)
    	{
    		display.add(queue.remove());
    	}
    	return display;
    }
    
    public void enterLine(Rider e )
    {
    	queue.add(e);
    }
    
    public void loadRide(int time)
    {
    	lastLoadStarted = time;
    	if(queue.size()>peoplePerLoad)
    		riderCount = peoplePerLoad;
    	else
    		riderCount = queue.size();
    	
    	totalRiderCount += riderCount;
    	totalLoadCount++;
    }
    
    public int getTotalRiderCount()
    {
    	return totalRiderCount;
    }
    
    public int getTotalLoadCount()
    {
    	return totalLoadCount;
    }
    
    @Override
    public String toString()
    {
    	String display = "[";
    	
    	display = display + name + " ";
    	String waitInMinute = String.valueOf(getWaitTime()/60);
    	display = display + waitInMinute +" min ";
    	String numberOfRider = String.valueOf(queue.size());
    	display = display + "("+numberOfRider+")] ";
    	
    	return display;
    }
    
    public int numberOfRiders()
    {
    	return queue.size();
    }
}