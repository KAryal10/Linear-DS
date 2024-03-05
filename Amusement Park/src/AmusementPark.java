import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AmusementPark
{
    private final int VISITORS_ARRIVAL_TIME = 60; // Seconds between a group of visitors arriving
    private final int VISITORS_MAX_SIZE = 10; // Maximum number of visitors in each group

    private final int CAROUSEL_LOAD = 40; // riders per load
    private final int CAROUSEL_TIME = 360; // seconds between loads

    private final int COASTER_LOAD = 12;  // riders per load
    private final int COASTER_TIME = 45; // seconds between loads

    private final int CHAIRLIFT_LOAD = 2; // riders per load
    private final int CHAIRLIFT_TIME = 15; // seconds between loads

    private final int WALKING_LOAD = Integer.MAX_VALUE; // unlimited riders per load
    private final int WALKING_TIME = 240; // seconds to "walk" between rides


    private int time;              // current clock time (in seconds)
    private int closingTime;       // time the simulation ends
    private int checkWaitTimes;    // how often to report waiting times
    private int startLeaving;      // seconds before closing time when visitors start leaving
    private int stopArrivingTime;  // no visitors arrive after this time
    private int totalVisitors;     // total number of visitors who arrived
    private int totalRides;        // total number of visitor rides

    // Rides in the park
    private Ride coaster;
    private Ride chairlift;
    private Ride carousel;
    private Ride walking; // walking between rides counts as a "ride"

    // List of all available rides
    private List<Ride> rides;

    // Random number generator, used for number of arriving visitors
    private Random random;

    /**
     * Creates an AmusementPark instance.
     * @param closingTime The "closing time" is the duration of the simulation in seconds.
     * @param startLeaving Number of seconds before closing time visitors start leaving.
     * @param showWaitTimes How often to display wait time status.
     */
    public AmusementPark(int closingTime, int startLeaving, int showWaitTimes)
    {
        this.time = 0;
        this.closingTime = closingTime;
        this.startLeaving = startLeaving;
        this.checkWaitTimes = showWaitTimes;

        this.stopArrivingTime = (closingTime - time) / 2;
        this.totalVisitors = 0;
        this.totalRides = 0;
        this.random = new Random();

        // Set up the rides with their parameters
        this.coaster = new Ride("Coaster", COASTER_LOAD, COASTER_TIME);
        this.chairlift = new Ride("Chairlift", CHAIRLIFT_LOAD, CHAIRLIFT_TIME);
        this.carousel = new Ride("Carousel", CAROUSEL_LOAD, CAROUSEL_TIME);
        this.walking = new Ride("Walking", WALKING_LOAD, WALKING_TIME);

        this.rides = new ArrayList<Ride>();
        this.rides.add(coaster);
        this.rides.add(chairlift);
        this.rides.add(carousel);
    }


    /**
     * Simulates each second of the event clock. Each second, events that might occur
     * are visitors arriving at or leaving the park, rides being available with riders
     * exiting the ride and walking to another ride, and more riders entering a line.
     */
    private void clockTick()
    {
        if (time % checkWaitTimes == 0)
        {
            printStatus(getWaitTimeString());
        }

        // Every so often a number of visitors arrive and head for the shortest wait
        if (time < stopArrivingTime && time % VISITORS_ARRIVAL_TIME == 0)
        {
            int howMany = random.nextInt(VISITORS_MAX_SIZE) + 1;
            for (int i = 0; i < howMany; i++)
            {
                Rider newRider = new Rider("Visitor-" + (totalVisitors));
                walking.enterLine(newRider);
            }
            totalVisitors += howMany;
        }

        // Send walking riders to next ride or exit the park
        if (walking.available(time))
        {
            for (Rider rider : walking.exitRide())
            {
                // If it is before the time when people start leaving
                // go to another ride, otherwise don't (leave the park)
                if (time < closingTime - startLeaving)
                {
                    getRideWithShortestWait().enterLine(rider);
                }
                else
                {
                    totalRides += rider.getRideCount();
                    // Uncomment to display info about each visitor leaving the park
                    //this.printStatus("Departing " + rider);
                }
            }
        }

        // Unload rides that finished and send riders walking
        for (Ride ride : rides)
        {
            // This ride just finished this second so it is available.
            // Exit the last group of riders and start them walking.
            // Then, load the next group on this ride.
            if (ride.available(time))
            {
                List<Rider> finished = ride.exitRide();
                for (Rider rider : finished)
                {
                    rider.rememberRide(ride.getName()); // remember this ride
                    walking.enterLine(rider);
                }
                ride.loadRide(time);
            }
        }

        // Make any recent walkers start walking
        walking.loadRide(time);

        // Another second ticks by
        time++;
    }
    
    public void open()
    {
    	printStatus("Park is open!");
    	do
    	{
    		if(time == closingTime) {
    			printStatus("Park is closing....");
    			clockTick();
    		}
    		else
    		{
    			clockTick();
    		}
    		
    	}
    	while(time<=closingTime);
    	
    	do
    	{
    		if(time == closingTime) {
    			printStatus("Park is closing....");
    			clockTick();
    		}
    		else
    		{
    			clockTick();
    		}
    		
    	}
    	while(getVisitorsInParkCount()!=0);
    	
    }
    
    public void close()
    {
    	printStatus("Park is closed.");
    }
    
    public Ride getRideWithShortestWait()
    {
    	if(coaster.getWaitTime() <= chairlift.getWaitTime() && coaster.getWaitTime() <= carousel.getWaitTime())
    		return coaster;
    	else if(chairlift.getWaitTime() <= coaster.getWaitTime() && chairlift.getWaitTime() <= carousel.getWaitTime())
    		return chairlift;
    	else if( carousel.getWaitTime() <= coaster.getWaitTime() && carousel.getWaitTime() <= chairlift.getWaitTime()) 
    		return carousel;
    	else
    		return walking;
    }
    
    public String getWaitTimeString()
    {
    	return coaster.toString() + chairlift.toString() + carousel.toString() + walking.toString() + "[Park "+String.valueOf(getVisitorsInParkCount()) + "]";
    }
    
    public int getVisitorsInParkCount()
    {
    	return coaster.numberOfRiders() + chairlift.numberOfRiders() + carousel.numberOfRiders() + walking.numberOfRiders();
    }
    
    public void printDailyRecap()
    {
    	double coasterAvg = (double)coaster.getTotalRiderCount()/(double)coaster.getTotalLoadCount();
    	double chairliftAvg = (double)chairlift.getTotalRiderCount()/(double)chairlift.getTotalLoadCount();
    	double carouselAvg = (double)carousel.getTotalRiderCount()/(double)carousel.getTotalLoadCount();
    	
    	String coasterAverage = String.format("%.1f", coasterAvg);
    	String chairliftAverage = String.format("%.1f", chairliftAvg);
    	String carouselAverage = String.format("%.1f", carouselAvg);
    	
    	System.out.println("Here's how the day at the park went:");
    	System.out.println("The park had "+ totalVisitors + " visitors who rode " + totalRides + " rides averaging about " + totalRides/totalVisitors +" rides each" );
    	System.out.println("The Coaster had "+ coaster.getTotalRiderCount() + " riders in "+ coaster.getTotalLoadCount() 
    									+ " loads averaging "+coasterAverage+" riders each");
    	System.out.println("The Chairlift had "+ chairlift.getTotalRiderCount() + " riders in "+ chairlift.getTotalLoadCount() 
    									+ " loads averaging "+chairliftAverage +" riders each");
    	System.out.println("The Carousel had "+ carousel.getTotalRiderCount() + " riders in "+ carousel.getTotalLoadCount() 
    									+ " loads averaging "+carouselAverage +" riders each");
    }
    
    public void printStatus(String s)
    {
    	int hours=time/3600;
    	int minutes=(time%3600)/60;
    	int seconds= time%60;
    	
    	String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    	
    	String display = time+ " "+s;
    	System.out.println(display);
    }
}