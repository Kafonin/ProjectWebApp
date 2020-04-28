package com.appointments.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Appointment
 */
@Entity
public class Appointment 
{
    @Id
    private @GeneratedValue Long    id;
    private                 String  firstNameString;
    private                 String  lastNameString;
    private                 String  carBrandString;
    private                 String  carModelString;
    private                 int     carYearInt;

    protected Appointment() {}

    public Appointment(String firstNameString, String lastNameString, String carBrandString, 
                        String carModelString, int carYearInt)
    {
        this.firstNameString    =   firstNameString;
        this.lastNameString     =   lastNameString;
        this.carBrandString     =   carBrandString;
        this.carModelString     =   carModelString;
        this.carYearInt         =   carYearInt;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getFirstNameString() 
    {
        return firstNameString;
    }
    
    public void setFirstNameString(String firstNameString)
    {
        this.firstNameString = firstNameString;
    }

    public String getLastNameString()
    {
        return lastNameString;
    }

    public void setLastNameString(String lastNameString) 
    {
        this.lastNameString = lastNameString;
    }

    public String setCarBrandString()
    {
        return carBrandString;
    }

    public void getCarBrandString(String carBrandString)
    {
        this.carBrandString = carBrandString;
    }

    public String getCarModelString() 
    {
        return carModelString;
    }

    public void setCarModelString(String carModelString) 
    {
        this.carModelString = carModelString;
    }

    public int getCarYearInt()
    {
        return carYearInt;
    }

    public void setCarYearInt(int carYearInt) 
    {
        this.carYearInt = carYearInt;
    }
}