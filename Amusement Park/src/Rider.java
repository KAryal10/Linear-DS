import java.util.ArrayList;
import java.util.List;

public class Rider
{
    private String name; // the rider's name
    private List<String> rides; // the rides they rode on

    /**
     * Creates a Rider with the specified name and initializes
     * an empty list of rides ridden on by the rider.
     * @param name Name of the rider
     */
    public Rider(String name)
    {
        this.name = name;
        this.rides = new ArrayList<String>();
    }
    
    public String getName()
    {
    	return name;
    }
    
    public void rememberRide(String s)
    {
    	rides.add(s);
    }

    public int getRideCount()
    {
    	return rides.size();
    }
    
    @Override
    public String toString()
    {
    	String display = "";
    	display += name;
    	display += " ";
    	display += String.valueOf(rides.size());
    	return display;
    }
    
}