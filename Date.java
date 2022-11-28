
/**
 * Maman 12 - Using a class to represent a given date in the Gregorian Calendar 0
 * @author Ido Kander
 * @ID 208602367
 * Semester 2023A 
 */
public class Date
{
    // instance variables
    private int _day;
    private int _month; 
    private int _year; 
    private final int DEFAULT_DAY = 1, DEFAULT_MONTH = 1, DEFAULT_YEAR = 2000;
    // constructors 
    /**
    * creates a new Date object
    * @param _day the day in the month(1-31)
    * @param _month the month in the year
    * @param _year the year (in 4 digits)
    */
    public Date(int day, int month, int year)
    {
        if (isValidDate(day, month, year) == true)
            {
                _day = day;
                _month = month;
                _year = year;
            } 
    }
    
    /**
    * Copy Constructor
    * @param date to be copied
    */
    public Date (Date other)
    {
         this(other._day, other._month, other._year);
    }
    
    /** gets the Day */
    public int getDay()
    {
        return _day;
    }
    
    /** gets the Month*/

    public int getMonth()
    {
        return _month;
    }
    
    /** gets the Year*/
    public int getYear()
    {
        return _year;
    }
    
    /** sets the Day
     * @param dayToSet the value to be set
     */
    public void setDay(int dayToSet)
    {    
        if (this.isValidDate(dayToSet, _month, _year) == true)
            _day = dayToSet;     
    }
    
    /** set the Month
     * @param dayToSet the value to be set
     */
     public void setMonth(int monthToSet)
    {
        if (this.isValidDate(_day, monthToSet, _year) == true)
            _month = monthToSet;
    }
    
    /** sets the Year
     * @param yearToSet the value to be Set 
     */
    public void setYear(int yearToSet)
    {
        if (this.isValidDate(_day, _month, yearToSet) == true)
        _year = yearToSet; 
    }
    
    /**
    * checks if 2 dates are equal
    * @param date2 to be compared to
    * @return true if date2 equals to date1
    */
    public boolean equals (Date other)
    {
          return (_day == other._day && _month == other._month && _year == other._year);
    }
    
    /**
    * checks if this date comes before a given date
    * @param date2 the given date
    * @return true if this date comes before date2
    */
     public boolean before (Date other)
    {
        if (_year < other._year)
            return true;
        else if (_year == other._year)
            if (_month < other._month)
                return true;
            else if (_month == other._month)
                if (_day < other._day)
                    return true;
                else 
                    return false;
            else 
                return false;
        else 
            return false;
    }
    
    /**
    * checks if this date comes after a given date
    * @param date2 the given date
    * @return true if this date comes after date2
    */
    public boolean after (Date other)
    {
        return other.before(this);
    }
    
    /**
     * checks the difference between dates
     * @param date2 the date to check the difference from
     * @return int who represents amount of days between 2 dates
     */
    public int difference (Date other)
    { 
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));  
    }
    
    /**
     * presents the date as a string
     */
    public String toString()
    {
        if (_month < 10)
        {
            if (_day < 10)
                return "0" + _day + "/0" + _month + "/" + _year;
            else
                return _day + "/0" + _month + "/" +_year;
        }
        else
        {
            if (_day < 10)
                return "0"+_day+"/" + _month+ "/" +_year;
            else
                return _day + "/" + _month+ "/" +_year;
        }
    }
    
    /**
     * calculates the date one day after the given date
     */
    public Date tomorrow()
    {
    Date other = new Date(_day, _month, _year);
        switch (other._month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10: if (other._day == 31)
                     {
                         other._day = 1;
                         ++other._month;
                         break;
                     }
                     else
                         ++other._day;
                         break;
            case 4:
            case 6:
            case 9:
            case 11: if (other._day == 30)
                     {
                         other._day = 1;
                         ++other._month;
                         break;
                     }
                     else 
                         ++other._day;
                         break;
            case 2: if (((other._year % 4 == 0 && (other._year % 100 != 0 || other._year % 400 != 0))))
                    { 
                        if (other._day == 29)
                        {
                            other._day = 1;
                            ++other._month;
                            break;
                        }
                        else
                            ++other._day;
                    }
                    else 
                        if (other._day == 28)
                        {
                            other._day = 1;
                            ++other._month;
                            break;
                        }
                        else
                            ++other._day;
                            break;                 
            case 12: if (other._day == 31)
                     {
                        other._day = 1;
                        other._month = 1;
                        ++other._year;
                        break;
                     }
                     else
                         ++other._day;
                         break;
        }
        return other;
    } 
    
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
        year--;
        month = month + 12;
        }
     return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }  
    
    private boolean isValidDate(int day,int month, int year)
    {
        if (year > 9999 || year < 1000 || month > 12 || month < 1)
            {
                return false;
            }
        else
            {
                switch(month)
                    {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: if (day >= 1 && day <= 31)
                        {
                            return true;
                        }
                    case 4:
                    case 6:
                    case 9:
                    case 11: if (day >= 1 && day <= 30)
                                {
                                    return true;
                                }  
                    case 2: if(((_year % 4 == 0 && (_year % 100 != 0 || _year % 400 != 0))))
                                {
                                    if (day >= 1 && day <= 29)
                                        return true;            
                                } 
                            else
                                {
                                    if (day >=1 && day <= 28)
                                        return true;
                                }
                    break;
                    }
            }
    return false;      
    }   
}
        
             
         
         
    
    

       
    
        
        
        
        
              
        
    
            
 
    
            
            
        
        
        
            
        
        
        
      


