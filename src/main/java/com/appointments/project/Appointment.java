package com.appointments.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Appointment
 */
@Entity
@Table(name = "appointment")
public class Appointment 
{
    @Id
    @Column(name = "id", nullable = false)
    private @GeneratedValue Long id;

    @Column(name = "first_name")
    private String firstNameString;

    @Column(name = "last_name")
    private String lastNameString;

    @Column(name = "car_brand")
    private String carBrandString;

    @Column(name = "car_model")
    private String carModelString;

    @Column(name = "car_year", nullable = true)
    private String carYearString;

    @Column(name = "appointment_time")
    private int appointmentTimeInt;

    protected Appointment() {}

    public Appointment(String firstNameString, String lastNameString, String carBrandString, 
                        String carModelString, String carYearString)
    {
        this.firstNameString    =   firstNameString;
        this.lastNameString     =   lastNameString;
        this.carBrandString     =   carBrandString;
        this.carModelString     =   carModelString;
        this.carYearString      =   carYearString;
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

    public String getCarYearInt()
    {
        return carYearString;
    }

    public void setCarYearInt(String carYearString) 
    {
        this.carYearString = carYearString;
    }

    public int getAppointmentTimeInt() {

        return appointmentTimeInt;
    }

    public void setAppointmentTimeInt(int appointmentTimeInt) {

        this.appointmentTimeInt = appointmentTimeInt;
    }
}