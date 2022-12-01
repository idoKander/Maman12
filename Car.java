/**
 * Maman 12 - Using a class to represent a car
 * @author Ido Kander
 * @ID 208602367
 * Semester 2023A 
 */

public class Car
{
    // instance variables
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;
    private final char DEFAULT_TYPE = 'A';
    private final int DEFAULT_ID = 9999999;
    
    // constructors 
    /**
    * creates a new Car object
    * @param _id the ID of car (7 digits number)
    * @param _type the type of the car (A/B/C/D)
    * @param _brand the brand of the car
    * @param _isManual tells if car is manual or auto gear 
    */
    public Car(int id, char type, String brand, boolean isManual)
    {
        if (id <= 9999999 && id >= 1000000)
            _id = id;
        else
            _id = DEFAULT_ID;
            
        if (type == 'A' || type == 'B' || type == 'C'|| type == 'D')
            _type = type;
        else
            _type = DEFAULT_TYPE;
        _brand = brand;
        _isManual = isManual;   
    }
    
    /** Copy Constructor
    * @param car to be copied
    */
    public Car(Car other)
    {
        this(other._id, other._type, other._brand, other._isManual);
    }
    
    /** gets the ID 
     * @return the id of the car
     */
    public int getId()
    {
        return _id;
    }
    
    /** gets the type 
     * @return the type of the car
     */
    public char getType()
    {
        return _type;
    }
    
    /** gets the brand
     * @return the brand of the car
     */
    public String getBrand()
    {
        return _brand;
    }
    
    /** returns if car's gear is manuel 
     * @return true or false, if the gear of the car is manuel 
     */
    public boolean isManual()
    {
        return _isManual;
    }
    
     /** sets the ID
     * @param id the value to be set
     */
    public void setId(int id)
    {
        if (id <= 9999999 && id >= 1000000)
            _id = id;
    }
    
     /** sets the type
     * @param type the value to be set
     */
    public void setType(char type)
    {
        if (type == 'A' || type == 'B' || type == 'C'|| type == 'D')
            _type = type;
    }
    
     /** sets the brand
     * @param brand the value to be set
     */
    public void setBrand(String brand)
    {
        _brand = brand;
    }
    
     /** sets the gear to manuel or auto
     * @param isManual the value to be set
     */
    public void setIsManual(boolean isManual)
    {
        _isManual = isManual;
    }
    
    /**
     * presents the date as a string
     * @return a string represents all of the objects of the car
     */
    public String toString()
    {
        if (_isManual == true)
        return "id:" + _id + " type:" + _type + " brand:" 
        + _brand + " gear:manual";
        else
        return "id:" + _id + " type:" + _type + " brand:" 
        + _brand + " gear:auto";
    }
    
    /**
    * checks if 2 cars are equal
    * @param car other to be compared to
    * @return true if car equals to car other 
    */
    public boolean equals (Car other)
    {
        return _type == other._type && _brand.equals(other._brand) && _isManual == other._isManual;    
    }
    
    /**
     * checks if one date is better then another
     * @param car other to be compared to 
     * @return true if a car is better then car other, according to specific conditions 
     */
    public boolean better (Car other)
    {
        if (_type > other._type)
        return true;
        else if (_type < other._type)
        return false;
        else if ( _type == other._type && _isManual == false && other._isManual == true)
            return true;
        else
            return false;        
    }
    
    /**
     * checks if one date is worse then another
     * @param car other to be compared to 
     * @return true if a car is worse then car other, according to specific conditions 
     */
    public boolean worse (Car other)
    {
        return other.better(this);
    }
}

  

