
/**
 * Maman 12 - Using a class to represent a rent of a car between 2 dates
 * @author Ido Kander
 * @ID 208602367
 * Semester 2023A 
 */
public class Rent
{
    // instance variables 
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
    private final int A_PRICE = 100, B_PRICE = 150, C_PRICE = 180, D_PRICE = 240, DAYS_IN_WEEK = 7;
    private final double DISCOUNT = 0.9;
    
    //constructors
    /**
    * creates a new Rent object
    * @param _name the name of the person who rents
    * @param _car the car the person rents
    * @param _pickDate the pick-up date of the car the person rents
    * @param _returnDate the return date of the car the person rents 
    */
    public Rent(String name, Car car, Date pick, Date ret)
    {
        if (ret.after(pick))
        {
            _pickDate = pick;
            _returnDate = ret;
        }
        else
        {
            _pickDate = pick;
            _returnDate = pick.tomorrow();
        }
        _name = name;
        _car = car;
    }

    /**
     * copy constructor 
     * @param Rent other the rent to be copied 
     */
    public Rent (Rent other)
    {
        this(other._name, other._car, other._pickDate, other._returnDate);
    }
    
    /** gets the Car 
     * @return the car who's being rented 
     */
    public Car getCar()
    {
        return _car;
    }
    
    /** gets the Name 
     * @return the name of renter
     */
    public String getName()
    {
        return _name; 
    }
    
    /** gets the Pick-up Date 
     * @return the date the rent starts 
     */
    public Date getPickDate()
    {
        return _pickDate;
    }
    
    /** gets the Return Date 
     * @return the date the rent ends 
     */
    public Date getReturnDate()
    {
        return _returnDate;
    }
    
     /** sets the Car
     * @param car the value to be set
     */
    public void setCar(Car car)
    {
        _car = car;
    }
    
    /** sets the name of renter
     * @param name the value to be set 
     */
    public void setName(String name)
    {
        _name = name;
    }
    
     /** sets the Pick-up Date
     * @param pickDate the value to be set
     */
    public void setPickDate(Date pickDate)
    {
        if (pickDate.before(_returnDate))
            _pickDate = pickDate;
    }
    
     /** sets the Return Date
     * @param returnDate the value to be set
     */
    public void setReturnDate(Date returnDate)
    {
        if (returnDate.after(_pickDate))
            _returnDate = returnDate;
    }
    
    /**
    * checks if 2 rents are equal
    * @param Rent other to be compared to
    * @return true if the rent is equal according to  pick-up & return dates, name of renter 
    */
    public boolean equals(Rent other)
    { 
        return _name == other._name && _car == other._car && _pickDate == other._pickDate && _returnDate == other._returnDate;
    }
    /**
     * checks how many days are between the pick-up and return date of a specific rent
     * @return the number of days as an int 
     */
    public int howManyDays()
    {
        return _pickDate.difference(_returnDate);
    }
    
    /**
     * calculates the price of the rent 
     * @return the price of the rent as an int, according to type of car and number of days rented 
     */
    public int getPrice()
    {
      int rentDays = this.howManyDays(); // lets say you get 9 days 
      int weeksWithDiscount = rentDays / 7; // 9 / 7 as an int gives you 1 week of discount 
      int daysWithoutDiscount = (int)(rentDays % 7);  // 9%7 is 2 as you have 2 days left out of one week
      int price = 0;
      if (_car.getType() == 'A')
          price = (int)(weeksWithDiscount * A_PRICE * DISCOUNT * DAYS_IN_WEEK) + (daysWithoutDiscount * A_PRICE);
      if (_car.getType() == 'B')
          price = (int)(weeksWithDiscount * B_PRICE * DISCOUNT * DAYS_IN_WEEK) + (daysWithoutDiscount * B_PRICE);
      if (_car.getType() == 'C')
          price = (int)(weeksWithDiscount * C_PRICE * DISCOUNT * DAYS_IN_WEEK) + (daysWithoutDiscount * C_PRICE);
      if (_car.getType() == 'D')
          price = (int)(weeksWithDiscount * D_PRICE * DISCOUNT * DAYS_IN_WEEK) + (daysWithoutDiscount * D_PRICE); 
      return price;
    }
    
    /**
     * upgrades the type of the car and calculates the price of new rent
     * @param newCar is the car to be upgraded to 
     * @return the new price of the rent with the newCar
     */
    public int upgrade (Car newCar)
    {
        newCar = new Car(newCar);
        if (newCar.better(_car)) 
        {
            Rent newRent = new Rent (_name, newCar,_pickDate, _returnDate);
            return newRent.getPrice() - this.getPrice();
        }
        else
            return 0;
    }
    
    /**
     * checks if the is an overlap of 2 rents with the same name+same car
     * @param Rent other is the rent to be checked with 
     * @return a new Rent that combines the overlap into one logical rent
     */
    public Rent overlap (Rent other)
    {
        Date pick1, pick2, ret1, ret2;
        if (!_name.equals(other._name) || !_car.equals(other._car))
            return null;
        else 
        {
            if ((_pickDate.before(other._pickDate) && _returnDate.before(other._returnDate) && _returnDate.before(other._pickDate)))
                return null;
            else if ((other._pickDate.before(_pickDate) && other._returnDate.before(_returnDate) && other._returnDate.before(_pickDate)))
                return null;
            if(_pickDate.before(other._pickDate)) 
            {
                pick1 = _pickDate;
                pick2 = other._pickDate;
            }
            else 
            {
                pick1 = other._pickDate;
                pick2 = _pickDate;
            } 
             if(_returnDate.after(other._returnDate)) 
            {
                ret1 = _returnDate;
                ret2 = other._returnDate;
            }
            else 
            {
                ret1 = other._returnDate;
                ret2 = _returnDate;
            }
        }
        Rent rentAfterOverLap = new Rent(_name, _car, pick1, ret1);
        return rentAfterOverLap; 
    }
    
    /**
     * presents the rent as a string format 
     * @return a string who shows all the data of the rent 
     */
    public String toString()
    {
      return "Name:" + _name + " From:" + _pickDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice(); 
    }
}
    

